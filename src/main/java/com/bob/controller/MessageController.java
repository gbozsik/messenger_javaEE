package com.bob.controller;




import com.bob.domain.Message;
import com.bob.repo.MessageRepo;
import com.bob.service.MessageService;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("messages")
@RequestScoped
public class MessageController {

    @Inject
    private MessageRepo messageRepo;

    @Inject
    private MessageService messageService;


    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response getAllMessagesFromDb() {
        List<Message> messages = messageRepo.findAllMessages();
        return Response.ok()
                .entity(messages)
                .build();
    }


    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response postMessage(List<Message> messages) {
        Response.ResponseBuilder builder = Response.status(Response.Status.OK);
        return builder
                .entity(messageService.saveMessages(messages))
                .build();
    }

    //    @GET
//    @Path("/{id}")
//    @Produces(value = MediaType.APPLICATION_JSON)
//    public Response getAllMessagesFromDb(@PathParam("id") Long id) {
//        List<CustRiskSegmentRating> crsr = testRepository.findCustRiskSegmentRatingById(id);
//        return Response.ok()
//                .entity(crsr)
//                .build();
//     public List<String> getAllMessages(List<String> valami) {
//        addToValami();
//         return valami.stream()
//                 .filter(Optional::isPresent)
//                 .map(val -> dump(val))
//                 .map(String::length)
//                 .collect(Collectors.toList());
//    }

//    private String dump(String val) {
//        System.out.println(val);
//        return val;
//    }


}
