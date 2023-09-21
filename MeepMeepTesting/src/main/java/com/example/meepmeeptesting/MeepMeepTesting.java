package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MeepMeepTesting {

    enum Background {
        FIELD_CENTERSTAGE_OFFICAL("Pictures/field-2023-official.png"),
        FIELD_CENTERSTAGE_JUICE("Pictures/field-2023-juice.png"),
        FIELD_CENTERSTAGE_JUICE_DARK("Pictures/field-2023-juice-dark.png");

        private Image image;

        Background(String imagePath) {
            try {
                image = ImageIO.read(new File(imagePath));
            }
            catch (IOException e) {}
        }

        public Image getImage() {
            return image;
        }

    }

    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(0, 0, 0))
                                .forward(30)
                                .turn(Math.toRadians(90))
                                .forward(30)
                                .turn(Math.toRadians(90))
                                .forward(30)
                                .turn(Math.toRadians(90))
                                .forward(30)
                                .turn(Math.toRadians(90))
                                .build()
                );

        meepMeep.setBackground(Background.FIELD_CENTERSTAGE_JUICE_DARK.getImage())
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}