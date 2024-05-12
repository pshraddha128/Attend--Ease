package com.example.projectdraft1;

import java.util.ArrayList;

public class UserModal {

    // variables for our first name,
    // last name, email and avatar
    private final String id;
    private final String first_name;
    private final int OE_3;
    private final int OE_4;
    private final int DE_4;
    private final int DE_3;
    private final int MOBILE_APPLICATION_DEVELOPMENT;
    private final int MACHINE_LEARNING_ALGORITHMS;
    private final int SYSTEM_ADMINISTRATION;
    private final int SOFTWARE_PROJECT_MANAGEMENT;
    private final int INTERPERSONAL_SKILLS;


    public UserModal(String id, String first_name, int OE_3,int OE_4, int DE_4, int DE_3, int MOBILE_APPLICATION_DEVELOPMENT,  int	MACHINE_LEARNING_ALGORITHMS, int	SYSTEM_ADMINISTRATION, int	SOFTWARE_PROJECT_MANAGEMENT, int	INTERPERSONAL_SKILLS ) {
        this.id=id;
        this.first_name = first_name;
        this.OE_3 = OE_3;
        this.OE_4 = OE_4;
        this.INTERPERSONAL_SKILLS=INTERPERSONAL_SKILLS;
        this.DE_4 = DE_4;
        this.MACHINE_LEARNING_ALGORITHMS=MACHINE_LEARNING_ALGORITHMS;
        this.MOBILE_APPLICATION_DEVELOPMENT=MOBILE_APPLICATION_DEVELOPMENT;
        this.SOFTWARE_PROJECT_MANAGEMENT=SOFTWARE_PROJECT_MANAGEMENT;
        this.DE_3 = DE_3;
        this.SYSTEM_ADMINISTRATION=SYSTEM_ADMINISTRATION;
    }

    public String getId() {
        return id;
    }
    public String getFirst_name() {
        return first_name;
    }
    public int getOE_3() {
        return OE_3;
    }

    public int getOE_4() {
        return OE_4;
    }

    public int getDE_3() {
        return DE_3;
    }

    public int getDE_4() {
        return DE_4;
    }

    public int getMOBILE_APPLICATION_DEVELOPMENT() {
        return MOBILE_APPLICATION_DEVELOPMENT;
    }

    public int getINTERPERSONAL_SKILLS() {
        return INTERPERSONAL_SKILLS;
    }
    public int getSOFTWARE_PROJECT_MANAGEMENT() {
        return SOFTWARE_PROJECT_MANAGEMENT;
    }

    public int getSYSTEM_ADMINISTRATION() {
        return SYSTEM_ADMINISTRATION;
    }

    public int getMACHINE_LEARNING_ALGORITHMS() {
        return MACHINE_LEARNING_ALGORITHMS;
    }

    public ArrayList<Integer> getArray() {

        ArrayList<Integer> arr= new ArrayList<Integer>();
        arr.add(getOE_3());
        arr.add(getOE_4());
        arr.add(getDE_3());
        arr.add(getDE_4());
        arr.add(getMACHINE_LEARNING_ALGORITHMS());
        arr.add(getMOBILE_APPLICATION_DEVELOPMENT());
        arr.add(getSOFTWARE_PROJECT_MANAGEMENT());
        arr.add(getINTERPERSONAL_SKILLS());
        arr.add(getSYSTEM_ADMINISTRATION());
        return  arr;
    }


}
