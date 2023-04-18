package main;

import java.awt.*;
import java.util.ArrayList;

public class Game implements Runnable {

    private GamePanel gamePanel;
    private Thread gameThread;
    private int width;
    private int height;

    private ArrayList<Slime> slimes;
    private Slime selectedSlime;
    public float slimeSpawnRate = Constants.FPS;
    private float slimeSpawnTime = 0;

    public int score = 0;
    public boolean startGame;
    public boolean gameOver;
    public boolean isZapGateEnabled = true;

    public Game(){
        width = Constants.WIDTH;
        height = Constants.HEIGHT;
        restart();

        Constants.playSound("./res/sounds/bgmusic.wav", -20, true);
    }

