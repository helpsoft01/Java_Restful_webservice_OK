package sonvh.webservice.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import sonvh.webservice.entity.Track;

@Path("/json")
public class JSONService {

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Track getTrackInJSON() {

		Track track = new Track();
		track.setTitle("Enter Sandman");
		track.setSinger("Metallica");

		return track;

	}

	@POST
	@Path("/getList")
	@Produces(MediaType.APPLICATION_JSON)

	public List<Track> getListTracks() {

		List<Track> l = new ArrayList<Track>();

		Track t = new Track();
		t.setTitle("1");
		t.setSinger("mot");
		l.add(t);

		t = new Track();
		t.setTitle("2");
		t.setSinger("hai");
		l.add(t);

		return l;
	}

	@POST
	@Path("/updateTrack")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Track createTrackInJSON(Track track) {

		Track t = new Track();
		t.setTitle(track.getTitle() + "_update");
		t.setSinger(track.getSinger() + "_update");

		return t;
	}

}