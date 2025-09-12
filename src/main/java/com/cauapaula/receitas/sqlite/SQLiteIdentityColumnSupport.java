package com.cauapaula.receitas.sqlite;

import org.hibernate.dialect.identity.IdentityColumnSupportImpl;

public class SQLiteIdentityColumnSupport extends IdentityColumnSupportImpl {
    @Override
    public boolean supportsIdentityColumns() {
        return true;
    }

    @Override
    public String getIdentityColumnString(int type) {
        return "integer";
    }
}
