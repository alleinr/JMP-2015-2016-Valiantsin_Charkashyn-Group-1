package com.epam.jmp.memory.runner;

import com.epam.jmp.memory.method.ReferenceTaker;

public class Runner {

	public static void main(String[] args) {

		new ReferenceTaker().takeAReference("Hahahaha");
	}

}
