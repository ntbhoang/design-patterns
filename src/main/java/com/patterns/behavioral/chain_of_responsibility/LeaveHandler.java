package com.patterns.behavioral.chain_of_responsibility;

public abstract class LeaveHandler {

    protected LeaveHandler supervisor;

    public void setSupervisor(LeaveHandler supervisor) {
        this.supervisor = supervisor;
    }

    public abstract String applyLeave(LeaveRequest leaveRequest);
}


// Concrete class to handle leave request
class TeamLead extends LeaveHandler {


    //"reasonType" is not going to be considered under TeamLeader & ProjectLeader
    //Team Leader can approve up to 7 days, otherwise it will pass to the Project Leader
    @Override
    public String applyLeave(LeaveRequest leaveRequest) {
        String temp = "";
        if (leaveRequest.getNumberOfDays() <= 7) {
            //Employee tier should be 4 or above to get approved
            temp = leaveRequest.getEmpTier() <= 4 ? "Leave approved by Team Lead" : "Your employee tier is not eligible for leave approval "
                    + leaveRequest.getNumberOfDays() +  " days";
        } else {
            return supervisor.applyLeave(leaveRequest);
        }
        return temp;
    }
}


class ProjectLeader extends LeaveHandler {

    //Project Leader can approve up to 15 days, otherwise it will pass to the HR
    @Override
    public String applyLeave(LeaveRequest leaveRequest) {
        String temp = "";
        if (leaveRequest.getNumberOfDays() <= 14) {
            //Employee tier should be 6 or above to get approved
            temp = leaveRequest.getEmpTier() <= 3 ? "Leave approved by Project Leader" : "Your employee tier is not eligible for leave approval "
                    + leaveRequest.getNumberOfDays() +  " days";
        } else {
            return supervisor.applyLeave(leaveRequest);
        }
        return temp;
    }
}


class HR extends LeaveHandler {

    //HR can approve up to 30 days
    @Override
    public String applyLeave(LeaveRequest leaveRequest) {

        //HR can approve up to 21 days, otherwise it will pass to the Manager
        if(leaveRequest.getNumberOfDays() <= 21){
            //Employee tier should be 3 or above & reason type should not be "Regular" to get approved
            if(leaveRequest.getEmpTier() <= 3 && !leaveRequest.getReason().equals(ReasonType.REGULAR)){
                return "Your leave days has been APPROVED by HR";
            }else{
                return "Your leave request has been DENIED by HR";
            }
        }else{
            return supervisor.applyLeave(leaveRequest);
        }
    }
}


enum ReasonType {
    REGULAR,CRITICAL,SPECIAL
}


class  LeaveRequest {
    private int numberOfDays;
    private int empTier;
    private ReasonType reason;

    public LeaveRequest(int numberOfDays, int empTier, ReasonType reason) {
        this.numberOfDays = numberOfDays;
        this.empTier = empTier;
        this.reason = reason;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public int getEmpTier() {
        return empTier;
    }

    public ReasonType getReason() {
        return reason;
    }
}


class Demo {
    public static void main(String[] args) {
        LeaveHandler teamLead = new TeamLead();
        LeaveHandler projectLeader = new ProjectLeader();
        LeaveHandler hr = new HR();

        teamLead.setSupervisor(projectLeader);
        projectLeader.setSupervisor(hr);

        LeaveRequest leaveRequest = new LeaveRequest(10, 4, ReasonType.REGULAR);
        System.out.println(teamLead.applyLeave(leaveRequest));

        LeaveRequest leaveRequest1 = new LeaveRequest(14, 2, ReasonType.REGULAR);
        System.out.println(teamLead.applyLeave(leaveRequest1));

        LeaveRequest leaveRequest2 = new LeaveRequest(21, 2, ReasonType.CRITICAL);
        System.out.println(teamLead.applyLeave(leaveRequest2));

        LeaveRequest leaveRequest3 = new LeaveRequest(10, 2, ReasonType.SPECIAL);
        System.out.println(teamLead.applyLeave(leaveRequest3));

    }
}