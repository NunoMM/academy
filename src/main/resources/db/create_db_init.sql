
CREATE TABLE t_team
(
    id uuid primary key,
    name varchar(20) NOT NULL,
    product varchar(20) NOT NULL,
    created_at TIMESTAMP default now() NOT NULL,
    modified_at TIMESTAMP default now() NOT NULL,
    default_location varchar(20) NOT NULL
);

create table t_rack
(
    id uuid primary key,
    team_id uuid,
    serial_number varchar(20) NOT NULL,
    status varchar(20) NOT NULL check (status in ('ACTIVE','RETURNED','REPAIR','OUTDATED','BRICKED')),
    default_location varchar(20) NOT NULL,
    assembled_at TIMESTAMP default now(),
    created_at TIMESTAMP default now() NOT NULL,
    modified_at TIMESTAMP default now() NOT NULL,
    FOREIGN KEY (team_id) references t_team(id)
);

create table t_rack_asset
(
    id uuid primary key,
    rack_id uuid NOT NULL,
    asset_tag varchar(20) NOT NULL,
    created_at TIMESTAMP default now() NOT NULL,
    modified_at TIMESTAMP default now() NOT NULL,
    FOREIGN KEY (rack_id) references t_rack(id)
);

CREATE TABLE t_booking
(
    id uuid primary key,
    rack_id uuid NOT NULL,
    requester_id uuid NOT NULL,
    book_from TIMESTAMP NOT NULL,
    book_to TIMESTAMP NOT NULL,
    created_at TIMESTAMP default now(),
    modified_at TIMESTAMP default now(),
    FOREIGN KEY (rack_id) references t_rack(id),
    FOREIGN KEY (requester_id) references t_team(id)
);

CREATE TABLE t_team_member
(
    id uuid primary key,
    team_id uuid NOT NULL,
    ctw_id varchar(10) NOT NULL,
    name varchar(20) NOT NULL,
    created_at TIMESTAMP default now() NOT NULL,
    modified_at TIMESTAMP default now() NOT NULL,
    foreign key (team_id) references t_team(id)
);


