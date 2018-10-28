package com.kmit.cardioworkouts;


/*import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;*/

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.slu.Intent;
import com.amazon.speech.slu.Slot;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.SessionEndedRequest;
import com.amazon.speech.speechlet.SessionStartedRequest;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.speechlet.SpeechletV2;
import com.amazon.speech.ui.Image;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;
import com.amazon.speech.ui.StandardCard;
//import com.amazon.speech.ui.SsmlOutputSpeech;






/**
* This sample shows how to create a Lambda function for handling Alexa Skill requests that:
 * @author tele
 *
 */
public class GreeterServiceSpeechlet implements SpeechletV2 {
private static final Logger log = LoggerFactory.getLogger(GreeterServiceSpeechlet.class);
//private String text;
//private Object voice_name;


@Override
public void onSessionStarted(SpeechletRequestEnvelope<SessionStartedRequest> requestEnvelope) {
    log.info("onSessionStarted requestId={}, sessionId={}", requestEnvelope.getRequest().getRequestId(),
            requestEnvelope.getSession().getSessionId());

    // any initialization logic goes here
}

@Override
public SpeechletResponse onLaunch(SpeechletRequestEnvelope<LaunchRequest> requestEnvelope) {
    log.info("onLaunch requestId={}, sessionId={}", requestEnvelope.getRequest().getRequestId(),
            requestEnvelope.getSession().getSessionId());

   
           
           
    /*final SsmlOutputSpeech speech = new SsmlOutputSpeech();
	final String SsmlText = Ssml(text);
	speech.setSsml(SsmlText);*/

   String sp="Welcome to ALEXA CARDIO WORKOUT SKILL ,\n"
		   +"\n Get ready to do the workout ";

  
        /*	String speechOutput =	   "<speak>"
        			+sp
        			+"<audio src='https://s3.amazonaws.com/examplebucket-one/cardio/tag1.mp3'/>"
        		   +"</speak>";
  */
    // If the user either does not reply to the welcome message or says
    // something that is not understood, they will be prompted again with this text.
    String repromptText = "For instructions on what you can say, please say help me.";
   
    // Here we are prompting the user for input
    return newAskResponse(sp,true, repromptText,false);
    
}

/*String Ssml(final String text)
{
	
	final String result = "<speak> " + text + " </speak>+sp";
	return result;
}*/

@Override
public SpeechletResponse onIntent(SpeechletRequestEnvelope<IntentRequest> requestEnvelope) {
    IntentRequest request = requestEnvelope.getRequest();
    log.info("onIntent requestId={}, sessionId={}", request.getRequestId(),
            requestEnvelope.getSession().getSessionId());

    Intent intent = request.getIntent();
    String intentName = (intent != null) ? intent.getName() : null;

    if ("workoutintent".equals(intentName)) {
        
		return getworkoutintent(intent);
    } else if ("AMAZON.HelpIntent".equals(intentName)) {
        return getHelp();
    } else if ("AMAZON.StopIntent".equals(intentName)) {
        PlainTextOutputSpeech outputSpeech = new PlainTextOutputSpeech();
        outputSpeech.setText("Goodbye");

        return SpeechletResponse.newTellResponse(outputSpeech);
    } else if ("AMAZON.CancelIntent".equals(intentName)) {
        PlainTextOutputSpeech outputSpeech = new PlainTextOutputSpeech();
        outputSpeech.setText("Goodbye");

        return SpeechletResponse.newTellResponse(outputSpeech);
    } else {
        String errorSpeech = "This is unsupported.  Please try something else.";
        return newAskResponse(errorSpeech, false, errorSpeech, false);
    }
}

@Override
public void onSessionEnded(SpeechletRequestEnvelope<SessionEndedRequest> requestEnvelope) {
    log.info("onSessionEnded requestId={}, sessionId={}", requestEnvelope.getRequest().getRequestId(),
            requestEnvelope.getSession().getSessionId());

    // any cleanup logic goes here
}

/**
 * Creates a {@code SpeechletResponse} for the RecipeIntent.
 * @param <image>
 *
 * @param intent
 *            intent for the request
 * @return SpeechletResponse spoken and visual response for the given intent
 */
private  SpeechletResponse getworkoutintent(Intent intent) {
	Image i=new Image();
	Slot nameSlot=intent.getSlot("day");
   
	String value=nameSlot.getValue();
           String responseText="try again";
       
        switch(value)
        {
        case  "Monday":
        	String s="https://s3.amazonaws.com/examplebucket-one/cardio/bodyweight-squat.gif";
            i.setLargeImageUrl(s);
        	responseText="Start the workout by doing 10 minutes of walking,jogging \n"
        			+"\n secondly do 10 squats\n" 
        			+"\n for that  ,\n"
        	        +"\n Place your feet on the ground\n "
        	        + "\n Keep your feet slightly wider and  Straighten your back. \n"
        	        +"\n  then next  ,\n"
        	        + "\n Bend your knees and  Keep your heels on the ground. \n"
        	        +"\n Pull in your abs and Lower yourself \n"
        	        +"\n From the lower position, push up off your heels and slowly rise up,\n"
        	        + "\n Extend your arms straight forward .\n"
        	        +"\n Do this repeatedly for 10 squats.  \n ";
        	
        	/*switchVoice(value,voice_name);
        	{
        		if((boolean) Monday)
        		{
        			
        		}
        	}*/
              	break;
        case "Tuesday":
        	String s1="https://s3.amazonaws.com/examplebucket-one/cardio/jumping+jack.gif";
        	i.setLargeImageUrl(s1);
        	responseText="Start the workout by doing a  10 minutes of walking,jogging \n"
        			   +"\n Start doing Jumping Jacks ,\n"
         			   +"\n for that ,\n"
        	           +  "\n Stand up straight.\n"
        	           + "\n Relax your shoulders along your spine.\n"
        	           + "\n Hold the top of your head up between your shoulders.\n"
        	           +"\n Hold your arms at your sides .\n"
        	           + "\n Stand in an upright position so that your feet are below your shoulders.\n"
        	           + "\n Jump and extend your arms overhead.\n"
        	           +"\n lift your arms overhead until your hands are about shoulder width apart.\n"
        	           + "\n Repeat as needed \n";
        	break;
        case "Wednesday":
        	String s2="https://s3.amazonaws.com/examplebucket-one/cardio/burpee.gif";
        	i.setLargeImageUrl(s2);
        	responseText="Start the workout by doing a  10 minutes of walking or jogging\n"
        			    +"\n Start doing Burpees ,\n"
         			    +"\n for that ,\n"
        	            +"\n Begin in a standing position.\n"
        	            + "\n Your feet should be shoulder-width apart.\n"
        	            + "\n  Now, lower your body into a squatting position, placing your  hands firmly on the floor in front of you.\n"
        	            +"\n Kick your feet back so that you are in push-up position."
        	            + "\n Lower your chest to do a push-up.\n"
        	            +"\n Kick your feet back to their original position. \n"
        	            +"\n Repeat as needed.\n";
        			        break;
               
               		
        case "Thursday":
        	String s3="https://s3.amazonaws.com/examplebucket-one/cardio/crunchesgif.gif";
        	i.setLargeImageUrl(s3);
        	responseText="Start the workout by doing a 10 minutes of walking or jogging \n"
        			 +"\n Start doing Crunches ,\n"
         			 +"\n for that ,\n"
        		     +"\n Lie on your back on an exercise mat. \n"
        			 +"\n Bend your knees so your feet are flat on the floor. \n"
        			 +"\n Place your fingertips behind your neck or head \n"
        			 +" \n Lift your shoulder blades off the mat with a smooth, controlled motion. \n"
        		+"\n Lower yourself back down with a slow, steady motion. \n " 
        		+"\n  Repeat as needed.\n"	
        			;
        	break;
        case "friday":
        	String s4="https://s3.amazonaws.com/examplebucket-one/cardio/lunges.gif";
        	i.setLargeImageUrl(s4);
        	responseText="Start the workout by doing a  10 minutes of walking or jogging \n"
        			     +"\n Start Lunges ,\n"
         			     +"\n for that ,\n"
                       	 + "\n Start by standing up straight with your feet hip-width apart and flat on the ground. \n"
        			     +" \n  Throughout a lunge exercise your arms \n "
        			     + "\n  and hands can be in any position \n"
                         +"\n Take a big step forward with your right leg. \n"
                         + "\n Place your right foot on the ground, heel first. \n"
                         +"\n  Lean your body forward so that about 70% of your weight is on your front foot.\n"
                         +"\n Lower your body until your right knee is at a 90-degree angle. \n"
                         +"\n Push yourself upwards with your right foot. \n"
                         +"\n Return your body to the position you started in,\n"
                         +"\n Repeat this several times and then switch to your left side.\n";        	
        	break;
        case "Saturday":
        	String s5="https://s3.amazonaws.com/examplebucket-one/cardio/mountainclimbers.gif";
        	i.setLargeImageUrl(s5);
        	responseText="Start the workout by doing a  10 minutes of walking or jogging \n"
        	        +"\n Start doing Mountain Climbers ,\n"
        			+"\n for that ,\n"
                	+"\n Get into plank position. \n"
                	+"\n  Get down on the floor on your hands and knees. \n"
                	+"\n Extend your legs out behind you, balancing on the balls and toes.\n"
                	+"\n Pull one knee up and in toward your midsection \n"
                	+"\n Lift one foot and begin bending the knee \n "
                	+ "\n As you pull it up between the front of your body and the floor. \n"
                  	+"\n Repeat the action with your other knee. \n"
                	+"\n Continue alternating the movement with both knees. \n";        	
                	break;
        case "Sunday":
        	String s6="https://s3.amazonaws.com/examplebucket-one/cardio/sunday-funday.jpg";
        	i.setLargeImageUrl(s6);
        	responseText="\n Take rest and gear up for next week. \n ";
        	break;
        default:
        	responseText="sorry!!please try again"+value;
        
        	/*//Object value1;
        	StringimageUpdate(value);
        	{
        		if(value.equalsIgnoreCase((String) Monday))
        		{
        			
                   // String s="https://s3.amazonaws.com/examplebucket-one/cardio/1000-points-workout.jpg";
                   // i.setSmallImageUrl(s);
                   
        		}
        		
        	}
        	/*String Monday;
			if (value == Monday)
           	{
           		JFrame f=new JFrame();
           		ImageIcon i= new ImageIcon("1000-points-workout.jpg");
           		JLabel l=new JLabel(i);
           		f.add(l);
           		f.setDefaultCloseOperation
                (JFrame.EXIT_ON_CLOSE);
         f.setVisible(true);
           	}
        	else
        	{
        	 responseText= "sorry try again"+value;     	}
        		
        */
        
        }
        
            PlainTextOutputSpeech outputSpeech = new PlainTextOutputSpeech();
            outputSpeech.setText(responseText);

          
            StandardCard card = new StandardCard();
            card.setTitle("Daily workout  ");
            card.setText(responseText);
           //Image i=new Image();
           // String s6="https://s3.amazonaws.com/examplebucket-one/cardio/images.jpg";
           //i.setSmallImageUrl(s6);
           
           card.setImage(i);

            PlainTextOutputSpeech repromptOutputSpeech = new PlainTextOutputSpeech();
            repromptOutputSpeech.setText(responseText);
            Reprompt reprompt = new Reprompt();
            reprompt.setOutputSpeech(repromptOutputSpeech);

            return SpeechletResponse.newAskResponse(outputSpeech, reprompt,card);
            
        

     
}

/**
 * Creates a {@code SpeechletResponse} for the HelpIntent.
 *
 * @return SpeechletResponse spoken and visual response for the given intent
 */
private SpeechletResponse getHelp() {
    String speechOutput =
            "You can ask to start the workout";
    String repromptText =
    		"You can ask to start the workout";
    return newAskResponse(speechOutput, false, repromptText, false);
}

/**
 * Wrapper for creating the Ask response. The OutputSpeech and {@link Reprompt} objects are
 * created from the input strings.
 *
 * @param stringOutput
 *            the output to be spoken
 * @param b 
 * @param repromptText
 *            the reprompt for if the user doesn't reply or is misunderstood.
 * @param c 
 * @return SpeechletResponse the speechlet response
 */
private SpeechletResponse newAskResponse(String stringOutput, boolean b, String repromptText, boolean c) {
	
	 SimpleCard card = new SimpleCard();
     card.setTitle(stringOutput);
    PlainTextOutputSpeech outputSpeech = new PlainTextOutputSpeech();
    outputSpeech.setText(stringOutput);

    PlainTextOutputSpeech repromptOutputSpeech = new PlainTextOutputSpeech();
    repromptOutputSpeech.setText(repromptText);
    Reprompt reprompt = new Reprompt();
    reprompt.setOutputSpeech(repromptOutputSpeech);

    return SpeechletResponse.newAskResponse(outputSpeech, reprompt,card);
}



}
