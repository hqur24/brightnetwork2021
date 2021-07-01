package com.google;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class VideoPlayer {

  private final VideoLibrary videoLibrary;

  public VideoPlayer() {
    this.videoLibrary = new VideoLibrary();
  }

  public void numberOfVideos() {
    System.out.printf("%s videos in the library%n", videoLibrary.getVideos().size());
  }

  public void showAllVideos()  {
    List<Video> videolist = videoLibrary.getVideos();
    videolist.sort(Comparator.comparing(Video::getTitle));

    System.out.println("Here's a list of all available videos:");

    for (int i=0; i<videolist.size(); i++) {
      String commatags = videolist.get(i).getTags().toString();
      System.out.println( (videolist.get(i).getTitle()) + " (" + videolist.get(i).getVideoId() + ") " + commatags.replace(",", "") );
    }

  }

  boolean isPlaying = false;
  boolean isPlayingPrevious = false;
  String previousVid = "";
  String currentVid = "";
  String namePrevious = "";


  public void playVideo(String videoId) {


    if (previousVid.equals(""))
    {
      for (int i=0; i<videoLibrary.getVideos().size(); i++)
      {
        if ((videoId.equals(videoLibrary.getVideos().get(i).getVideoId())))
        {
          isPlayingPrevious = false;
          isPlaying = true;
          currentVid = videoLibrary.getVideos().get(i).getTitle();
          previousVid = videoLibrary.getVideos().get(i).getTitle();
        }
      }
    }

    else {
      namePrevious = previousVid;

      for (int i=0; i<videoLibrary.getVideos().size(); i++)
      {
        if ((videoId.equals(videoLibrary.getVideos().get(i).getVideoId())))
        {
          isPlaying = true;
          isPlayingPrevious = true;
          currentVid = videoLibrary.getVideos().get(i).getTitle();
          previousVid = videoLibrary.getVideos().get(i).getTitle();
        }
        else {
          currentVid = "";
        }
      }
    }

    if (!currentVid.equals("") & isPlayingPrevious == false)
    {
      System.out.println("Playing video: " + currentVid);
    }
    else if (!currentVid.equals("") & isPlayingPrevious == true)
    {
      System.out.println("Stopping video: " + namePrevious);
      System.out.println("Playing video: " + currentVid);
    }
    else {
      System.out.println("Cannot play video: Video does not exist");
    }
    }


  public void stopVideo() {

    if (isPlaying == true & !currentVid.equals(""))
    {
      System.out.print("Stopping video: " + currentVid);
      isPlaying = false;
    }
    else if (isPlaying == false)
    {
      System.out.println("Cannot stop video: No video is currently playing");
    }

  }

  public void playRandomVideo() {
    Random r = new Random();
    int randomInt = r.nextInt(videoLibrary.getVideos().size()-1) + 1;
    String videoChosen = "";

    if (isPlayingPrevious == false)
    {
      System.out.println("Playing video: " + videoLibrary.getVideos().get(randomInt).getTitle()) ;
      videoChosen = videoLibrary.getVideos().get(randomInt).getTitle();
      isPlayingPrevious = true;
    }

    else {
      System.out.println("Stopping video: " + videoChosen);
      System.out.println("Playing video: " + videoLibrary.getVideos().get(randomInt).getTitle()) ;
      isPlayingPrevious = false;
    }
  }

  boolean isPaused;

  public void pauseVideo() {

    if (isPlaying == true & isPaused== false)
    {
      isPlaying = false;
      System.out.println("Pausing video: " + currentVid);
      isPaused = true;
    }
    else if (isPaused==true)
    {
      System.out.println("Video already paused: " + currentVid);
    }
  }

  public void continueVideo() {
    System.out.println("continueVideo needs implementation");
  }

  public void showPlaying() {
    System.out.println("showPlaying needs implementation");
  }

  public void createPlaylist(String playlistName) {
    System.out.println("createPlaylist needs implementation");
  }

  public void addVideoToPlaylist(String playlistName, String videoId) {
    System.out.println("addVideoToPlaylist needs implementation");
  }

  public void showAllPlaylists() {
    System.out.println("showAllPlaylists needs implementation");
  }

  public void showPlaylist(String playlistName) {
    System.out.println("showPlaylist needs implementation");
  }

  public void removeFromPlaylist(String playlistName, String videoId) {
    System.out.println("removeFromPlaylist needs implementation");
  }

  public void clearPlaylist(String playlistName) {
    System.out.println("clearPlaylist needs implementation");
  }

  public void deletePlaylist(String playlistName) {
    System.out.println("deletePlaylist needs implementation");
  }

  public void searchVideos(String searchTerm) {
    System.out.println("searchVideos needs implementation");
  }

  public void searchVideosWithTag(String videoTag) {
    System.out.println("searchVideosWithTag needs implementation");
  }

  public void flagVideo(String videoId) {
    System.out.println("flagVideo needs implementation");
  }

  public void flagVideo(String videoId, String reason) {
    System.out.println("flagVideo needs implementation");
  }

  public void allowVideo(String videoId) {
    System.out.println("allowVideo needs implementation");
  }
}