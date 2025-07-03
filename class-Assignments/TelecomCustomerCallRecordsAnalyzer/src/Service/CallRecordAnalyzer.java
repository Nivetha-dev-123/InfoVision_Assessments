package Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import Model.CallRecord;

public class CallRecordAnalyzer {
   private List<CallRecord> records=new ArrayList<>();
   
   public void addRecord(CallRecord record) {
	   records.add(record);
   }
   
   public List<CallRecord> getLongestCalls(int limit){
	   return records.stream().
			   sorted(Comparator.comparingLong(CallRecord::getDurationInSeconds).reversed())
			   .limit(limit).collect(Collectors.toList());
	}
   
   public Map<String,Long> getCallFrequencyBycaller(){
	   return records.stream()
			   .collect(Collectors.groupingBy(CallRecord::getCaller,Collectors.counting()));
   }
   
   public Map<String,List<CallRecord>> groupByOperator(){
	   return records.stream().collect(Collectors.groupingBy(CallRecord::getOperator));
   }
   
   public Map<String, List<CallRecord>> groupByLocation() {
       return records.stream()
               .collect(Collectors.groupingBy(CallRecord::getLocation));
   }
   
   public List<CallRecord> filterByDurationGreaterThan(long seconds) {
       return records.stream()
               .filter(r -> r.getDurationInSeconds() > seconds)
               .collect(Collectors.toList());
   }
   
	
	
	
	
}
