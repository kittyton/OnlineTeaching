package com.teaching.global;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.teaching.model.*;
public class UnReadManager {
	private static UnReadManager unReadManager = null;
	private static HashMap<Integer,List<Integer>> unread = new HashMap<Integer,List<Integer>>();
	private UnReadManager(){

	}
	public static UnReadManager getInstance(){
		if(unReadManager == null){
			synchronized(UnReadManager.class){
				if(unReadManager ==null){
					unReadManager = new UnReadManager();
				}
			}
		}
		return unReadManager;
	}
	public void put(int userID, int questionID){
		if(unread.get(userID) == null){
			ArrayList<Integer> questions = new ArrayList<Integer>();
			questions.add(questionID);
			unread.put(userID, questions);
		}else{
			if(!unread.get(userID).contains(questionID))
				unread.get(userID).add(questionID);
		}
	}
	public int get(int userID){
		if(unread.get(userID) == null){
			return 0;
		}else{
			return unread.get(userID).get(0);
		}
	}
	public void remove(int userID, Integer questionID){
		if(unread.get(userID) != null){
			unread.get(userID).remove(questionID);
		}
	}
}