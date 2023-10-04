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
            } catch (IOException e) {
            }
        }

        public Image getImage() {
            return image;
        }
    }

        public static void main(String[] args) {
            MeepMeep meepMeep = new MeepMeep(600);

            RoadRunnerBotEntity myBot1 = new DefaultBotBuilder(meepMeep)
                    // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                    .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                    .followTrajectorySequence(drive ->
                            drive.trajectorySequenceBuilder(new Pose2d(-58.5, 12, 0))
                                    .forward(20)
                                    .waitSeconds(4)
                                    .back(10)
                                    .splineToSplineHeading(new Pose2d(-35, 45, Math.toRadians(270)), Math.toRadians(50))
                                    .waitSeconds(4)
                                    .strafeRight(27)
                                    .back(5)
                                    .build()
                    );
            RoadRunnerBotEntity myBot2 = new DefaultBotBuilder(meepMeep)
                    // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                    .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                    .followTrajectorySequence(drive ->
                            drive.trajectorySequenceBuilder(new Pose2d(58.5, 12, Math.toRadians(180)))
                                    .forward(20)
                                    .waitSeconds(4)
                                    .back(10)
                                    .splineToSplineHeading(new Pose2d(35, 45, Math.toRadians(270)), Math.toRadians(130))
                                    .waitSeconds(4)
                                    .strafeLeft(25)
                                    .back(5)
                                    .build()
                    );

            RoadRunnerBotEntity myBot3 = new DefaultBotBuilder(meepMeep)
                    // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                    .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                    .followTrajectorySequence(drive ->
                            drive.trajectorySequenceBuilder(new Pose2d(-58.5, -34.5, 0))
                                    .forward(20)
                                    .waitSeconds(4)
                                    .back(20)
                                    .waitSeconds(6)
                                    .strafeLeft(25)
                                    .splineToSplineHeading(new Pose2d(-35, 39.3, Math.toRadians(270)), Math.toRadians(50))
                                    .back(5.7)
                                    .build()
                    );
            RoadRunnerBotEntity myBot4 = new DefaultBotBuilder(meepMeep)
                    // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                    .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                    .followTrajectorySequence(drive ->
                            drive.trajectorySequenceBuilder(new Pose2d(58.5, -34.5, Math.toRadians(180)))
                                    .forward(20)
                                    .waitSeconds(4)
                                    .back(20)
                                    .waitSeconds(6)
                                    .strafeRight(25)
                                    .splineToSplineHeading(new Pose2d(35, 39.3, Math.toRadians(270)), Math.toRadians(130))
                                    .back(5.7)
                                    .build()
                    );

            meepMeep.setBackground(Background.FIELD_CENTERSTAGE_JUICE_DARK.getImage())
                    .setDarkMode(true)
                    .setBackgroundAlpha(0.75f)
                    .addEntity(myBot1)
                    .addEntity(myBot2)
                    .addEntity(myBot3)
                    .addEntity(myBot4)
                    .start();
        }
    }

