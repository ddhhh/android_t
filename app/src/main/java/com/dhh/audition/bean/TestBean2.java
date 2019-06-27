package com.dhh.audition.bean;

public class TestBean2 {


    /**
     * name : hh
     * sex : 12
     * son : {"name":"hh son","age":1}
     */

    private String name;
    private int sex;
    private SonBean son;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public SonBean getSon() {
        return son;
    }

    public boolean isNotNullSon() {
        return son != null;
    }

    public void setSon(SonBean son) {
        this.son = son;
    }

    public static class SonBean {
        /**
         * name : hh son
         * age : 1
         */

        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }


}
