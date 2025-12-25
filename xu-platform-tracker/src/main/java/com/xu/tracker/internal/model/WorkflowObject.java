package com.xu.tracker.internal.model;

import com.xu.platform.persistence.IDataService;
import com.xu.platform.persistence.IEnumOption;
import com.xu.platform.persistence.model.*;
import com.xu.projects.model.IProject;
import com.xu.subterra.base.data.identification.IContextId;
import com.xu.subterra.base.data.identification.ILocalId;
import com.xu.subterra.base.data.identification.IObjectId;
import com.xu.subterra.base.data.model.ICustomField;
import com.xu.subterra.base.data.model.IType;
import com.xu.tracker.ITrackerService;
import com.xu.tracker.model.IStatusOpt;
import com.xu.tracker.model.ITypeOpt;
import com.xu.tracker.model.IWorkflowAction;
import com.xu.tracker.model.signatures.IWorkflowSignature;
import com.xu.tracker.model.signatures.IWorkflowSignaturesManager;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class WorkflowObject extends UniqueObject implements IInternalWorkflowObject{

}
