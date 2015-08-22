package alchemy;

import java.io.IOException;
import java.util.Iterator;

import com.likethecolor.alchemy.api.Client;
import com.likethecolor.alchemy.api.call.AbstractCall;
import com.likethecolor.alchemy.api.call.AuthorCall;
import com.likethecolor.alchemy.api.call.SentimentCall;
import com.likethecolor.alchemy.api.call.type.CallTypeText;
import com.likethecolor.alchemy.api.call.type.CallTypeUrl;
import com.likethecolor.alchemy.api.entity.AbstractAlchemyEntity;
import com.likethecolor.alchemy.api.entity.AuthorAlchemyEntity;
import com.likethecolor.alchemy.api.entity.Response;
import com.likethecolor.alchemy.api.entity.SentimentAlchemyEntity;
import com.likethecolor.alchemy.api.params.Params;

public class Test {

	public static void main(String[] args) {
		final String apiKey = "cfb3edd593d3aceea6fc58366416cadf45bb003c";
		final Client client = new Client(apiKey);

		SentimentCall sCall = new SentimentCall(new CallTypeUrl("http://abcnews.go.com/Technology/god-particle-higgs-boson-year/story?id=19574423"));
		Response sentimentResponse = null;
		try {
			Params ps = new Params();
			
			sentimentResponse = client.call(sCall);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Language: " + sentimentResponse.getLanguage());
		System.out.println("Status: " + sentimentResponse.getStatus());
		System.out.println("Status Info: " + sentimentResponse.getStatusInfo());
		System.out.println("Text: " + sentimentResponse.getText());
		System.out.println("Usage: " + sentimentResponse.getUsage());

		Iterator<SentimentAlchemyEntity> it = sentimentResponse.iterator();
		while (it.hasNext()) {
			SentimentAlchemyEntity entity = it.next();
			entity.setIsMixed(true);
			
			System.out.println();
			System.out.println(entity.getScore());
		}
	}
}
