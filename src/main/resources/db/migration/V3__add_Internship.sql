CREATE TABLE internship_offering (
    id UUID NOT NULL PRIMARY KEY,
    organization_id UUID NOT NULL,
    name VARCHAR(255) NOT NULL,
    technology VARCHAR(255) NOT NULL,
    description VARCHAR(2550),
    created TIMESTAMP NOT NULL,
    location VARCHAR(255) NOT NULL,
    paid BOOLEAN NOT NULL,
    closed BOOLEAN NOT NULL,
    minimum_pay int,
    maximum_pay int,
    duration_in_months int,
    number_of_openings int,
    start_date DATE NOT NULL
);

CREATE TABLE application (
    id UUID NOT NULL PRIMARY KEY,
    internship_offering_id UUID NOT NULL,
    applicant_id UUID NOT NULL,
    application_status VARCHAR(255) NOT NULL,
    created TIMESTAMP NOT NULL,
    interview_date_time TIMESTAMP
);
