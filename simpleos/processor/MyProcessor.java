package simpleos.processor;

import java.sql.Array;

import simpleos.memory.*;


public  class MyProcessor extends Processor {

    private MyMemory PC;    
    private MyMemory IR;    
    private MyMemory ACC;    

    private String[] memory_instruction = { "00110000", "00100000", "00110001", "00100001", "00010001" , "01010000" , "00100010", "00010010" , "01010001" , "00100011" , "00010011", "01010010", "00100100", "00010100", "01010011", "00100101"};
    private int[] memory_values = {0,0,0,0,0,0};
    private int PC_test=0;
    private String IR_test;
    private int ACC_test=0;


    public int fetch(){
        System.out.println("Processor is now fetching..");
        System.out.println("\t current pc counter: " + PC_test);
        IR_test = memory_instruction[PC_test];
        return 1;
    } 

    public int execute(){
        System.out.println("Processor is now execting..");
        String instruction = IR_test.substring(0,4); 
        int location = Integer.parseInt(IR_test.substring(4), 2);
        switch(instruction){
            case "0001":
                ACC_test = memory_values[location];
                System.out.println("\t Current Value of ACC: " + ACC_test);
                break;
            case "0010":
                memory_values[location] = ACC_test;
                System.out.println("\t value added to memory: " + ACC_test);
                for (int i : memory_values) {
                    System.out.println("\t " + i);
                  }    
                ACC_test = 0;
                break;
            case "0101":
                ACC_test = ACC_test + memory_values[location];  
                System.out.println("\t instruction is to ADD: " + location);
                break;
            case "0100":
                ACC_test = ACC_test - memory_values[location];  
                System.out.println("\t instruction is to SUBTRACT: " + location);
                break;
            case "0011":
                System.out.println("\t Value added to the ACC: " + location);
                ACC_test = location;
                break;
            case "0111":
                System.out.println("\t ACC value: " + ACC_test);
                break;
            default:
                break;
        }
        PC_test++;
        return 1;
    } 

} //end abstract class Processor
