// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeTime extends CommandBase {

  private final IntakeSubsystem intakeSubsystem;
  private double Time;

  Timer time = new Timer();
  /** Creates a new IntakeTime. */
  public IntakeTime(IntakeSubsystem intakeSubsystem, double Time) {
      this.intakeSubsystem = intakeSubsystem;
      this.Time = Time;

        addRequirements(intakeSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    intakeSubsystem.IntakeStop();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intakeSubsystem.Intake();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intakeSubsystem.IntakeStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return time.hasElapsed(Time);
  }
}
