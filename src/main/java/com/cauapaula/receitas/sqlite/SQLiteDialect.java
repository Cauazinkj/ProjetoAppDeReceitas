package com.cauapaula.receitas.sqlite;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.identity.IdentityColumnSupport;

import java.sql.Types;

public class SQLiteDialect extends Dialect {

    public SQLiteDialect() {
        registerColumnType(Types.INTEGER, "integer");
        registerColumnType(Types.VARCHAR, "text");
        registerColumnType(Types.BOOLEAN, "integer");
        registerColumnType(Types.BIGINT, "bigint");
    }

    @Override
    public IdentityColumnSupport getIdentityColumnSupport() {
        return new SQLiteIdentityColumnSupport();
    }

}

