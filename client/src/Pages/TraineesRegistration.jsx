import React, { useState } from "react";
import AuthAccess from "../DataAccess/AuthAccess";
import { Link, useNavigate } from "react-router-dom";

const TraineesRegistration = () => {
    const [traineesRegistrationData, setTraineesRegistrationData] = useState({ });
    const navigate = useNavigate();
    const traineesRegistration = (e) => {
      let name = e.target.name;
      let value = e.target.value;
      setTraineesRegistrationData(
        (prevState) => ({
          ...prevState,
          [name]: value,
        }),
        []
      );
    };
  
    const traineesRegistrationHandeler = async  (e) => {
      e.preventDefault();
        const traineesRegistrationResponse = {};
      
    };
  return (
    <div className="col-md-12 d-flex align-items-center justify-content-center">
      <div className="card">
        <form className="" onSubmit={(e) => traineesRegistrationHandeler(e)}>
          <div className="card-body">
            <h3 className="">Trainees Registration</h3>

            <div className="form-group mt-3">
              <label>Email address</label>
              <input
                type="text"
                name="fullName"
                className="form-control mt-1"
                placeholder="Full Name"
                onChange={(e) => traineesRegistration(e)}
              />
            </div>
            <div className="form-group mt-3">
              <label>Profile Picture</label>
              <input
                type="file"
                name="profilePicture"
                className="form-control mt-1"
                placeholder="Profile Picture"
                onChange={(e) => traineesRegistration(e)}
              />
            </div>
            <div className="form-group mt-3">
              <label>Gender</label>
              <input
                type="text"
                name="gender"
                className="form-control mt-1"
                placeholder="Gender"
                onChange={(e) => traineesRegistration(e)}
              />
            </div>
            
            <div className="form-group mt-3">
              <label>Date of birth</label>
              <input
                type="date"
                name="dateOfBirth"
                className="form-control mt-1"
                placeholder="Date of birth"
                onChange={(e) => traineesRegistration(e)}
              />
            </div>
            <div className="form-group mt-3">
              <label>Email</label>
              <input
                type="email"
                name="email"
                className="form-control mt-1"
                placeholder="Email"
                onChange={(e) => traineesRegistration(e)}
              />
            </div>
            <div className="form-group mt-3">
              <label>Contact number</label>
              <input
                type="text"
                name="ContactNumber"
                className="form-control mt-1"
                placeholder="Contact number"
                onChange={(e) => traineesRegistration(e)}
              />
            </div>
            
            <div className="form-group mt-3">
              <label>Degree name</label>
              <input
                type="text"
                name="degreeName"
                className="form-control mt-1"
                placeholder="Degree name"
                onChange={(e) => traineesRegistration(e)}
              />
            </div>
            
            
            
            <div className="form-group mt-3">
              <label>Educational institute</label>
              <input
                type="text"
                name="educationalInstitute"
                className="form-control mt-1"
                placeholder="Educational institute"
                onChange={(e) => traineesRegistration(e)}
              />
            </div>
            
            <div className="form-group mt-3">
              <label>Email</label>
              <input
                type="number"
                name="CGPA"
                className="form-control mt-1"
                placeholder="CGPA"
                onChange={(e) => traineesRegistration(e)}
              />
            </div>


            <div className="form-group mt-3">
              <label>Passing year</label>
              <input
                type="number"
                name="passingYear "
                className="form-control mt-1"
                placeholder="Passing year"
                onChange={(e) => traineesRegistration(e)}
              />
            </div>
            <div className="form-group mt-3">
              <label>Present Adrress</label>
              <input
                type="text"
                name="presentAdrress"
                className="form-control mt-1"
                placeholder="Present Adrress"
                onChange={(e) => trainersRegistration(e)}
              />
            </div>
            <div className="d-grid gap-2 mt-3">
              <button type="submit" className="btn btn-primary">
                Submit
              </button>
            </div>
          </div>
        </form>
      </div>
    </div>
  )
}

export default TraineesRegistration