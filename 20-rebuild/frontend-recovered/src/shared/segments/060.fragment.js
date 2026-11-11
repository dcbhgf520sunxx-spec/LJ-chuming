const vhe = { add: B8, detail: H8, edit: Vhe, get: bhe }, Rhe = (e) => {
  const o = Ht(), n = Ee(() => o.state.config.loaded.catalogRegional);
  if (n.value || o.dispatch("config/fetchCatalogRegional"), e) {
    const c = Ce(n, (u) => {
      u && setTimeout(() => {
        e(), c();
      }, 0);
    }, { immediate: true });
  }
  return { catalogRegional: Ee(() => o.state.config.catalogRegional), loaded: n };
}, f2 = { __name: "catalog-region-cascader", props: { modelValue: { type: [Array, Number], default: void 0 }, filterable: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, placeholder: { type: String, default: "请选择地区" } }, emits: ["update:modelValue", "change"], setup(e, { expose: o, emit: n }) {
  const c = n, u = e, r = Z(), E = Z(), y = Ee(() => ({ label: "name", value: "id", children: "children" }));
  Ce(() => u.modelValue, (g) => {
    g instanceof Array ? r.value = [...g] : r.value = g, V(g);
  }, { immediate: true });
  const { catalogRegional: b } = Rhe();
  function V(g) {
    c("update:modelValue", g), c("change", g);
  }
  function M() {
    var S;
    const g = E.value.getCheckedNodes(true);
    return g.length ? (S = g[0]) == null ? void 0 : S.data : {};
  }
  return o({ getNodeInfo: M }), (g, S) => {
    const h = Ns;
    return w(), U(h, { ref_key: "catalogCascader", ref: E, modelValue: r.value, "onUpdate:modelValue": S[0] || (S[0] = (T) => r.value = T), options: l(b), props: y.value, filterable: u.filterable, clearable: u.clearable, "show-all-levels": u.showAllLevels, placeholder: u.placeholder, onChange: V }, null, 8, ["modelValue", "options", "props", "filterable", "clearable", "show-all-levels", "placeholder"]);
  };
} }, g2 = (e) => {
  const o = Ht(), n = Ee(() => o.state.config.loaded.catalogContentConfig);
  if (n.value || o.dispatch("config/fetchCatalogContentConfig"), e) {
    const c = Ce(n, (u) => {
      u && setTimeout(() => {
        e(), c();
      }, 0);
    }, { immediate: true });
  }
  return { catalogContentConfig: Ee(() => o.state.config.catalogContentConfig), loaded: n };
};
const Mhe = { class: "common-class item-content" }, Ahe = { class: "common-class item-content" }, Nhe = { class: "common-class item-content" }, Lhe = { class: "common-class item-content" }, Ihe = { class: "common-class item-content" }, Che = { class: "common-class item-content" }, Phe = { class: "common-class item-content" }, Ohe = { class: "common-class item-content" }, khe = { class: "common-class item-content" }, Dhe = { class: "common-class item-content" }, xhe = { class: "common-class item-content" }, Uhe = { class: "common-class item-content" }, Yhe = { class: "common-class item-content" }, Khe = { class: "common-class item-content" }, Whe = { class: "common-class item-content" }, jhe = { class: "common-class item-content" }, Fhe = { key: 0 }, zhe = { key: 1 }, Bhe = { class: "common-class item-content" }, Hhe = { class: "common-class item-content" }, qhe = { class: "common-class item-content" }, Ghe = { class: "common-class item-content" }, Qhe = { class: "common-class item-content" }, Zhe = { class: "common-class item-content" }, Jhe = { class: "common-class item-content" }, Xhe = { class: "common-class item-content" }, $he = { class: "common-class item-content" }, efe = { class: "common-class item-content" }, tfe = { class: "common-class item-content" }, ife = { class: "common-class item-content" }, afe = { class: "common-class item-content" }, lfe = { class: "common-class item-content" }, ofe = { class: "common-class item-content" }, nfe = { class: "common-class item-content" }, sfe = { class: "common-class item-content" }, rfe = { class: "common-class item-content" }, ufe = { class: "common-class item-content" }, cfe = { class: "common-class item-content" }, dfe = { class: "common-class item-content" }, mfe = { class: "common-class item-content" }, pfe = { class: "common-class item-content" }, hfe = { class: "common-class item-content" }, ffe = { class: "common-class item-content" }, gfe = { class: "common-class item-content" }, Efe = { class: "common-class item-content" }, yfe = { class: "common-class item-content" }, Tfe = { class: "common-class item-content" }, _fe = { class: "common-class item-content" }, bfe = { __name: "review-form", props: { modelValue: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} } }, emits: ["success", "update:modelValue"], setup(e, { emit: o }) {
  const { loaded: n, catalogContentConfig: c } = g2(), { user: u } = ka(["user"]), r = e, E = o, { visible: y, handleClose: b } = Ta({ emit: E, props: r }), V = Z(false), M = Z(), g = Z({ contractNumber: void 0, title: void 0, boolBindingPreRegistration: void 0, preRegistrationId: void 0, applicantId: void 0, applicantName: void 0, deptId: void 0, applicationDate: void 0, projectName: void 0, signerId: void 0, signerName: void 0, firstLevelDept: void 0, secondLevelDept: void 0, contractAmount: void 0, taxRate: void 0, contractType: void 0, infoSource: void 0, projectManager: void 0, boolCoordinate: void 0, partyA: void 0, partyB: void 0, partyC: void 0, partyD: void 0, boolBidWinningNotice: void 0, drawing: void 0, boolBidProposals: void 0, boolBidDocument: void 0, contractualNature: void 0, biddingMethod: void 0, partyType: void 0, boolFabricatedStructure: void 0, boolModelContract: void 0, locationId: void 0, countryId: void 0, provinceId: void 0, cityId: void 0, regionId: void 0, structureType: void 0, structureArea: void 0, mainStructureSteelMete: void 0, subfabricSteelMete: void 0, maximumSpan: void 0, contractStartDate: void 0, contractEndDate: void 0, allDays: void 0, prepaymentRatio: void 0, warrantyRatio: void 0, boolPeasantWorkerWageAccount: void 0, peasantWorkerWageRatio: void 0, progressPayment: void 0, materialInspection: void 0, attachments: void 0, remark: void 0, dateTime: [], region: [] }), S = Z(), h = Z(), T = Z(false), _ = Ee(() => {
    var x;
    return g.value.firstLevelDept ? ((x = c.value) == null ? void 0 : x[Ja.SECOND_LEVEL_DEPT.V].filter((I) => I.parentId === g.value.firstLevelDept)) || [] : [];
  }), f = (x, I, Y) => {
    I || Y(new Error("必须大于0")), Y();
  }, m = { boolBindingPreRegistration: [{ required: true, message: "请选择是否引用合同预登记", trigger: "change" }], title: [{ required: true, message: "请输入标题", trigger: "blur" }], projectName: [{ required: true, message: "项目名称", trigger: "blur" }], signDate: [{ required: true, message: "请选择签订日期", trigger: "change" }], signerId: [{ required: true, message: "请选择签订人", trigger: "change" }], firstLevelDept: [{ required: true, message: "请选择所属一级部门", trigger: "change" }], secondLevelDept: [{ required: true, message: "请选择所属二级部门", trigger: "change" }], contractAmount: [{ required: true, validator: f, message: "请填写合同金额", trigger: "blur" }], taxRate: [{ required: true, validator: f, trigger: "blur" }], contractType: [{ required: true, message: "请选择合同类型", trigger: "change" }], infoSource: [{ required: true, message: "请选择信息来源", trigger: "change" }], partyA: [{ required: true, message: "请填写甲方", trigger: "blur" }], partyB: [{ required: true, message: "请填写乙方", trigger: "blur" }], mainStructureSteelMete: [{ required: true, validator: f, message: "请填写主结构用钢量(吨)", trigger: "blur" }], dateTime: [{ required: true, message: "请选择开竣工时间", trigger: "change" }] };
  Ce(() => y.value, (x) => {
    var I, Y, ee, B, q, ae, j, le, oe, ye, ce, se, he, be, me, ge, Le, Ie, Se, X, $, k, J, z, F, G, ie, ue, ne, te, de, pe, re, we, Ke, Me, Ne, He, ze, Oe, Re, fe, Ue, Je, Xe, Ye;
    if (x) {
      T.value = true, g.value.boolBindingPreRegistration = ea.TRUE.V, g.value.contractNumber = r.detailInfo.contractNumber, g.value.region = [], g.value.dateTime = [], g.value.applicationDate = (/* @__PURE__ */ new Date()).getTime(), g.value.applicantId = (I = u.value) == null ? void 0 : I.id, g.value.applicantName = (Y = u.value) == null ? void 0 : Y.name, g.value.deptId = (ee = u.value) == null ? void 0 : ee.deptId, g.value.deptName = (B = u.value) == null ? void 0 : B.dept, g.value.preRegistrationId = r.detailInfo.id, g.value.contractCatalogueId = (q = r.detailInfo.contractCatalogueDTO) == null ? void 0 : q.id, g.value.biddingMethod = (ae = r.detailInfo.contractCatalogueDTO) == null ? void 0 : ae.biddingMethod, g.value.boolFabricatedStructure = (j = r.detailInfo.contractCatalogueDTO) == null ? void 0 : j.boolFabricatedStructure, g.value.boolModelContract = (le = r.detailInfo.contractCatalogueDTO) == null ? void 0 : le.boolModelContract, g.value.cityId = (oe = r.detailInfo.contractCatalogueDTO) == null ? void 0 : oe.cityId, g.value.contractAmount = (ye = r.detailInfo.contractCatalogueDTO) == null ? void 0 : ye.contractAmount, g.value.contractEndDate = (ce = r.detailInfo.contractCatalogueDTO) == null ? void 0 : ce.contractEndDate, g.value.contractNumber = (se = r.detailInfo.contractCatalogueDTO) == null ? void 0 : se.contractNumber, g.value.contractStartDate = (he = r.detailInfo.contractCatalogueDTO) == null ? void 0 : he.contractStartDate, g.value.contractType = (be = r.detailInfo.contractCatalogueDTO) == null ? void 0 : be.contractType, g.value.contractualNature = (me = r.detailInfo.contractCatalogueDTO) == null ? void 0 : me.contractualNature, g.value.countryId = (ge = r.detailInfo.contractCatalogueDTO) == null ? void 0 : ge.countryId, g.value.firstLevelDept = (Le = r.detailInfo.contractCatalogueDTO) == null ? void 0 : Le.firstLevelDept, g.value.infoSource = (Ie = r.detailInfo.contractCatalogueDTO) == null ? void 0 : Ie.infoSource, g.value.locationId = (Se = r.detailInfo.contractCatalogueDTO) == null ? void 0 : Se.locationId, g.value.locationValue = (X = r.detailInfo.contractCatalogueDTO) == null ? void 0 : X.locationValue, g.value.mainStructureSteelMete = ($ = r.detailInfo.contractCatalogueDTO) == null ? void 0 : $.mainStructureSteelMete, g.value.maximumSpan = (k = r.detailInfo.contractCatalogueDTO) == null ? void 0 : k.maximumSpan, g.value.partyA = (J = r.detailInfo.contractCatalogueDTO) == null ? void 0 : J.partyA, g.value.partyType = (z = r.detailInfo.contractCatalogueDTO) == null ? void 0 : z.partyType, g.value.projectManager = (F = r.detailInfo.contractCatalogueDTO) == null ? void 0 : F.projectManager, g.value.projectName = (G = r.detailInfo.contractCatalogueDTO) == null ? void 0 : G.projectName, g.value.provinceId = (ie = r.detailInfo.contractCatalogueDTO) == null ? void 0 : ie.provinceId, g.value.regionId = (ue = r.detailInfo.contractCatalogueDTO) == null ? void 0 : ue.regionId, g.value.remark = (ne = r.detailInfo.contractCatalogueDTO) == null ? void 0 : ne.remark, g.value.secondLevelDept = (te = r.detailInfo.contractCatalogueDTO) == null ? void 0 : te.secondLevelDept, g.value.signDate = (de = r.detailInfo.contractCatalogueDTO) == null ? void 0 : de.signDate, g.value.signerId = (pe = r.detailInfo.contractCatalogueDTO) == null ? void 0 : pe.signerId, g.value.structureArea = (re = r.detailInfo.contractCatalogueDTO) == null ? void 0 : re.structureArea, g.value.structureType = (we = r.detailInfo.contractCatalogueDTO) == null ? void 0 : we.structureType, g.value.subfabricSteelMete = (Ke = r.detailInfo.contractCatalogueDTO) == null ? void 0 : Ke.subfabricSteelMete, (Me = r.detailInfo.contractCatalogueDTO) != null && Me.countryId && g.value.region.push((Ne = r.detailInfo.contractCatalogueDTO) == null ? void 0 : Ne.countryId), (He = r.detailInfo.contractCatalogueDTO) != null && He.provinceId && g.value.region.push((ze = r.detailInfo.contractCatalogueDTO) == null ? void 0 : ze.provinceId), (Oe = r.detailInfo.contractCatalogueDTO) != null && Oe.cityId && g.value.region.push((Re = r.detailInfo.contractCatalogueDTO) == null ? void 0 : Re.cityId), (fe = r.detailInfo.contractCatalogueDTO) != null && fe.regionId && g.value.region.push((Ue = r.detailInfo.contractCatalogueDTO) == null ? void 0 : Ue.regionId), g.value.contractStartDate && g.value.contractEndDate && (g.value.dateTime.push(g.value.contractStartDate, g.value.contractEndDate), g.value.allDays = sr(g.value.contractStartDate, g.value.contractEndDate)), N(), g.value.attachmentList = (Je = r.detailInfo.contractCatalogueDTO) == null ? void 0 : Je.attachmentList;
      if (!r.detailInfo.contractCatalogueDTO && r.detailInfo.id != null) {
        const registration = r.detailInfo;
        const fields = [
          "projectName", "contractAmount", "contractualNature", "countryId",
          "provinceId", "cityId", "regionId", "locationId", "locationValue",
          "infoSource", "partyType", "remark", "signerId", "structureArea",
          "structureType", "boolBidWinningNotice"
        ];
        for (const field of fields) g.value[field] = registration[field];
        g.value.partyA = registration.partyName;
        g.value.region = [
          registration.countryId, registration.provinceId,
          registration.cityId, registration.regionId
        ].filter((id) => id != null);
        N();
      }
      const Fe = ((Ye = (Xe = r.detailInfo.contractCatalogueDTO) == null ? void 0 : Xe.attachmentList) == null ? void 0 : Ye.map((et) => et.id)) || [];
      g.value.attachments = A(Fe) ? Fe.join(",") : g.value.attachments, setTimeout(() => {
        T.value = false;
      });
    }
  }, { deep: true, immediate: true });
  function R() {
    g.value.region = [], g.value.contractCatalogueId = void 0, g.value.biddingMethod = void 0, g.value.boolCoordinate = void 0, g.value.boolFabricatedStructure = void 0, g.value.boolModelContract = void 0, g.value.cityId = void 0, g.value.contractAmount = void 0, g.value.contractEndDate = void 0, g.value.contractNumber = void 0, g.value.contractStartDate = void 0, g.value.contractType = void 0, g.value.contractualNature = void 0, g.value.countryId = void 0, g.value.firstLevelDept = void 0, g.value.infoSource = void 0, g.value.locationId = void 0, g.value.locationValue = void 0, g.value.mainStructureSteelMete = void 0, g.value.maximumSpan = void 0, g.value.partyA = void 0, g.value.partyType = void 0, g.value.projectManager = void 0, g.value.projectName = void 0, g.value.provinceId = void 0, g.value.regionId = void 0, g.value.remark = void 0, g.value.secondLevelDept = void 0, g.value.signDate = void 0, g.value.signerId = void 0, g.value.structureArea = void 0, g.value.structureType = void 0, g.value.subfabricSteelMete = void 0, g.value.allDays = void 0;
  }
  function v() {
    g.value.preRegistrationId = void 0, R();
  }
  function N() {
    g.value.infoSource === Cl.MANAGER_SELLER.V || g.value.infoSource === Cl.NEW_MANAGER.V ? g.value.boolCoordinate = true : g.value.boolCoordinate = false;
  }
  function P() {
    A(g.value.dateTime) ? (g.value.contractStartDate = g.value.dateTime[0], g.value.contractEndDate = g.value.dateTime[1], g.value.allDays = sr(g.value.contractStartDate, g.value.contractEndDate)) : (g.value.contractStartDate = void 0, g.value.contractEndDate = void 0);
  }
  function L(x) {
    g.value.countryId = void 0, g.value.provinceId = void 0, g.value.cityId = void 0, g.value.regionId = void 0, x && x.forEach((I, Y) => {
      Y === 0 && (g.value.countryId = I), Y === 1 && (g.value.provinceId = I), Y === 2 && (g.value.cityId = I), Y === 3 && (g.value.regionId = I);
    }), pt(() => {
      var I;
      if (!T.value) {
        const Y = (I = h.value) == null ? void 0 : I.getNodeInfo();
        g.value.locationId = Y == null ? void 0 : Y.locationId, g.value.locationValue = Y == null ? void 0 : Y.locationName;
      }
    });
  }
  async function O() {
    var I, Y;
    g.value.boolSupplement = false;
    const x = ((I = g.value.attachmentList) == null ? void 0 : I.map((ee) => ee.id)) || [];
    g.value.attachments = A(x) ? x.join(",") : g.value.attachments, g.value.signerName = (Y = S == null ? void 0 : S.value.getNodeInfo()) == null ? void 0 : Y.label;
    try {
      await M.value.validate() && (await B8(g.value), ot.success("提交成功"), E("success"), b());
    } catch (ee) {
      console.log("评审审核", ee);
    }
  }
  return (x, I) => {
    const Y = Ve("common-button"), ee = Ve("common-select"), B = Zi, q = Bn, ae = Mt, j = Rl, le = Ve("common-input-number"), oe = Hn, ye = Li, ce = Ve("common-drawer");
    return w(), U(ce, { ref: "drawerRef", modelValue: l(y), "onUpdate:modelValue": I[39] || (I[39] = (se) => Gt(y) ? y.value = se : null), "before-close": l(b), title: "评审登记申请", "wrapper-closable": false, "close-on-click-modal": false, size: "80%" }, { titleRight: p(() => [s(Y, { loading: V.value, type: "primary", size: "default", onClick: O }, { default: p(() => I[40] || (I[40] = [Te("提交")])), _: 1, __: [40] }, 8, ["loading"])]), content: p(() => [s(ye, { ref_key: "formRef", ref: M, model: g.value, rules: m, size: "default", "label-width": "120px", "label-position": "right" }, { default: p(() => [s(oe, { style: { border: "1px solid #ebeef5", "margin-bottom": "10px" } }, { default: p(() => [s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[41] || (I[41] = C("span", { class: "item-title common-class needItem" }, "合同预登记", -1)), C("div", Mhe, [s(B, { class: "el-form-item-18", label: "", prop: "boolBindingPreRegistration", "label-width": "0" }, { default: p(() => [s(ee, { modelValue: g.value.boolBindingPreRegistration, "onUpdate:modelValue": I[0] || (I[0] = (se) => g.value.boolBindingPreRegistration = se), options: l(ea).ENUM, type: "enum", size: "default", disabled: "", clearable: "", style: { width: "100%" }, class: "input-underline", placeholder: "请选择", onChange: v }, null, 8, ["modelValue", "options"])]), _: 1 })])]), _: 1, __: [41] }), s(q, { span: 16, class: "item-wrap" }, { default: p(() => [I[42] || (I[42] = C("span", { class: "item-title common-class needItem" }, "标题", -1)), C("div", Ahe, [s(B, { class: "el-form-item-18", label: "", prop: "title", "label-width": "0" }, { default: p(() => [s(ae, { modelValue: g.value.title, "onUpdate:modelValue": I[1] || (I[1] = (se) => g.value.title = se), modelModifiers: { trim: true }, type: "text", placeholder: "标题", class: "input-underline", maxlength: "60" }, null, 8, ["modelValue"])]), _: 1 })])]), _: 1, __: [42] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[43] || (I[43] = C("span", { class: "item-title common-class" }, "申请人", -1)), C("div", Nhe, [s(B, { class: "el-form-item-18", label: "", prop: "branchCompanyId", "label-width": "0" }, { default: p(() => [Te(K(g.value.applicantName), 1)]), _: 1 })])]), _: 1, __: [43] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[44] || (I[44] = C("span", { class: "item-title common-class" }, "申请人部门", -1)), C("div", Lhe, [s(B, { class: "el-form-item-18", label: "", prop: "branchCompanyId", "label-width": "0" }, { default: p(() => [Te(K(g.value.deptName), 1)]), _: 1 })])]), _: 1, __: [44] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[46] || (I[46] = C("span", { class: "item-title common-class" }, "申请编号", -1)), C("div", Ihe, [s(B, { class: "el-form-item-18", label: "", prop: "", "label-width": "0" }, { default: p(() => I[45] || (I[45] = [C("span", null, "-", -1)])), _: 1, __: [45] })])]), _: 1, __: [46] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[47] || (I[47] = C("span", { class: "item-title common-class needItem" }, "申请人日期", -1)), C("div", Che, [s(B, { class: "el-form-item-18", label: "", prop: "branchCompanyId", "label-width": "0" }, { default: p(() => [s(j, { modelValue: g.value.applicationDate, "onUpdate:modelValue": I[2] || (I[2] = (se) => g.value.applicationDate = se), type: "date", size: "default", class: "input-underline", "value-format": "x", style: { width: "100%" }, disabled: "" }, null, 8, ["modelValue"])]), _: 1 })])]), _: 1, __: [47] }), s(q, { span: 16, class: "item-wrap" }, { default: p(() => [I[48] || (I[48] = C("span", { class: "item-title common-class needItem" }, "项目名称", -1)), C("div", Phe, [s(B, { class: "el-form-item-18", label: "", prop: "projectName", "label-width": "0" }, { default: p(() => [Te(K(g.value.contractNumber) + K(g.value.projectName), 1)]), _: 1 })])]), _: 1, __: [48] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[49] || (I[49] = C("span", { class: "item-title common-class needItem" }, "签订人", -1)), C("div", Ohe, [s(B, { class: "el-form-item-18", label: "", prop: "signerId", "label-width": "0" }, { default: p(() => [s(Ds, { ref_key: "userDeptRef", ref: S, modelValue: g.value.signerId, "onUpdate:modelValue": I[3] || (I[3] = (se) => g.value.signerId = se), "collapse-tags": false, nofilterBlankDept: "", class: "input-underline", clearable: "", filterable: "", placeholder: "签订人", style: { width: "200px" } }, null, 8, ["modelValue"])]), _: 1 })])]), _: 1, __: [49] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[50] || (I[50] = C("span", { class: "item-title common-class needItem" }, "所属一级部门", -1)), C("div", khe, [s(B, { class: "el-form-item-18", label: "", prop: "firstLevelDept", "label-width": "0" }, { default: p(() => [s(ee, { modelValue: g.value.firstLevelDept, "onUpdate:modelValue": I[4] || (I[4] = (se) => g.value.firstLevelDept = se), options: l(c)[l(Ja).FIRST_LEVEL_DEPT.V], dataStructure: { key: "id", label: "fieldValue", value: "id" }, disabled: !l(n), clearable: "", class: "input-underline", placeholder: "请选择所属一级部门", style: { width: "100%" } }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 })])]), _: 1, __: [50] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[51] || (I[51] = C("span", { class: "item-title common-class needItem" }, "所属二级部门", -1)), C("div", Dhe, [s(B, { class: "el-form-item-18", label: "", prop: "secondLevelDept", "label-width": "0" }, { default: p(() => [s(ee, { modelValue: g.value.secondLevelDept, "onUpdate:modelValue": I[5] || (I[5] = (se) => g.value.secondLevelDept = se), options: _.value, dataStructure: { key: "id", label: "fieldValue", value: "id" }, disabled: !l(n) || !g.value.firstLevelDept, clearable: "", class: "input-underline", placeholder: "请选择所属二级部门", style: { width: "100%" } }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 })])]), _: 1, __: [51] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[52] || (I[52] = C("span", { class: "item-title common-class needItem" }, "合同金额（元）", -1)), C("div", xhe, [s(B, { class: "el-form-item-18", label: "", prop: "contractAmount", "label-width": "0" }, { default: p(() => [s(le, { modelValue: g.value.contractAmount, "onUpdate:modelValue": I[6] || (I[6] = (se) => g.value.contractAmount = se), controls: false, max: 999999999999, min: 0, precision: l(Ze).YUAN, step: 1, autocomplete: "off", class: "input-underline", placeholder: "请填写合同金额", style: { width: "100%" } }, null, 8, ["modelValue", "precision"])]), _: 1 })])]), _: 1, __: [52] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[53] || (I[53] = C("span", { class: "item-title common-class needItem" }, "税率（%）", -1)), C("div", Uhe, [s(B, { class: "el-form-item-18", label: "", prop: "taxRate", "label-width": "0" }, { default: p(() => [s(le, { modelValue: g.value.taxRate, "onUpdate:modelValue": I[7] || (I[7] = (se) => g.value.taxRate = se), controls: false, max: 100, min: 0, precision: 0, step: 1, autocomplete: "off", class: "input-underline", placeholder: "税率", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 })])]), _: 1, __: [53] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[54] || (I[54] = C("span", { class: "item-title common-class needItem" }, "合同类型", -1)), C("div", Yhe, [s(B, { class: "el-form-item-18", label: "", prop: "contractType", "label-width": "0" }, { default: p(() => [s(ee, { modelValue: g.value.contractType, "onUpdate:modelValue": I[8] || (I[8] = (se) => g.value.contractType = se), options: l(c)[l(Ja).CONTRACT_TYPE.V], dataStructure: { key: "id", label: "fieldValue", value: "id" }, disabled: !l(n), clearable: "", class: "input-underline", placeholder: "请选择合同类型", style: { width: "100%" } }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 })])]), _: 1, __: [54] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[55] || (I[55] = C("span", { class: "item-title common-class needItem" }, "信息来源", -1)), C("div", Khe, [s(B, { class: "el-form-item-18", label: "", prop: "infoSource", "label-width": "0" }, { default: p(() => [s(ee, { modelValue: g.value.infoSource, "onUpdate:modelValue": I[9] || (I[9] = (se) => g.value.infoSource = se), options: l(Cl).ENUM, type: "enum", size: "default", clearable: "", disabled: !l(n), style: { width: "100%" }, class: "input-underline", placeholder: "请选择信息来源", onChange: N }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 })])]), _: 1, __: [55] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[56] || (I[56] = C("span", { class: "item-title common-class" }, "项目经理", -1)), C("div", Whe, [s(B, { class: "el-form-item-18", label: "", prop: "projectManager", "label-width": "0" }, { default: p(() => [s(ae, { modelValue: g.value.projectManager, "onUpdate:modelValue": I[10] || (I[10] = (se) => g.value.projectManager = se), modelModifiers: { trim: true }, type: "text", placeholder: "项目经理", class: "input-underline", maxlength: "60" }, null, 8, ["modelValue"])]), _: 1 })])]), _: 1, __: [56] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[57] || (I[57] = C("span", { class: "item-title common-class" }, "销售员是否配合", -1)), C("div", jhe, [s(B, { class: "el-form-item-18", label: "", prop: "branchCompanyId", "label-width": "0" }, { default: p(() => [g.value.infoSource ? (w(), Q("span", Fhe, K(l(A)(g.value.boolCoordinate) ? g.value.boolCoordinate ? "是" : "否" : "-"), 1)) : (w(), Q("span", zhe, "-"))]), _: 1 })])]), _: 1, __: [57] }), s(q, { span: 24, class: "item-wrap" }, { default: p(() => I[58] || (I[58] = [C("div", { class: "single-class" }, "签订方", -1)])), _: 1, __: [58] }), s(q, { span: 12, class: "item-wrap" }, { default: p(() => [I[59] || (I[59] = C("span", { class: "item-title common-class needItem" }, "甲方", -1)), C("div", Bhe, [s(B, { class: "el-form-item-18", label: "", prop: "partyA", "label-width": "0" }, { default: p(() => [s(ae, { modelValue: g.value.partyA, "onUpdate:modelValue": I[11] || (I[11] = (se) => g.value.partyA = se), modelModifiers: { trim: true }, type: "text", placeholder: "甲方", class: "input-underline", maxlength: "60" }, null, 8, ["modelValue"])]), _: 1 })])]), _: 1, __: [59] }), s(q, { span: 12, class: "item-wrap" }, { default: p(() => [I[60] || (I[60] = C("span", { class: "item-title common-class needItem" }, "乙方", -1)), C("div", Hhe, [s(B, { class: "el-form-item-18", label: "", prop: "partyB", "label-width": "0" }, { default: p(() => [s(ae, { modelValue: g.value.partyB, "onUpdate:modelValue": I[12] || (I[12] = (se) => g.value.partyB = se), modelModifiers: { trim: true }, type: "text", placeholder: "乙方", class: "input-underline", maxlength: "60" }, null, 8, ["modelValue"])]), _: 1 })])]), _: 1, __: [60] }), s(q, { span: 12, class: "item-wrap" }, { default: p(() => [I[61] || (I[61] = C("span", { class: "item-title common-class" }, "丙方", -1)), C("div", qhe, [s(B, { class: "el-form-item-18", label: "", prop: "partyC", "label-width": "0" }, { default: p(() => [s(ae, { modelValue: g.value.partyC, "onUpdate:modelValue": I[13] || (I[13] = (se) => g.value.partyC = se), modelModifiers: { trim: true }, type: "text", placeholder: "丙方", class: "input-underline", maxlength: "60" }, null, 8, ["modelValue"])]), _: 1 })])]), _: 1, __: [61] }), s(q, { span: 12, class: "item-wrap" }, { default: p(() => [I[62] || (I[62] = C("span", { class: "item-title common-class" }, "丁方", -1)), C("div", Ghe, [s(B, { class: "el-form-item-18", label: "", prop: "partyD", "label-width": "0" }, { default: p(() => [s(ae, { modelValue: g.value.name, "onUpdate:modelValue": I[14] || (I[14] = (se) => g.value.name = se), modelModifiers: { trim: true }, type: "text", placeholder: "丁方", class: "input-underline", maxlength: "60" }, null, 8, ["modelValue"])]), _: 1 })])]), _: 1, __: [62] }), s(q, { span: 24, class: "item-wrap" }, { default: p(() => I[63] || (I[63] = [C("div", { class: "single-class" }, "主要内容", -1)])), _: 1, __: [63] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[64] || (I[64] = C("span", { class: "item-title common-class" }, "中标通知书", -1)), C("div", Qhe, [s(B, { class: "el-form-item-18", label: "", prop: "boolBidWinningNotice", "label-width": "0" }, { default: p(() => [s(ee, { modelValue: g.value.boolBidWinningNotice, "onUpdate:modelValue": I[15] || (I[15] = (se) => g.value.boolBidWinningNotice = se), options: l(qn).ENUM, type: "enum", size: "default", clearable: "", style: { width: "100%" }, class: "input-underline", placeholder: "请选择" }, null, 8, ["modelValue", "options"])]), _: 1 })])]), _: 1, __: [64] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[65] || (I[65] = C("span", { class: "item-title common-class" }, "图纸", -1)), C("div", Zhe, [s(B, { class: "el-form-item-18", label: "", prop: "drawing", "label-width": "0" }, { default: p(() => [s(ee, { modelValue: g.value.drawing, "onUpdate:modelValue": I[16] || (I[16] = (se) => g.value.drawing = se), options: l(gr).ENUM, type: "enum", size: "default", clearable: "", style: { width: "100%" }, class: "input-underline", placeholder: "请选择" }, null, 8, ["modelValue", "options"])]), _: 1 })])]), _: 1, __: [65] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[66] || (I[66] = C("span", { class: "item-title common-class" }, "是否有报价书", -1)), C("div", Jhe, [s(B, { class: "el-form-item-18", label: "", prop: "boolBidProposals", "label-width": "0" }, { default: p(() => [s(ee, { modelValue: g.value.boolBidProposals, "onUpdate:modelValue": I[17] || (I[17] = (se) => g.value.boolBidProposals = se), options: l(ea).ENUM, type: "enum", size: "default", clearable: "", style: { width: "100%" }, class: "input-underline", placeholder: "请选择" }, null, 8, ["modelValue", "options"])]), _: 1 })])]), _: 1, __: [66] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[67] || (I[67] = C("span", { class: "item-title common-class" }, "是否有招标文件", -1)), C("div", Xhe, [s(B, { class: "el-form-item-18", label: "", prop: "boolBidDocument", "label-width": "0" }, { default: p(() => [s(ee, { modelValue: g.value.boolBidDocument, "onUpdate:modelValue": I[18] || (I[18] = (se) => g.value.boolBidDocument = se), options: l(ea).ENUM, type: "enum", size: "default", clearable: "", style: { width: "100%" }, class: "input-underline", placeholder: "请选择" }, null, 8, ["modelValue", "options"])]), _: 1 })])]), _: 1, __: [67] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[68] || (I[68] = C("span", { class: "item-title common-class" }, "承包性质", -1)), C("div", $he, [s(B, { class: "el-form-item-18", label: "", prop: "contractualNature", "label-width": "0" }, { default: p(() => [s(ee, { modelValue: g.value.contractualNature, "onUpdate:modelValue": I[19] || (I[19] = (se) => g.value.contractualNature = se), options: l(c)[l(Ja).CONTRACTUAL_NATURE.V], dataStructure: { key: "id", label: "fieldValue", value: "id" }, disabled: !l(n), clearable: "", class: "input-underline", placeholder: "请选择承包性质", style: { width: "100%" } }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 })])]), _: 1, __: [68] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[69] || (I[69] = C("span", { class: "item-title common-class" }, "招标方式", -1)), C("div", efe, [s(B, { class: "el-form-item-18", label: "", prop: "biddingMethod", "label-width": "0" }, { default: p(() => [s(ee, { modelValue: g.value.biddingMethod, "onUpdate:modelValue": I[20] || (I[20] = (se) => g.value.biddingMethod = se), options: l(c)[l(Ja).BIDDING_METHOD.V], dataStructure: { key: "id", label: "fieldValue", value: "id" }, disabled: !l(n), clearable: "", class: "input-underline", placeholder: "请选择招标方式", style: { width: "100%" } }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 })])]), _: 1, __: [69] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[70] || (I[70] = C("span", { class: "item-title common-class" }, "甲方类别", -1)), C("div", tfe, [s(B, { class: "el-form-item-18", label: "", prop: "partyType", "label-width": "0" }, { default: p(() => [s(ee, { modelValue: g.value.partyType, "onUpdate:modelValue": I[21] || (I[21] = (se) => g.value.partyType = se), options: l(c)[l(Ja).PARTY_TYPE.V], dataStructure: { key: "id", label: "fieldValue", value: "id" }, disabled: !l(n), clearable: "", class: "input-underline", placeholder: "请选择甲方类别", style: { width: "100%" } }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 })])]), _: 1, __: [70] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[71] || (I[71] = C("span", { class: "item-title common-class" }, "是否装配式建筑", -1)), C("div", ife, [s(B, { class: "el-form-item-18", label: "", prop: "boolFabricatedStructure", "label-width": "0" }, { default: p(() => [s(ee, { modelValue: g.value.boolFabricatedStructure, "onUpdate:modelValue": I[22] || (I[22] = (se) => g.value.boolFabricatedStructure = se), options: l(ea).ENUM, type: "enum", size: "default", clearable: "", style: { width: "100%" }, class: "input-underline", placeholder: "请选择" }, null, 8, ["modelValue", "options"])]), _: 1 })])]), _: 1, __: [71] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[72] || (I[72] = C("span", { class: "item-title common-class" }, "是否示范合同", -1)), C("div", afe, [s(B, { class: "el-form-item-18", label: "", prop: "boolModelContract", "label-width": "0" }, { default: p(() => [s(ee, { modelValue: g.value.boolModelContract, "onUpdate:modelValue": I[23] || (I[23] = (se) => g.value.boolModelContract = se), options: l(ea).ENUM, type: "enum", size: "default", clearable: "", style: { width: "100%" }, class: "input-underline", placeholder: "请选择" }, null, 8, ["modelValue", "options"])]), _: 1 })])]), _: 1, __: [72] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[73] || (I[73] = C("span", { class: "item-title common-class" }, "工程所在地", -1)), C("div", lfe, [s(B, { class: "el-form-item-18", label: "", prop: "region", "label-width": "0" }, { default: p(() => [s(l(f2), { ref_key: "region", ref: h, modelValue: g.value.region, "onUpdate:modelValue": I[24] || (I[24] = (se) => g.value.region = se), class: "input-underline", clearable: "", filterable: "", placeholder: "工程所在地", style: { width: "100%" }, onChange: L }, null, 8, ["modelValue"])]), _: 1 })])]), _: 1, __: [73] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[74] || (I[74] = C("span", { class: "item-title common-class" }, "区域", -1)), C("div", ofe, [s(B, { class: "el-form-item-18", label: "", prop: "locationValue", "label-width": "0" }, { default: p(() => [C("span", null, K(g.value.locationValue), 1)]), _: 1 })])]), _: 1, __: [74] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[75] || (I[75] = C("span", { class: "item-title common-class" }, "结构类型", -1)), C("div", nfe, [s(B, { class: "el-form-item-18", label: "", prop: "structureType", "label-width": "0" }, { default: p(() => [s(ee, { modelValue: g.value.structureType, "onUpdate:modelValue": I[25] || (I[25] = (se) => g.value.structureType = se), options: l(c)[l(Ja).STRUCTURE_TYPE.V], dataStructure: { key: "id", label: "fieldValue", value: "id" }, disabled: !l(n), clearable: "", class: "input-underline", placeholder: "请选择结构类型", style: { width: "100%" } }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 })])]), _: 1, __: [75] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[76] || (I[76] = C("span", { class: "item-title common-class" }, "建筑面积（平方米）", -1)), C("div", sfe, [s(B, { class: "el-form-item-18", label: "", prop: "structureArea", "label-width": "0" }, { default: p(() => [s(le, { modelValue: g.value.structureArea, "onUpdate:modelValue": I[26] || (I[26] = (se) => g.value.structureArea = se), controls: false, max: 999999999999, precision: l(Ze).COM_AREA__M2, step: 1, autocomplete: "off", class: "input-underline", placeholder: "请填写建筑面积", style: { width: "100%" } }, null, 8, ["modelValue", "precision"])]), _: 1 })])]), _: 1, __: [76] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[77] || (I[77] = C("span", { class: "item-title common-class needItem" }, "主结构用钢量(吨)", -1)), C("div", rfe, [s(B, { class: "el-form-item-18", label: "", prop: "mainStructureSteelMete", "label-width": "0" }, { default: p(() => [s(le, { modelValue: g.value.mainStructureSteelMete, "onUpdate:modelValue": I[27] || (I[27] = (se) => g.value.mainStructureSteelMete = se), controls: false, max: 999999999999, precision: l(Ze).COM_WT__G, step: 1, autocomplete: "off", class: "input-underline", placeholder: "请填写主结构用钢量(吨)", style: { width: "100%" } }, null, 8, ["modelValue", "precision"])]), _: 1 })])]), _: 1, __: [77] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[78] || (I[78] = C("span", { class: "item-title common-class" }, "次结构用钢量(吨)", -1)), C("div", ufe, [s(B, { class: "el-form-item-18", label: "", prop: "subfabricSteelMete", "label-width": "0" }, { default: p(() => [s(le, { modelValue: g.value.subfabricSteelMete, "onUpdate:modelValue": I[28] || (I[28] = (se) => g.value.subfabricSteelMete = se), controls: false, max: 999999999999, precision: l(Ze).COM_WT__G, step: 1, autocomplete: "off", class: "input-underline", placeholder: "请填写次结构用钢量(吨)", style: { width: "100%" } }, null, 8, ["modelValue", "precision"])]), _: 1 })])]), _: 1, __: [78] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[79] || (I[79] = C("span", { class: "item-title common-class" }, "最大跨度/高度", -1)), C("div", cfe, [s(B, { class: "el-form-item-18", label: "", prop: "maximumSpan", "label-width": "0" }, { default: p(() => [s(le, { modelValue: g.value.maximumSpan, "onUpdate:modelValue": I[29] || (I[29] = (se) => g.value.maximumSpan = se), controls: false, max: 999999999999, precision: l(Ze).COM_T__MM, step: 1, autocomplete: "off", class: "input-underline", placeholder: "请填写建筑面积", style: { width: "100%" } }, null, 8, ["modelValue", "precision"])]), _: 1 })])]), _: 1, __: [79] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[80] || (I[80] = C("span", { class: "item-title common-class needItem" }, "开竣工日期", -1)), C("div", dfe, [s(B, { class: "el-form-item-18", label: "", prop: "dateTime", "label-width": "0" }, { default: p(() => [s(j, { modelValue: g.value.dateTime, "onUpdate:modelValue": I[30] || (I[30] = (se) => g.value.dateTime = se), type: "daterange", "range-separator": ":", size: "default", class: "input-underline", "start-placeholder": "开工日期", "end-placeholder": "竣工日期", "value-format": "x", style: { width: "100%" }, onChange: P }, null, 8, ["modelValue"])]), _: 1 })])]), _: 1, __: [80] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[81] || (I[81] = C("span", { class: "item-title common-class" }, "总工期（天）", -1)), C("div", mfe, [s(B, { class: "el-form-item-18", label: "", prop: "", "label-width": "0" }, { default: p(() => [Te(K(g.value.allDays || "-"), 1)]), _: 1 })])]), _: 1, __: [81] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[82] || (I[82] = C("span", { class: "item-title common-class" }, "预付款比例", -1)), C("div", pfe, [s(B, { class: "el-form-item-18", label: "", prop: "prepaymentRatio", "label-width": "0" }, { default: p(() => [s(ae, { modelValue: g.value.prepaymentRatio, "onUpdate:modelValue": I[31] || (I[31] = (se) => g.value.prepaymentRatio = se), modelModifiers: { trim: true }, type: "text", placeholder: "预付款比例", class: "input-underline", maxlength: "200" }, null, 8, ["modelValue"])]), _: 1 })])]), _: 1, __: [82] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[83] || (I[83] = C("span", { class: "item-title common-class" }, "质保金比例(%)", -1)), C("div", hfe, [s(B, { class: "el-form-item-18", label: "", prop: "warrantyRatio", "label-width": "0" }, { default: p(() => [s(le, { modelValue: g.value.warrantyRatio, "onUpdate:modelValue": I[32] || (I[32] = (se) => g.value.warrantyRatio = se), controls: false, max: 100, precision: 2, step: 1, autocomplete: "off", class: "input-underline", placeholder: "请填写质保金比例", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 })])]), _: 1, __: [83] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[84] || (I[84] = C("span", { class: "item-title common-class" }, "农民工工资专户", -1)), C("div", ffe, [s(B, { class: "el-form-item-18", label: "", prop: "boolPeasantWorkerWageAccount", "label-width": "0" }, { default: p(() => [s(ee, { modelValue: g.value.boolPeasantWorkerWageAccount, "onUpdate:modelValue": I[33] || (I[33] = (se) => g.value.boolPeasantWorkerWageAccount = se), options: l(ea).ENUM, type: "enum", size: "default", clearable: "", style: { width: "100%" }, class: "input-underline", placeholder: "请选择" }, null, 8, ["modelValue", "options"])]), _: 1 })])]), _: 1, __: [84] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[85] || (I[85] = C("span", { class: "item-title common-class" }, "农民工工资专户比例", -1)), C("div", gfe, [s(B, { class: "el-form-item-18", label: "", prop: "peasantWorkerWageRatio", "label-width": "0" }, { default: p(() => [s(ae, { modelValue: g.value.peasantWorkerWageRatio, "onUpdate:modelValue": I[34] || (I[34] = (se) => g.value.peasantWorkerWageRatio = se), modelModifiers: { trim: true }, type: "text", placeholder: "农民工工资专户比例", class: "input-underline", maxlength: "200" }, null, 8, ["modelValue"])]), _: 1 })])]), _: 1, __: [85] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[86] || (I[86] = C("span", { class: "item-title common-class" }, "进度款", -1)), C("div", Efe, [s(B, { class: "el-form-item-18", label: "", prop: "progressPayment", "label-width": "0" }, { default: p(() => [s(ae, { modelValue: g.value.progressPayment, "onUpdate:modelValue": I[35] || (I[35] = (se) => g.value.progressPayment = se), modelModifiers: { trim: true }, type: "text", placeholder: "进度款", class: "input-underline", maxlength: "200" }, null, 8, ["modelValue"])]), _: 1 })])]), _: 1, __: [86] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[87] || (I[87] = C("span", { class: "item-title common-class" }, "材料调差", -1)), C("div", yfe, [s(B, { class: "el-form-item-18", label: "", prop: "materialInspection", "label-width": "0" }, { default: p(() => [s(ae, { modelValue: g.value.materialInspection, "onUpdate:modelValue": I[36] || (I[36] = (se) => g.value.materialInspection = se), modelModifiers: { trim: true }, type: "text", placeholder: "材料调差", class: "input-underline", maxlength: "200" }, null, 8, ["modelValue"])]), _: 1 })])]), _: 1, __: [87] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[88] || (I[88] = C("span", { class: "item-title common-class" }, "说明", -1)), C("div", Tfe, [s(B, { class: "el-form-item-18", label: "", prop: "remark", "label-width": "0" }, { default: p(() => [s(ae, { modelValue: g.value.remark, "onUpdate:modelValue": I[37] || (I[37] = (se) => g.value.remark = se), rows: 2, maxlength: "1000", placeholder: "说明", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue"])]), _: 1 })])]), _: 1, __: [88] }), s(q, { span: 16, class: "item-wrap" }, { default: p(() => [I[89] || (I[89] = C("span", { class: "item-title common-class" }, "合同附件", -1)), C("div", _fe, [s(B, { class: "el-form-item-18", label: "", prop: "branchCompanyId", "label-width": "0" }, { default: p(() => [s(dl, { files: g.value.attachmentList, "onUpdate:files": I[38] || (I[38] = (se) => g.value.attachmentList = se), showView: true, class: "el-form-item-15", "empty-text": "暂未上传合同附件", "show-download": "" }, null, 8, ["files"])]), _: 1 })])]), _: 1, __: [89] })]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, q8 = ut(bfe, [["__scopeId", "data-v-2ab5be50"]]), Vfe = Object.freeze(Object.defineProperty({ __proto__: null, default: q8 }, Symbol.toStringTag, { value: "Module" }));
const wfe = { key: 1, class: "footer" }, Sfe = { class: "common-class item-content" }, vfe = { class: "common-class item-content" }, Rfe = { class: "common-class item-content" }, Mfe = { class: "common-class item-content" }, Afe = { class: "common-class item-content" }, Nfe = { class: "common-class item-content" }, Lfe = { class: "common-class item-content" }, Ife = { class: "common-class item-content" }, Cfe = { class: "common-class item-content" }, Pfe = { class: "common-class item-content" }, Ofe = { class: "common-class item-content" }, kfe = { class: "common-class item-content" }, Dfe = { class: "common-class item-content" }, xfe = { class: "common-class item-content" }, Ufe = { __name: "detail", props: { ApprovalFlag: { type: Boolean, default: false }, journalId: { type: [String, Number], default: void 0 } }, emits: ["auditSuccess", "submitSuccess"], setup(e, { emit: o }) {
  const n = e, c = o, { crud: u, CRUD: r, detail: E } = qi(), y = Z(false), b = Z(), V = Z(false);
  r.HOOK.beforeDetailLoaded = async (S, h) => {
    b.value = void 0;
    const T = [];
    h.countryValue && T.push(h.countryValue), h.provinceValue && T.push(h.provinceValue), h.cityValue && T.push(h.cityValue), h.regionValue && T.push(h.regionValue), h.address = T.join("/");
  };
  async function M(S) {
    try {
      if (y.value = true, S === Lt.REFUSE.V && !A(b.value)) {
        ot.error("请输入审批意见");
        return;
      }
      const h = { approveRecordId: n.journalId, decision: S, opinion: b.value };
      await Ehe(h), c("auditSuccess");
    } catch (h) {
      console.log("合同预登记审核提交", h);
    } finally {
      y.value = false;
    }
  }
  function g() {
    E.boolQuote = true, u.cancelDetail(), c("submitSuccess");
  }
  return (S, h) => {
    const T = Ve("common-button"), _ = La, f = pa, m = Zi, R = Bn, v = Hn, N = Li, P = Mt, L = Ve("common-drawer");
    return w(), U(L, { "append-to-body": "", "close-on-click-modal": false, "before-close": l(u).cancelDetail, visible: l(u).detailVisible, title: "合同预登记详情", "wrapper-closable": false, size: "1000px" }, Zl({ titleRight: p(() => [l(A)(l(E)) ? (w(), Q(Qe, { key: 0 }, [!l(E).boolQuote && l(E).reviewStatus === l(Lt).PASS.V && l(Ai)(l(u).permission.reviewAdd) ? (w(), U(T, { key: 0, type: "warning", size: "default", onClick: h[0] || (h[0] = (O) => V.value = true) }, { default: p(() => h[6] || (h[6] = [Te("发起评审登记申请")])), _: 1, __: [6] })) : H("", true), n.ApprovalFlag ? (w(), Q("div", wfe, [s(f, { title: "确认通过", onConfirm: h[1] || (h[1] = (O) => M(l(Lt).PASS.V)) }, { reference: p(() => [s(T, { class: "filter-item", size: "default", type: "success" }, { default: p(() => h[7] || (h[7] = [Te("通过")])), _: 1, __: [7] })]), _: 1 }), s(f, { title: "确认驳回", onConfirm: h[2] || (h[2] = (O) => M(l(Lt).REFUSE.V)) }, { reference: p(() => [s(T, { class: "filter-item", size: "default", type: "danger" }, { default: p(() => h[8] || (h[8] = [Te(" 驳回 ")])), _: 1, __: [8] })]), _: 1 })])) : H("", true)], 64)) : H("", true)]), content: p(() => [s(N, { ref: "formRef", size: "default", "label-width": "120px", "label-position": "right" }, { default: p(() => [s(v, { style: { border: "1px solid #ebeef5", "margin-bottom": "10px" } }, { default: p(() => [s(R, { span: 24, class: "item-wrap" }, { default: p(() => [h[9] || (h[9] = C("span", { class: "item-title common-class needItem" }, "甲方或业主名称", -1)), C("div", Sfe, [s(m, { class: "el-form-item-18", label: "", prop: "branchCompanyId", "label-width": "0" }, { default: p(() => [Te(K(l(E).partyName), 1)]), _: 1 })])]), _: 1, __: [9] }), s(R, { span: 24, class: "item-wrap" }, { default: p(() => [h[10] || (h[10] = C("span", { class: "item-title common-class needItem" }, "项目名称", -1)), C("div", vfe, [s(m, { class: "el-form-item-18", label: "", prop: "branchCompanyId", "label-width": "0" }, { default: p(() => [Te(K(l(E).projectName), 1)]), _: 1 })])]), _: 1, __: [10] }), s(R, { span: 12, class: "item-wrap" }, { default: p(() => [h[11] || (h[11] = C("span", { class: "item-title common-class needItem" }, "合同金额（元）", -1)), C("div", Rfe, [s(m, { class: "el-form-item-18", label: "", prop: "branchCompanyId", "label-width": "0" }, { default: p(() => [Te(K(l(E).contractAmount), 1)]), _: 1 })])]), _: 1, __: [11] }), s(R, { span: 12, class: "item-wrap" }, { default: p(() => [h[12] || (h[12] = C("span", { class: "item-title common-class" }, "合同金额大写", -1)), C("div", Mfe, [s(m, { class: "el-form-item-18", label: "", prop: "contractAmount", "label-width": "0" }, { default: p(() => [Te(K(l(E).contractAmount ? l(iu)(l(E).contractAmount) : "-"), 1)]), _: 1 })])]), _: 1, __: [12] }), s(R, { span: 12, class: "item-wrap" }, { default: p(() => [h[13] || (h[13] = C("span", { class: "item-title common-class needItem" }, "中标通知书", -1)), C("div", Afe, [s(m, { class: "el-form-item-18", label: "", prop: "branchCompanyId", "label-width": "0" }, { default: p(() => [Te(K(l(qn).VL[l(E).boolBidWinningNotice]), 1)]), _: 1 })])]), _: 1, __: [13] }), s(R, { span: 12, class: "item-wrap" }, { default: p(() => [h[14] || (h[14] = C("span", { class: "item-title common-class needItem" }, "甲方类别", -1)), C("div", Nfe, [s(m, { class: "el-form-item-18", label: "", prop: "branchCompanyId", "label-width": "0" }, { default: p(() => [Te(K(l(E).partyTypeValue), 1)]), _: 1 })])]), _: 1, __: [14] }), s(R, { span: 12, class: "item-wrap" }, { default: p(() => [h[15] || (h[15] = C("span", { class: "item-title common-class needItem" }, "工程所在地", -1)), C("div", Lfe, [s(m, { class: "el-form-item-18", label: "", prop: "branchCompanyId", "label-width": "0" }, { default: p(() => [Te(K(l(E).address), 1)]), _: 1 })])]), _: 1, __: [15] }), s(R, { span: 12, class: "item-wrap" }, { default: p(() => [h[16] || (h[16] = C("span", { class: "item-title common-class needItem" }, "区域", -1)), C("div", Ife, [s(m, { class: "el-form-item-18", label: "", prop: "branchCompanyId", "label-width": "0" }, { default: p(() => [Te(K(l(E).locationValue), 1)]), _: 1 })])]), _: 1, __: [16] }), s(R, { span: 12, class: "item-wrap" }, { default: p(() => [h[17] || (h[17] = C("span", { class: "item-title common-class needItem" }, "结构类型", -1)), C("div", Cfe, [s(m, { class: "el-form-item-18", label: "", prop: "branchCompanyId", "label-width": "0" }, { default: p(() => [Te(K(l(E).structureTypeValue), 1)]), _: 1 })])]), _: 1, __: [17] }), s(R, { span: 12, class: "item-wrap" }, { default: p(() => [h[18] || (h[18] = C("span", { class: "item-title common-class needItem" }, "建筑面积（平方米）", -1)), C("div", Pfe, [s(m, { class: "el-form-item-18", label: "", prop: "branchCompanyId", "label-width": "0" }, { default: p(() => [Te(K(l(E).structureArea), 1)]), _: 1 })])]), _: 1, __: [18] }), s(R, { span: 12, class: "item-wrap" }, { default: p(() => [h[19] || (h[19] = C("span", { class: "item-title common-class needItem" }, "承包性质", -1)), C("div", Ofe, [s(m, { class: "el-form-item-18", label: "", prop: "branchCompanyId", "label-width": "0" }, { default: p(() => [Te(K(l(E).contractualNatureValue), 1)]), _: 1 })])]), _: 1, __: [19] }), s(R, { span: 12, class: "item-wrap" }, { default: p(() => [h[20] || (h[20] = C("span", { class: "item-title common-class needItem" }, "信息来源", -1)), C("div", kfe, [s(m, { class: "el-form-item-18", label: "", prop: "branchCompanyId", "label-width": "0" }, { default: p(() => [Te(K(l(Cl).VL[l(E).infoSource]), 1)]), _: 1 })])]), _: 1, __: [20] }), s(R, { span: 24, class: "item-wrap" }, { default: p(() => [h[21] || (h[21] = C("span", { class: "item-title common-class needItem" }, "签订人", -1)), C("div", Dfe, [s(m, { class: "el-form-item-18", label: "", prop: "branchCompanyId", "label-width": "0" }, { default: p(() => [Te(K(l(E).signerName), 1)]), _: 1 })])]), _: 1, __: [21] }), s(R, { span: 24, class: "item-wrap" }, { default: p(() => [h[22] || (h[22] = C("span", { class: "item-title common-class" }, "说明", -1)), C("div", xfe, [s(m, { class: "el-form-item-18", label: "", prop: "branchCompanyId", "label-width": "0" }, { default: p(() => [Te(K(l(E).remark), 1)]), _: 1 })])]), _: 1, __: [22] })]), _: 1 })]), _: 1 }, 512), s(q8, { modelValue: V.value, "onUpdate:modelValue": h[3] || (h[3] = (O) => V.value = O), detailInfo: l(E), onSuccess: g }, null, 8, ["modelValue", "detailInfo"]), n.ApprovalFlag ? (w(), U(P, { key: 0, modelValue: b.value, "onUpdate:modelValue": h[4] || (h[4] = (O) => b.value = O), rows: 2, class: "approval-comments", maxlength: "1000", placeholder: "审核意见", "show-word-limit": "", style: { "margin-top": "5px" }, type: "textarea" }, null, 8, ["modelValue"])) : H("", true)]), _: 2 }, [l(A)(l(E)) ? { name: "titleAfter", fn: p(() => [l(E).wmsApproveRecordFlowDTO ? (w(), U(_, { key: 0, placement: "bottom-start", width: 400, trigger: "hover" }, { reference: p(() => [s(T, { style: { width: "180px" } }, { default: p(() => h[5] || (h[5] = [Te("查看审批记录")])), _: 1, __: [5] })]), default: p(() => [s(tl, { data: l(E).wmsApproveRecordFlowDTO || [] }, null, 8, ["data"])]), _: 1 })) : H("", true)]), key: "0" } : void 0]), 1032, ["before-close", "visible"]);
  };
} }, G8 = ut(Ufe, [["__scopeId", "data-v-b084ba36"]]), Yfe = Object.freeze(Object.defineProperty({ __proto__: null, default: G8 }, Symbol.toStringTag, { value: "Module" }));
const Kfe = { class: "common-class item-content" }, Wfe = { class: "common-class item-content" }, jfe = { class: "common-class item-content" }, Ffe = { class: "common-class item-content" }, zfe = { class: "common-class item-content" }, Bfe = { class: "common-class item-content" }, Hfe = { class: "common-class item-content" }, qfe = { class: "common-class item-content" }, Gfe = { class: "common-class item-content" }, Qfe = { class: "common-class item-content" }, Zfe = { class: "common-class item-content" }, Jfe = { class: "common-class item-content" }, Xfe = { class: "common-class item-content" }, $fe = { class: "common-class item-content" }, ege = { __name: "form", setup(e) {
  const { loaded: o, catalogContentConfig: n } = g2(), c = Z(), u = Z(), r = Z(), E = Z(false), y = { partyType: void 0, partyName: void 0, projectName: void 0, contractAmount: void 0, boolBidWinningNotice: void 0, structureType: void 0, contractualNature: void 0, signerId: void 0, signerName: void 0, locationId: void 0, countryId: void 0, provinceId: void 0, cityId: void 0, regionId: void 0, structureArea: void 0, infoSource: void 0, remark: void 0 }, { CRUD: b, crud: V, form: M } = An(y, c), g = { partyName: [{ required: true, message: "请输入甲方或业主名称", trigger: "blur" }], projectName: [{ required: true, message: "请输入项目名称", trigger: "blur" }], contractAmount: [{ required: true, message: "请输入合同金额", trigger: "change" }], boolBidWinningNotice: [{ required: true, message: "请选择有无中标通知书", trigger: "change" }], partyType: [{ required: true, message: "请选择甲方类别", trigger: "change" }], structureType: [{ required: true, message: "请选择结构类型", trigger: "change" }], structureArea: [{ required: true, message: "请填写建筑面积", trigger: "blur" }], contractualNature: [{ required: true, message: "请选择承包性质", trigger: "change" }], infoSource: [{ required: true, message: "请选择信息来源", trigger: "change" }], signerId: [{ required: true, message: "请选择签订人", trigger: "change" }] };
  function S(h) {
    M.countryId = void 0, M.provinceId = void 0, M.cityId = void 0, M.regionId = void 0, h && h.forEach((T, _) => {
      _ === 0 && (M.countryId = T), _ === 1 && (M.provinceId = T), _ === 2 && (M.cityId = T), _ === 3 && (M.regionId = T);
    }), pt(() => {
      var T;
      if (!E.value) {
        const _ = (T = u.value) == null ? void 0 : T.getNodeInfo();
        M.locationId = _ == null ? void 0 : _.locationId, M.locationValue = _ == null ? void 0 : _.locationName;
      }
    });
  }
  return b.HOOK.beforeSubmit = async () => {
    var h;
    V.form.signerName = (h = r == null ? void 0 : r.value.getNodeInfo()) == null ? void 0 : h.label, V.status.edit > 0 && (V.crudApi.edit = _he.edit);
  }, b.HOOK.beforeEditDetailLoaded = async (h) => {
    const T = [];
    E.value = true, M.countryId && T.push(M.countryId), M.provinceId && T.push(M.provinceId), M.cityId && T.push(M.cityId), M.regionId && T.push(M.regionId), M.region = T, setTimeout(() => {
      E.value = false;
    });
  }, (h, T) => {
    const _ = Ve("common-button"), f = Mt, m = Zi, R = Bn, v = Ve("common-input-number"), N = Ve("common-select"), P = Hn, L = Li, O = Ve("common-drawer");
    return w(), U(O, { "append-to-body": "", "close-on-click-modal": false, "before-close": l(V).cancelCU, visible: l(V).status.cu > 0, title: "合同预登记申请", "wrapper-closable": false, size: "1100px" }, { titleRight: p(() => [s(_, { loading: l(V).status.cu === 2, type: "primary", size: "default", onClick: l(V).submitCU }, { default: p(() => T[12] || (T[12] = [Te("提交")])), _: 1, __: [12] }, 8, ["loading", "onClick"])]), content: p(() => [s(L, { ref_key: "formRef", ref: c, model: l(M), rules: g, size: "default", "label-width": "120px", "label-position": "right" }, { default: p(() => [s(P, { style: { border: "1px solid #ebeef5", "margin-bottom": "10px" } }, { default: p(() => [s(R, { span: 24, class: "item-wrap" }, { default: p(() => [T[13] || (T[13] = C("span", { class: "item-title common-class needItem" }, "甲方或业主名称", -1)), C("div", Kfe, [s(m, { class: "el-form-item-18", label: "", prop: "partyName", "label-width": "0" }, { default: p(() => [s(f, { modelValue: l(M).partyName, "onUpdate:modelValue": T[0] || (T[0] = (x) => l(M).partyName = x), modelModifiers: { trim: true }, type: "text", placeholder: "甲方或业主名称", class: "input-underline", maxlength: "60" }, null, 8, ["modelValue"])]), _: 1 })])]), _: 1, __: [13] }), s(R, { span: 24, class: "item-wrap" }, { default: p(() => [T[14] || (T[14] = C("span", { class: "item-title common-class needItem" }, "项目名称", -1)), C("div", Wfe, [s(m, { class: "el-form-item-18", label: "", prop: "projectName", "label-width": "0" }, { default: p(() => [s(f, { modelValue: l(M).projectName, "onUpdate:modelValue": T[1] || (T[1] = (x) => l(M).projectName = x), modelModifiers: { trim: true }, type: "text", placeholder: "项目名称", class: "input-underline", maxlength: "60" }, null, 8, ["modelValue"])]), _: 1 })])]), _: 1, __: [14] }), s(R, { span: 12, class: "item-wrap" }, { default: p(() => [T[15] || (T[15] = C("span", { class: "item-title common-class needItem" }, "合同金额（元）", -1)), C("div", jfe, [s(m, { class: "el-form-item-18", label: "", prop: "contractAmount", "label-width": "0" }, { default: p(() => [s(v, { modelValue: l(M).contractAmount, "onUpdate:modelValue": T[2] || (T[2] = (x) => l(M).contractAmount = x), controls: false, max: 999999999999, precision: l(Ze).YUAN, step: 1, autocomplete: "off", class: "input-underline", placeholder: "请填写合同金额", style: { width: "100%" } }, null, 8, ["modelValue", "precision"])]), _: 1 })])]), _: 1, __: [15] }), s(R, { span: 12, class: "item-wrap" }, { default: p(() => [T[16] || (T[16] = C("span", { class: "item-title common-class" }, "合同金额大写", -1)), C("div", Ffe, [s(m, { class: "el-form-item-18", label: "", prop: "", "label-width": "0" }, { default: p(() => [Te(K(l(M).contractAmount ? l(iu)(l(M).contractAmount) : "-"), 1)]), _: 1 })])]), _: 1, __: [16] }), s(R, { span: 12, class: "item-wrap" }, { default: p(() => [T[17] || (T[17] = C("span", { class: "item-title common-class needItem" }, "中标通知书", -1)), C("div", zfe, [s(m, { class: "el-form-item-18", label: "", prop: "boolBidWinningNotice", "label-width": "0" }, { default: p(() => [s(N, { modelValue: l(M).boolBidWinningNotice, "onUpdate:modelValue": T[3] || (T[3] = (x) => l(M).boolBidWinningNotice = x), options: l(qn).ENUM, type: "enum", size: "default", clearable: "", style: { width: "100%" }, class: "input-underline", placeholder: "请选择" }, null, 8, ["modelValue", "options"])]), _: 1 })])]), _: 1, __: [17] }), s(R, { span: 12, class: "item-wrap" }, { default: p(() => [T[18] || (T[18] = C("span", { class: "item-title common-class needItem" }, "甲方类别", -1)), C("div", Bfe, [s(m, { class: "el-form-item-18", label: "", prop: "partyType", "label-width": "0" }, { default: p(() => [s(N, { modelValue: l(M).partyType, "onUpdate:modelValue": T[4] || (T[4] = (x) => l(M).partyType = x), options: l(n)[l(Ja).PARTY_TYPE.V], dataStructure: { key: "id", label: "fieldValue", value: "id" }, disabled: !l(o), clearable: "", class: "input-underline", placeholder: "请选择甲方类别", style: { width: "100%" } }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 })])]), _: 1, __: [18] }), s(R, { span: 12, class: "item-wrap" }, { default: p(() => [T[19] || (T[19] = C("span", { class: "item-title common-class needItem" }, "工程所在地", -1)), C("div", Hfe, [s(m, { class: "el-form-item-18", label: "", prop: "region", "label-width": "0" }, { default: p(() => [s(l(f2), { ref_key: "region", ref: u, modelValue: l(M).region, "onUpdate:modelValue": T[5] || (T[5] = (x) => l(M).region = x), class: "input-underline", clearable: "", filterable: "", placeholder: "工程所在地", style: { width: "100%" }, onChange: S }, null, 8, ["modelValue"])]), _: 1 })])]), _: 1, __: [19] }), s(R, { span: 12, class: "item-wrap" }, { default: p(() => [T[20] || (T[20] = C("span", { class: "item-title common-class needItem" }, "区域", -1)), C("div", qfe, [s(m, { class: "el-form-item-18", label: "", prop: "locationValue", "label-width": "0" }, { default: p(() => [C("span", null, K(l(M).locationValue), 1)]), _: 1 })])]), _: 1, __: [20] }), s(R, { span: 12, class: "item-wrap" }, { default: p(() => [T[21] || (T[21] = C("span", { class: "item-title common-class needItem" }, "结构类型", -1)), C("div", Gfe, [s(m, { class: "el-form-item-18", label: "", prop: "structureType", "label-width": "0" }, { default: p(() => [s(N, { modelValue: l(M).structureType, "onUpdate:modelValue": T[6] || (T[6] = (x) => l(M).structureType = x), options: l(n)[l(Ja).STRUCTURE_TYPE.V], dataStructure: { key: "id", label: "fieldValue", value: "id" }, disabled: !l(o), clearable: "", class: "input-underline", placeholder: "请选择结构类型", style: { width: "100%" } }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 })])]), _: 1, __: [21] }), s(R, { span: 12, class: "item-wrap" }, { default: p(() => [T[22] || (T[22] = C("span", { class: "item-title common-class needItem" }, "建筑面积（平方米）", -1)), C("div", Qfe, [s(m, { class: "el-form-item-18", label: "", prop: "structureArea", "label-width": "0" }, { default: p(() => [s(v, { modelValue: l(M).structureArea, "onUpdate:modelValue": T[7] || (T[7] = (x) => l(M).structureArea = x), controls: false, max: 999999999999, precision: l(Ze).COM_AREA__M2, step: 1, autocomplete: "off", class: "input-underline", placeholder: "请填写建筑面积", style: { width: "100%" } }, null, 8, ["modelValue", "precision"])]), _: 1 })])]), _: 1, __: [22] }), s(R, { span: 12, class: "item-wrap" }, { default: p(() => [T[23] || (T[23] = C("span", { class: "item-title common-class needItem" }, "承包性质", -1)), C("div", Zfe, [s(m, { class: "el-form-item-18", label: "", prop: "contractualNature", "label-width": "0" }, { default: p(() => [s(N, { modelValue: l(M).contractualNature, "onUpdate:modelValue": T[8] || (T[8] = (x) => l(M).contractualNature = x), options: l(n)[l(Ja).CONTRACTUAL_NATURE.V], dataStructure: { key: "id", label: "fieldValue", value: "id" }, disabled: !l(o), clearable: "", class: "input-underline", placeholder: "请选择承包性质", style: { width: "100%" } }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 })])]), _: 1, __: [23] }), s(R, { span: 12, class: "item-wrap" }, { default: p(() => [T[24] || (T[24] = C("span", { class: "item-title common-class needItem" }, "信息来源", -1)), C("div", Jfe, [s(m, { class: "el-form-item-18", label: "", prop: "infoSource", "label-width": "0" }, { default: p(() => [s(N, { modelValue: l(M).infoSource, "onUpdate:modelValue": T[9] || (T[9] = (x) => l(M).infoSource = x), options: l(Cl).ENUM, type: "enum", size: "default", clearable: "", style: { width: "100%" }, class: "input-underline", placeholder: "请选择信息来源" }, null, 8, ["modelValue", "options"])]), _: 1 })])]), _: 1, __: [24] }), s(R, { span: 24, class: "item-wrap" }, { default: p(() => [T[25] || (T[25] = C("span", { class: "item-title common-class needItem" }, "签订人", -1)), C("div", Xfe, [s(m, { class: "el-form-item-18", label: "", prop: "signerId", "label-width": "0" }, { default: p(() => [s(Ds, { ref_key: "userDeptRef", ref: r, modelValue: l(M).signerId, "onUpdate:modelValue": T[10] || (T[10] = (x) => l(M).signerId = x), "collapse-tags": false, nofilterBlankDept: "", class: "input-underline", clearable: "", filterable: "", placeholder: "签订人", style: { width: "200px" } }, null, 8, ["modelValue"])]), _: 1 })])]), _: 1, __: [25] }), s(R, { span: 24, class: "item-wrap" }, { default: p(() => [T[26] || (T[26] = C("span", { class: "item-title common-class" }, "说明", -1)), C("div", $fe, [s(m, { class: "el-form-item-18", label: "", prop: "remark", "label-width": "0" }, { default: p(() => [s(f, { modelValue: l(M).remark, "onUpdate:modelValue": T[11] || (T[11] = (x) => l(M).remark = x), rows: 2, maxlength: "1000", placeholder: "说明", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue"])]), _: 1 })])]), _: 1, __: [26] })]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible"]);
  };
} }, Q8 = ut(ege, [["__scopeId", "data-v-e0c80179"]]), tge = Object.freeze(Object.defineProperty({ __proto__: null, default: Q8 }, Symbol.toStringTag, { value: "Module" }));
const ige = { key: 0, class: "footer" }, age = { class: "common-class item-content" }, lge = { key: 0 }, oge = { key: 1 }, nge = { class: "common-class item-content" }, sge = { class: "common-class item-content" }, rge = { class: "common-class item-content" }, uge = { class: "common-class item-content" }, cge = { class: "common-class item-content" }, dge = { class: "common-class item-content" }, mge = { class: "common-class item-content" }, pge = { class: "common-class item-content" }, hge = { class: "common-class item-content" }, fge = { class: "common-class item-content" }, gge = { class: "common-class item-content" }, Ege = { class: "common-class item-content" }, yge = { class: "common-class item-content" }, Tge = { class: "common-class item-content" }, _ge = { class: "common-class item-content" }, bge = { class: "common-class item-content" }, Vge = { class: "common-class item-content" }, wge = { class: "common-class item-content" }, Sge = { class: "common-class item-content" }, vge = { class: "common-class item-content" }, Rge = { class: "common-class item-content" }, Mge = { class: "common-class item-content" }, Age = { class: "common-class item-content" }, Nge = { class: "common-class item-content" }, Lge = { class: "common-class item-content" }, Ige = { class: "common-class item-content" }, Cge = { class: "common-class item-content" }, Pge = { class: "common-class item-content" }, Oge = { class: "common-class item-content" }, kge = { class: "common-class item-content" }, Dge = { class: "common-class item-content" }, xge = { class: "common-class item-content" }, Uge = { class: "common-class item-content" }, Yge = { class: "common-class item-content" }, Kge = { class: "common-class item-content" }, Wge = { class: "common-class item-content" }, jge = { class: "common-class item-content" }, Fge = { class: "common-class item-content" }, zge = { class: "common-class item-content" }, Bge = { class: "common-class item-content" }, Hge = { class: "common-class item-content" }, qge = { class: "common-class item-content" }, Gge = { class: "common-class item-content" }, Qge = { class: "common-class item-content" }, Zge = { class: "common-class item-content" }, Jge = { class: "common-class item-content" }, Xge = { __name: "detail", props: { ApprovalFlag: { type: Boolean, default: false }, journalId: { type: [String, Number], default: void 0 } }, emits: ["auditSuccess"], setup(e, { emit: o }) {
  const n = e, c = o, { CRUD: u, crud: r, detail: E } = qi(), y = Z(false), b = Z();
  u.HOOK.beforeDetailLoaded = async (M, g) => {
    const S = [];
    g.countryValue && S.push(g.countryValue), g.provinceValue && S.push(g.provinceValue), g.cityValue && S.push(g.cityValue), g.regionValue && S.push(g.regionValue), g.address = S.join("/"), g.contractDate = Qi(g.contractStartDate, "{y}-{m}-{d}") + "~" + Qi(g.contractEndDate, "{y}-{m}-{d}"), b.value = void 0, g.boolBindingPreRegistration = !!g.preRegistrationId, g.infoSource === Cl.MANAGER_SELLER.V || g.infoSource === Cl.NEW_MANAGER.V ? g.boolCoordinate = true : g.boolCoordinate = false;
  };
  async function V(M) {
    try {
      if (y.value = true, M === Lt.REFUSE.V && !A(b.value)) {
        ot.error("请输入审批意见");
        return;
      }
      const g = { approveRecordId: n.journalId, decision: M, opinion: b.value };
      await whe(g), c("auditSuccess");
    } catch (g) {
      console.log("合同评审登记审核提交", g);
    } finally {
      y.value = false;
    }
  }
  return (M, g) => {
    const S = Ve("common-button"), h = La, T = wi, _ = pa, f = Zi, m = Bn, R = Hn, v = Li, N = Mt, P = Ve("common-drawer"), L = _t("thousand");
    return w(), U(P, { "append-to-body": "", "close-on-click-modal": false, "before-close": l(r).cancelDetail, visible: l(r).detailVisible, title: "合同评审登记详情", "wrapper-closable": false, size: "85%" }, Zl({ titleRight: p(() => [l(A)(l(E)) ? (w(), Q(Qe, { key: 0 }, [n.ApprovalFlag ? (w(), Q("div", ige, [s(_, { title: "确认通过", onConfirm: g[0] || (g[0] = (O) => V(l(Lt).PASS.V)) }, { reference: p(() => [s(S, { class: "filter-item", size: "default", type: "success" }, { default: p(() => g[5] || (g[5] = [Te("通过")])), _: 1, __: [5] })]), _: 1 }), s(_, { title: "确认驳回", onConfirm: g[1] || (g[1] = (O) => V(l(Lt).REFUSE.V)) }, { reference: p(() => [s(S, { class: "filter-item", size: "default", type: "danger" }, { default: p(() => g[6] || (g[6] = [Te(" 驳回 ")])), _: 1, __: [6] })]), _: 1 })])) : H("", true)], 64)) : H("", true)]), content: p(() => [l(A)(l(E)) ? (w(), U(v, { key: 0, ref: "formRef", size: "default", "label-width": "120px", "label-position": "right" }, { default: p(() => [s(R, { style: { border: "1px solid #ebeef5", "margin-bottom": "10px" } }, { default: p(() => [s(m, { span: 8, class: "item-wrap" }, { default: p(() => [g[7] || (g[7] = C("span", { class: "item-title common-class needItem" }, "合同预登记", -1)), C("div", age, [s(f, { class: "el-form-item-18", label: "", prop: "boolBindingPreRegistration", "label-width": "0" }, { default: p(() => {
      var O;
      return [l(E).boolBindingPreRegistration ? H("", true) : (w(), Q("span", lge, K(l(ea).VL[l(E).boolBindingPreRegistration] || "-"), 1)), (O = l(E).preRegistration) != null && O.serialNumber ? (w(), Q("span", oge, "预登记单号：" + K(l(E).preRegistration.serialNumber), 1)) : H("", true)];
    }), _: 1 })])]), _: 1, __: [7] }), s(m, { span: 16, class: "item-wrap" }, { default: p(() => [g[8] || (g[8] = C("span", { class: "item-title common-class needItem" }, "标题", -1)), C("div", nge, [s(f, { class: "el-form-item-18", label: "", prop: "title", "label-width": "0" }, { default: p(() => [C("span", null, K(l(E).title || "-"), 1)]), _: 1 })])]), _: 1, __: [8] }), s(m, { span: 8, class: "item-wrap" }, { default: p(() => [g[9] || (g[9] = C("span", { class: "item-title common-class" }, "申请人", -1)), C("div", sge, [s(f, { class: "el-form-item-18", label: "", prop: "branchCompanyId", "label-width": "0" }, { default: p(() => [Te(K(l(E).applicantName || "-"), 1)]), _: 1 })])]), _: 1, __: [9] }), s(m, { span: 8, class: "item-wrap" }, { default: p(() => [g[10] || (g[10] = C("span", { class: "item-title common-class" }, "申请人部门", -1)), C("div", rge, [s(f, { class: "el-form-item-18", label: "", prop: "branchCompanyId", "label-width": "0" }, { default: p(() => [Te(K(l(E).applicantDeptName || "-"), 1)]), _: 1 })])]), _: 1, __: [10] }), s(m, { span: 8, class: "item-wrap" }, { default: p(() => [g[11] || (g[11] = C("span", { class: "item-title common-class" }, "申请编号", -1)), C("div", uge, [s(f, { class: "el-form-item-18", label: "", prop: "", "label-width": "0" }, { default: p(() => [C("span", null, K(l(E).applicationNumber || "-"), 1)]), _: 1 })])]), _: 1, __: [11] }), s(m, { span: 8, class: "item-wrap" }, { default: p(() => [g[12] || (g[12] = C("span", { class: "item-title common-class needItem" }, "申请时间", -1)), C("div", cge, [s(f, { class: "el-form-item-18", label: "", prop: "branchCompanyId", "label-width": "0" }, { default: p(() => [C("span", null, K(l(Qi)(l(E).applicationDate, "{y}-{m}-{d}")), 1)]), _: 1 })])]), _: 1, __: [12] }), s(m, { span: 16, class: "item-wrap" }, { default: p(() => [g[13] || (g[13] = C("span", { class: "item-title common-class needItem" }, "项目名称", -1)), C("div", dge, [s(f, { class: "el-form-item-18", label: "", prop: "projectName", "label-width": "0" }, { default: p(() => [C("span", null, K(l(E).projectName || "-"), 1)]), _: 1 })])]), _: 1, __: [13] }), s(m, { span: 8, class: "item-wrap" }, { default: p(() => [g[14] || (g[14] = C("span", { class: "item-title common-class needItem" }, "签订人", -1)), C("div", mge, [s(f, { class: "el-form-item-18", label: "", prop: "signerId", "label-width": "0" }, { default: p(() => [C("span", null, K(l(E).signerName || "-"), 1)]), _: 1 })])]), _: 1, __: [14] }), s(m, { span: 8, class: "item-wrap" }, { default: p(() => [g[15] || (g[15] = C("span", { class: "item-title common-class needItem" }, "所属一级部门", -1)), C("div", pge, [s(f, { class: "el-form-item-18", label: "", prop: "firstLevelDept", "label-width": "0" }, { default: p(() => [C("span", null, K(l(E).firstLevelDeptValue || "-"), 1)]), _: 1 })])]), _: 1, __: [15] }), s(m, { span: 8, class: "item-wrap" }, { default: p(() => [g[16] || (g[16] = C("span", { class: "item-title common-class" }, "所属二级部门", -1)), C("div", hge, [s(f, { class: "el-form-item-18", label: "", prop: "secondLevelDept", "label-width": "0" }, { default: p(() => [C("span", null, K(l(E).secondLevelDeptValue || "-"), 1)]), _: 1 })])]), _: 1, __: [16] }), s(m, { span: 8, class: "item-wrap" }, { default: p(() => [g[17] || (g[17] = C("span", { class: "item-title common-class needItem" }, "合同金额（元）", -1)), C("div", fge, [s(f, { class: "el-form-item-18", label: "", prop: "contractAmount", "label-width": "0" }, { default: p(() => [qe(C("span", null, null, 512), [[L, l(E).contractAmount]])]), _: 1 })])]), _: 1, __: [17] }), s(m, { span: 8, class: "item-wrap" }, { default: p(() => [g[18] || (g[18] = C("span", { class: "item-title common-class" }, "合同金额大写", -1)), C("div", gge, [s(f, { class: "el-form-item-18", label: "", prop: "contractAmount", "label-width": "0" }, { default: p(() => [Te(K(l(E).contractAmount ? l(iu)(l(E).contractAmount) : "-"), 1)]), _: 1 })])]), _: 1, __: [18] }), s(m, { span: 8, class: "item-wrap" }, { default: p(() => [g[19] || (g[19] = C("span", { class: "item-title common-class needItem" }, "税率（%）", -1)), C("div", Ege, [s(f, { class: "el-form-item-18", label: "", prop: "taxRate", "label-width": "0" }, { default: p(() => [C("span", null, K(l(E).taxRate || "-"), 1)]), _: 1 })])]), _: 1, __: [19] }), s(m, { span: 8, class: "item-wrap" }, { default: p(() => [g[20] || (g[20] = C("span", { class: "item-title common-class needItem" }, "合同类型", -1)), C("div", yge, [s(f, { class: "el-form-item-18", label: "", prop: "contractType", "label-width": "0" }, { default: p(() => [C("span", null, K(l(E).contractTypeValue || "-"), 1)]), _: 1 })])]), _: 1, __: [20] }), s(m, { span: 8, class: "item-wrap" }, { default: p(() => [g[21] || (g[21] = C("span", { class: "item-title common-class needItem" }, "信息来源", -1)), C("div", Tge, [s(f, { class: "el-form-item-18", label: "", prop: "infoSource", "label-width": "0" }, { default: p(() => [C("span", null, K(l(Cl).VL[l(E).infoSource]), 1)]), _: 1 })])]), _: 1, __: [21] }), s(m, { span: 8, class: "item-wrap" }, { default: p(() => [g[22] || (g[22] = C("span", { class: "item-title common-class" }, "项目经理", -1)), C("div", _ge, [s(f, { class: "el-form-item-18", label: "", prop: "branchCompanyId", "label-width": "0" }, { default: p(() => [C("span", null, K(l(E).projectManager || "-"), 1)]), _: 1 })])]), _: 1, __: [22] }), s(m, { span: 24, class: "item-wrap" }, { default: p(() => [g[23] || (g[23] = C("span", { class: "item-title common-class" }, "销售员是否配合", -1)), C("div", bge, [s(f, { class: "el-form-item-18", label: "", prop: "branchCompanyId", "label-width": "0" }, { default: p(() => [Te(K(l(A)(l(E).boolCoordinate) ? l(E).boolCoordinate ? "是" : "否" : "-"), 1)]), _: 1 })])]), _: 1, __: [23] }), s(m, { span: 24, class: "item-wrap" }, { default: p(() => g[24] || (g[24] = [C("div", { class: "single-class" }, "签订方", -1)])), _: 1, __: [24] }), s(m, { span: 12, class: "item-wrap" }, { default: p(() => [g[25] || (g[25] = C("span", { class: "item-title common-class needItem" }, "甲方", -1)), C("div", Vge, [s(f, { class: "el-form-item-18", label: "", prop: "partyA", "label-width": "0" }, { default: p(() => [C("span", null, K(l(E).partyA || "-"), 1)]), _: 1 })])]), _: 1, __: [25] }), s(m, { span: 12, class: "item-wrap" }, { default: p(() => [g[26] || (g[26] = C("span", { class: "item-title common-class needItem" }, "乙方", -1)), C("div", wge, [s(f, { class: "el-form-item-18", label: "", prop: "partyB", "label-width": "0" }, { default: p(() => [C("span", null, K(l(E).partyB || "-"), 1)]), _: 1 })])]), _: 1, __: [26] }), s(m, { span: 12, class: "item-wrap" }, { default: p(() => [g[27] || (g[27] = C("span", { class: "item-title common-class" }, "丙方", -1)), C("div", Sge, [s(f, { class: "el-form-item-18", label: "", prop: "partyC", "label-width": "0" }, { default: p(() => [C("span", null, K(l(E).partyC || "-"), 1)]), _: 1 })])]), _: 1, __: [27] }), s(m, { span: 12, class: "item-wrap" }, { default: p(() => [g[28] || (g[28] = C("span", { class: "item-title common-class" }, "丁方", -1)), C("div", vge, [s(f, { class: "el-form-item-18", label: "", prop: "partyD", "label-width": "0" }, { default: p(() => [C("span", null, K(l(E).partyD || "-"), 1)]), _: 1 })])]), _: 1, __: [28] }), s(m, { span: 24, class: "item-wrap" }, { default: p(() => g[29] || (g[29] = [C("div", { class: "single-class" }, "主要内容", -1)])), _: 1, __: [29] }), s(m, { span: 8, class: "item-wrap" }, { default: p(() => [g[30] || (g[30] = C("span", { class: "item-title common-class" }, "中标通知书", -1)), C("div", Rge, [s(f, { class: "el-form-item-18", label: "", prop: "boolBidWinningNotice", "label-width": "0" }, { default: p(() => [C("span", null, K(l(A)(l(E).boolBidWinningNotice) ? l(qn).VL[l(E).boolBidWinningNotice] : "-"), 1)]), _: 1 })])]), _: 1, __: [30] }), s(m, { span: 8, class: "item-wrap" }, { default: p(() => [g[31] || (g[31] = C("span", { class: "item-title common-class" }, "图纸", -1)), C("div", Mge, [s(f, { class: "el-form-item-18", label: "", prop: "drawing", "label-width": "0" }, { default: p(() => [C("span", null, K(l(A)(l(E).drawing) ? l(gr).VL[l(E).drawing] : "-"), 1)]), _: 1 })])]), _: 1, __: [31] }), s(m, { span: 8, class: "item-wrap" }, { default: p(() => [g[32] || (g[32] = C("span", { class: "item-title common-class" }, "是否有报价书", -1)), C("div", Age, [s(f, { class: "el-form-item-18", label: "", prop: "boolBidProposals", "label-width": "0" }, { default: p(() => [C("span", null, K(l(A)(l(E).boolBidProposals) ? l(ea).VL[l(E).boolBidProposals] : "-"), 1)]), _: 1 })])]), _: 1, __: [32] }), s(m, { span: 8, class: "item-wrap" }, { default: p(() => [g[33] || (g[33] = C("span", { class: "item-title common-class" }, "是否有招标文件", -1)), C("div", Nge, [s(f, { class: "el-form-item-18", label: "", prop: "boolBidDocument", "label-width": "0" }, { default: p(() => [C("span", null, K(l(A)(l(E).boolBidDocument) ? l(ea).VL[l(E).boolBidDocument] : "-"), 1)]), _: 1 })])]), _: 1, __: [33] }), s(m, { span: 8, class: "item-wrap" }, { default: p(() => [g[34] || (g[34] = C("span", { class: "item-title common-class" }, "承包性质", -1)), C("div", Lge, [s(f, { class: "el-form-item-18", label: "", prop: "contractualNature", "label-width": "0" }, { default: p(() => [C("span", null, K(l(E).contractualNatureValue || "-"), 1)]), _: 1 })])]), _: 1, __: [34] }), s(m, { span: 8, class: "item-wrap" }, { default: p(() => [g[35] || (g[35] = C("span", { class: "item-title common-class" }, "招标方式", -1)), C("div", Ige, [s(f, { class: "el-form-item-18", label: "", prop: "biddingMethod", "label-width": "0" }, { default: p(() => [C("span", null, K(l(E).biddingMethodValue || "-"), 1)]), _: 1 })])]), _: 1, __: [35] }), s(m, { span: 8, class: "item-wrap" }, { default: p(() => [g[36] || (g[36] = C("span", { class: "item-title common-class" }, "甲方类别", -1)), C("div", Cge, [s(f, { class: "el-form-item-18", label: "", prop: "partyType", "label-width": "0" }, { default: p(() => [C("span", null, K(l(E).partyTypeValue || "-"), 1)]), _: 1 })])]), _: 1, __: [36] }), s(m, { span: 8, class: "item-wrap" }, { default: p(() => [g[37] || (g[37] = C("span", { class: "item-title common-class" }, "是否装配式建筑", -1)), C("div", Pge, [s(f, { class: "el-form-item-18", label: "", prop: "boolFabricatedStructure", "label-width": "0" }, { default: p(() => [C("span", null, K(l(A)(l(E).boolFabricatedStructure) ? l(ea).VL[l(E).boolFabricatedStructure] : "-"), 1)]), _: 1 })])]), _: 1, __: [37] }), s(m, { span: 8, class: "item-wrap" }, { default: p(() => [g[38] || (g[38] = C("span", { class: "item-title common-class" }, "是否示范合同", -1)), C("div", Oge, [s(f, { class: "el-form-item-18", label: "", prop: "boolModelContract", "label-width": "0" }, { default: p(() => [C("span", null, K(l(A)(l(E).boolModelContract) ? l(ea).VL[l(E).boolModelContract] : "-"), 1)]), _: 1 })])]), _: 1, __: [38] }), s(m, { span: 8, class: "item-wrap" }, { default: p(() => [g[39] || (g[39] = C("span", { class: "item-title common-class" }, "工程所在地", -1)), C("div", kge, [s(f, { class: "el-form-item-18", label: "", prop: "region", "label-width": "0" }, { default: p(() => [C("span", null, K(l(E).address), 1)]), _: 1 })])]), _: 1, __: [39] }), s(m, { span: 8, class: "item-wrap" }, { default: p(() => [g[40] || (g[40] = C("span", { class: "item-title common-class" }, "区域", -1)), C("div", Dge, [s(f, { class: "el-form-item-18", label: "", prop: "locationValue", "label-width": "0" }, { default: p(() => [C("span", null, K(l(E).locationValue), 1)]), _: 1 })])]), _: 1, __: [40] }), s(m, { span: 8, class: "item-wrap" }, { default: p(() => [g[41] || (g[41] = C("span", { class: "item-title common-class" }, "结构类型", -1)), C("div", xge, [s(f, { class: "el-form-item-18", label: "", prop: "structureType", "label-width": "0" }, { default: p(() => [C("span", null, K(l(E).structureTypeValue || "-"), 1)]), _: 1 })])]), _: 1, __: [41] }), s(m, { span: 8, class: "item-wrap" }, { default: p(() => [g[42] || (g[42] = C("span", { class: "item-title common-class" }, "建筑面积（平方米）", -1)), C("div", Uge, [s(f, { class: "el-form-item-18", label: "", prop: "structureArea", "label-width": "0" }, { default: p(() => [C("span", null, K(l(E).structureArea || "-"), 1)]), _: 1 })])]), _: 1, __: [42] }), s(m, { span: 8, class: "item-wrap" }, { default: p(() => [g[43] || (g[43] = C("span", { class: "item-title common-class needItem" }, "主结构用钢量(吨)", -1)), C("div", Yge, [s(f, { class: "el-form-item-18", label: "", prop: "mainStructureSteelMete", "label-width": "0" }, { default: p(() => [C("span", null, K(l(E).mainStructureSteelMete || "-"), 1)]), _: 1 })])]), _: 1, __: [43] }), s(m, { span: 8, class: "item-wrap" }, { default: p(() => [g[44] || (g[44] = C("span", { class: "item-title common-class" }, "次结构用钢量(吨)", -1)), C("div", Kge, [s(f, { class: "el-form-item-18", label: "", prop: "subfabricSteelMete", "label-width": "0" }, { default: p(() => [C("span", null, K(l(E).subfabricSteelMete || "-"), 1)]), _: 1 })])]), _: 1, __: [44] }), s(m, { span: 8, class: "item-wrap" }, { default: p(() => [g[45] || (g[45] = C("span", { class: "item-title common-class" }, "最大跨度/高度", -1)), C("div", Wge, [s(f, { class: "el-form-item-18", label: "", prop: "maximumSpan", "label-width": "0" }, { default: p(() => [C("span", null, K(l(E).maximumSpan || "-"), 1)]), _: 1 })])]), _: 1, __: [45] }), s(m, { span: 8, class: "item-wrap" }, { default: p(() => [g[46] || (g[46] = C("span", { class: "item-title common-class needItem" }, "开竣工日期", -1)), C("div", jge, [s(f, { class: "el-form-item-18", label: "", prop: "branchCompanyId", "label-width": "0" }, { default: p(() => [C("span", null, K(l(E).contractDate || "-"), 1)]), _: 1 })])]), _: 1, __: [46] }), s(m, { span: 8, class: "item-wrap" }, { default: p(() => [g[47] || (g[47] = C("span", { class: "item-title common-class" }, "总工期（天）", -1)), C("div", Fge, [s(f, { class: "el-form-item-18", label: "", prop: "", "label-width": "0" }, { default: p(() => [C("span", null, K(l(E).allDays || "-"), 1)]), _: 1 })])]), _: 1, __: [47] }), s(m, { span: 8, class: "item-wrap" }, { default: p(() => [g[48] || (g[48] = C("span", { class: "item-title common-class" }, "预付款比例", -1)), C("div", zge, [s(f, { class: "el-form-item-18", label: "", prop: "prepaymentRatio", "label-width": "0" }, { default: p(() => [C("span", null, K(l(E).prepaymentRatio || "-"), 1)]), _: 1 })])]), _: 1, __: [48] }), s(m, { span: 8, class: "item-wrap" }, { default: p(() => [g[49] || (g[49] = C("span", { class: "item-title common-class" }, "质保金比例(%)", -1)), C("div", Bge, [s(f, { class: "el-form-item-18", label: "", prop: "warrantyRatio", "label-width": "0" }, { default: p(() => [C("span", null, K(l(E).warrantyRatio || "-"), 1)]), _: 1 })])]), _: 1, __: [49] }), s(m, { span: 8, class: "item-wrap" }, { default: p(() => [g[50] || (g[50] = C("span", { class: "item-title common-class" }, "农民工工资专户", -1)), C("div", Hge, [s(f, { class: "el-form-item-18", label: "", prop: "boolPeasantWorkerWageAccount", "label-width": "0" }, { default: p(() => [C("span", null, K(l(A)(l(E).boolPeasantWorkerWageAccount) ? l(ea).VL[l(E).boolPeasantWorkerWageAccount] : "-"), 1)]), _: 1 })])]), _: 1, __: [50] }), s(m, { span: 8, class: "item-wrap" }, { default: p(() => [g[51] || (g[51] = C("span", { class: "item-title common-class" }, "农民工工资专户比例", -1)), C("div", qge, [s(f, { class: "el-form-item-18", label: "", prop: "peasantWorkerWageRatio", "label-width": "0" }, { default: p(() => [C("span", null, K(l(E).peasantWorkerWageRatio || "-"), 1)]), _: 1 })])]), _: 1, __: [51] }), s(m, { span: 8, class: "item-wrap" }, { default: p(() => [g[52] || (g[52] = C("span", { class: "item-title common-class" }, "进度款", -1)), C("div", Gge, [s(f, { class: "el-form-item-18", label: "", prop: "progressPayment", "label-width": "0" }, { default: p(() => [C("span", null, K(l(E).progressPayment || "-"), 1)]), _: 1 })])]), _: 1, __: [52] }), s(m, { span: 8, class: "item-wrap" }, { default: p(() => [g[53] || (g[53] = C("span", { class: "item-title common-class" }, "材料调差", -1)), C("div", Qge, [s(f, { class: "el-form-item-18", label: "", prop: "materialInspection", "label-width": "0" }, { default: p(() => [C("span", null, K(l(E).materialInspection || "-"), 1)]), _: 1 })])]), _: 1, __: [53] }), s(m, { span: 8, class: "item-wrap" }, { default: p(() => [g[54] || (g[54] = C("span", { class: "item-title common-class" }, "说明", -1)), C("div", Zge, [s(f, { class: "el-form-item-18", label: "", prop: "remark", "label-width": "0" }, { default: p(() => [C("span", null, K(l(E).remark || "-"), 1)]), _: 1 })])]), _: 1, __: [54] }), s(m, { span: 16, class: "item-wrap" }, { default: p(() => [g[55] || (g[55] = C("span", { class: "item-title common-class" }, "合同附件", -1)), C("div", Jge, [s(f, { class: "el-form-item-18", label: "", prop: "branchCompanyId", "label-width": "0" }, { default: p(() => [s(dl, { files: l(E).attachmentList, "onUpdate:files": g[2] || (g[2] = (O) => l(E).attachmentList = O), showView: true, class: "el-form-item-15", "empty-text": "暂未上传合同附件", "show-download": "", uploadable: false }, null, 8, ["files"])]), _: 1 })])]), _: 1, __: [55] })]), _: 1 })]), _: 1 }, 512)) : H("", true), n.ApprovalFlag ? (w(), U(N, { key: 1, modelValue: b.value, "onUpdate:modelValue": g[3] || (g[3] = (O) => b.value = O), rows: 2, class: "approval-comments", maxlength: "1000", placeholder: "审核意见", "show-word-limit": "", style: { "margin-top": "5px" }, type: "textarea" }, null, 8, ["modelValue"])) : H("", true)]), _: 2 }, [l(A)(l(E)) ? { name: "titleAfter", fn: p(() => [l(E).wmsApproveRecordFlowDTO ? (w(), U(h, { key: 0, placement: "bottom-start", width: 400, trigger: "hover" }, { reference: p(() => [s(S, { style: { width: "180px" } }, { default: p(() => g[4] || (g[4] = [Te("查看审批记录")])), _: 1, __: [4] })]), default: p(() => [s(tl, { data: l(E).wmsApproveRecordFlowDTO || [] }, null, 8, ["data"])]), _: 1 })) : H("", true), l(E).contractNumber ? (w(), U(T, { key: 1 }, { default: p(() => [Te("合同编号：" + K(l(E).contractNumber), 1)]), _: 1 })) : H("", true)]), key: "0" } : void 0]), 1032, ["before-close", "visible"]);
  };
} }, Z8 = ut(Xge, [["__scopeId", "data-v-38de6944"]]), $ge = Object.freeze(Object.defineProperty({ __proto__: null, default: Z8 }, Symbol.toStringTag, { value: "Module" }));
const e1e = { class: "common-class item-content" }, t1e = { class: "common-class item-content" }, i1e = { class: "common-class item-content" }, a1e = { class: "common-class item-content" }, l1e = { class: "common-class item-content" }, o1e = { class: "common-class item-content" }, n1e = { class: "common-class item-content" }, s1e = { class: "common-class item-content" }, r1e = { class: "common-class item-content" }, u1e = { class: "common-class item-content" }, c1e = { class: "common-class item-content" }, d1e = { class: "common-class item-content" }, m1e = { class: "common-class item-content" }, p1e = { class: "common-class item-content" }, h1e = { class: "common-class item-content" }, f1e = { class: "common-class item-content" }, g1e = { class: "common-class item-content" }, E1e = { key: 0 }, y1e = { key: 1 }, T1e = { class: "common-class item-content" }, _1e = { class: "common-class item-content" }, b1e = { class: "common-class item-content" }, V1e = { class: "common-class item-content" }, w1e = { class: "common-class item-content" }, S1e = { class: "common-class item-content" }, v1e = { class: "common-class item-content" }, R1e = { class: "common-class item-content" }, M1e = { class: "common-class item-content" }, A1e = { class: "common-class item-content" }, N1e = { class: "common-class item-content" }, L1e = { class: "common-class item-content" }, I1e = { class: "common-class item-content" }, C1e = { class: "common-class item-content" }, P1e = { class: "common-class item-content" }, O1e = { class: "common-class item-content" }, k1e = { class: "common-class item-content" }, D1e = { class: "common-class item-content" }, x1e = { class: "common-class item-content" }, U1e = { class: "common-class item-content" }, Y1e = { class: "common-class item-content" }, K1e = { class: "common-class item-content" }, W1e = { class: "common-class item-content" }, j1e = { class: "common-class item-content" }, F1e = { class: "common-class item-content" }, z1e = { class: "common-class item-content" }, B1e = { class: "common-class item-content" }, H1e = { class: "common-class item-content" }, q1e = { class: "common-class item-content" }, G1e = { class: "common-class item-content" }, Q1e = { __name: "form", setup(e) {
  const { loaded: o, catalogContentConfig: n } = g2(), { user: c } = ka(["user"]), u = Z(), r = Z(false), E = { title: void 0, boolBindingPreRegistration: void 0, preRegistrationId: void 0, applicantId: void 0, applicantName: void 0, deptId: void 0, applicationDate: void 0, projectName: void 0, signerId: void 0, signerName: void 0, firstLevelDept: void 0, secondLevelDept: void 0, contractAmount: void 0, taxRate: void 0, contractType: void 0, infoSource: void 0, projectManager: void 0, boolCoordinate: void 0, partyA: void 0, partyB: void 0, partyC: void 0, partyD: void 0, boolBidWinningNotice: void 0, drawing: void 0, boolBidProposals: void 0, boolBidDocument: void 0, contractualNature: void 0, biddingMethod: void 0, partyType: void 0, boolFabricatedStructure: void 0, boolModelContract: void 0, locationId: void 0, countryId: void 0, provinceId: void 0, cityId: void 0, regionId: void 0, structureType: void 0, structureArea: void 0, mainStructureSteelMete: void 0, subfabricSteelMete: void 0, maximumSpan: void 0, contractStartDate: void 0, contractEndDate: void 0, allDays: void 0, prepaymentRatio: void 0, warrantyRatio: void 0, boolPeasantWorkerWageAccount: void 0, peasantWorkerWageRatio: void 0, progressPayment: void 0, materialInspection: void 0, attachments: void 0, remark: void 0, dateTime: [] }, y = Z(), b = Z(), V = Z([]), { CRUD: M, crud: g, form: S } = An(E, u), h = Ee(() => {
    var x;
    return S.firstLevelDept ? ((x = n.value) == null ? void 0 : x[Ja.SECOND_LEVEL_DEPT.V].filter((I) => I.parentId === S.firstLevelDept)) || [] : [];
  }), T = (x, I, Y) => {
    I || Y(new Error("必须大于0")), Y();
  }, f = { boolBindingPreRegistration: [{ required: true, message: "请选择是否引用合同预登记", trigger: "change" }], title: [{ required: true, message: "请输入标题", trigger: "blur" }], projectName: [{ required: true, message: "项目名称", trigger: "blur" }], signDate: [{ required: true, message: "请选择签订日期", trigger: "change" }], signerId: [{ required: true, message: "请选择签订人", trigger: "change" }], firstLevelDept: [{ required: true, message: "请选择所属一级部门", trigger: "change" }], secondLevelDept: [{ validator: (x, I, Y) => {
    A(h.value) && !I && Y(new Error("请选择所属二级部门")), Y();
  }, message: "请选择所属二级部门", trigger: "change" }], contractAmount: [{ required: true, validator: T, message: "请填写合同金额", trigger: "blur" }], taxRate: [{ required: true, validator: T, trigger: "blur" }], contractType: [{ required: true, message: "请选择合同类型", trigger: "change" }], infoSource: [{ required: true, message: "请选择信息来源", trigger: "change" }], partyA: [{ required: true, message: "请填写甲方", trigger: "blur" }], partyB: [{ required: true, message: "请填写乙方", trigger: "blur" }], mainStructureSteelMete: [{ required: true, validator: T, message: "请填写主结构用钢量(吨)", trigger: "blur" }], dateTime: [{ required: true, message: "请选择开竣工时间", trigger: "change" }] };
  m();
  async function m() {
    V.value = [];
    try {
      const x = await The();
      x == null || x.forEach((I) => {
        I.label = I.contractNumber + " " + I.projectName;
      }), V.value = x;
    } catch {
      console.log("获取未引用预登记合同");
    }
  }
  function R() {
    S.region = [], S.contractCatalogueId = void 0, S.biddingMethod = void 0, S.boolCoordinate = void 0, S.boolFabricatedStructure = void 0, S.boolModelContract = void 0, S.cityId = void 0, S.contractAmount = void 0, S.contractEndDate = void 0, S.contractNumber = void 0, S.contractStartDate = void 0, S.contractType = void 0, S.contractualNature = void 0, S.countryId = void 0, S.firstLevelDept = void 0, S.infoSource = void 0, S.locationId = void 0, S.locationValue = void 0, S.mainStructureSteelMete = void 0, S.maximumSpan = void 0, S.partyA = void 0, S.partyType = void 0, S.projectManager = void 0, S.projectName = void 0, S.provinceId = void 0, S.regionId = void 0, S.remark = void 0, S.secondLevelDept = void 0, S.signDate = void 0, S.signerId = void 0, S.structureArea = void 0, S.structureType = void 0, S.subfabricSteelMete = void 0, S.allDays = void 0;
  }
  function v() {
    S.preRegistrationId = void 0, R(), !S.boolBindingPreRegistration && A(V.value) && ot({ message: "尊敬的用户，当前存在您之前创建过但还未被引用的预登记合同，请确认！", type: "warning", duration: "5000" });
  }
  function N() {
    var x, I, Y, ee, B, q, ae, j, le, oe, ye, ce, se, he, be, me, ge, Le, Ie, Se, X, $, k, J, z, F, G, ie, ue, ne, te, de, pe, re, we, Ke, Me, Ne, He, ze, Oe, Re, fe;
    if (S.preRegistrationId && ((x = V.value) == null ? void 0 : x.findIndex((Ue) => Ue.id === S.preRegistrationId)) > -1) {
      const Ue = V.value.find((Xe) => Xe.id === S.preRegistrationId);
      S.region = [], S.dateTime = [], S.contractCatalogueId = (I = Ue.contractCatalogueDTO) == null ? void 0 : I.id, S.biddingMethod = (Y = Ue.contractCatalogueDTO) == null ? void 0 : Y.biddingMethod, S.boolFabricatedStructure = (ee = Ue.contractCatalogueDTO) == null ? void 0 : ee.boolFabricatedStructure, S.boolModelContract = (B = Ue.contractCatalogueDTO) == null ? void 0 : B.boolModelContract, S.cityId = (q = Ue.contractCatalogueDTO) == null ? void 0 : q.cityId, S.contractAmount = (ae = Ue.contractCatalogueDTO) == null ? void 0 : ae.contractAmount, S.contractEndDate = (j = Ue.contractCatalogueDTO) == null ? void 0 : j.contractEndDate, S.contractNumber = (le = Ue.contractCatalogueDTO) == null ? void 0 : le.contractNumber, S.contractStartDate = (oe = Ue.contractCatalogueDTO) == null ? void 0 : oe.contractStartDate, S.contractType = (ye = Ue.contractCatalogueDTO) == null ? void 0 : ye.contractType, S.contractualNature = (ce = Ue.contractCatalogueDTO) == null ? void 0 : ce.contractualNature, S.countryId = (se = Ue.contractCatalogueDTO) == null ? void 0 : se.countryId, S.firstLevelDept = (he = Ue.contractCatalogueDTO) == null ? void 0 : he.firstLevelDept, S.infoSource = (be = Ue.contractCatalogueDTO) == null ? void 0 : be.infoSource, S.locationId = (me = Ue.contractCatalogueDTO) == null ? void 0 : me.locationId, S.locationValue = (ge = Ue.contractCatalogueDTO) == null ? void 0 : ge.locationValue, S.mainStructureSteelMete = (Le = Ue.contractCatalogueDTO) == null ? void 0 : Le.mainStructureSteelMete, S.maximumSpan = (Ie = Ue.contractCatalogueDTO) == null ? void 0 : Ie.maximumSpan, S.partyA = (Se = Ue.contractCatalogueDTO) == null ? void 0 : Se.partyA, S.partyType = (X = Ue.contractCatalogueDTO) == null ? void 0 : X.partyType, S.projectManager = ($ = Ue.contractCatalogueDTO) == null ? void 0 : $.projectManager, S.projectName = (k = Ue.contractCatalogueDTO) == null ? void 0 : k.projectName, S.provinceId = (J = Ue.contractCatalogueDTO) == null ? void 0 : J.provinceId, S.regionId = (z = Ue.contractCatalogueDTO) == null ? void 0 : z.regionId, S.remark = (F = Ue.contractCatalogueDTO) == null ? void 0 : F.remark, S.secondLevelDept = (G = Ue.contractCatalogueDTO) == null ? void 0 : G.secondLevelDept, S.signDate = (ie = Ue.contractCatalogueDTO) == null ? void 0 : ie.signDate, S.signerId = (ue = Ue.contractCatalogueDTO) == null ? void 0 : ue.signerId, S.structureArea = (ne = Ue.contractCatalogueDTO) == null ? void 0 : ne.structureArea, S.structureType = (te = Ue.contractCatalogueDTO) == null ? void 0 : te.structureType, S.subfabricSteelMete = (de = Ue.contractCatalogueDTO) == null ? void 0 : de.subfabricSteelMete, (pe = Ue.contractCatalogueDTO) != null && pe.countryId && S.region.push((re = Ue.contractCatalogueDTO) == null ? void 0 : re.countryId), (we = Ue.contractCatalogueDTO) != null && we.provinceId && S.region.push((Ke = Ue.contractCatalogueDTO) == null ? void 0 : Ke.provinceId), (Me = Ue.contractCatalogueDTO) != null && Me.cityId && S.region.push((Ne = Ue.contractCatalogueDTO) == null ? void 0 : Ne.cityId), (He = Ue.contractCatalogueDTO) != null && He.regionId && S.region.push((ze = Ue.contractCatalogueDTO) == null ? void 0 : ze.regionId), S.contractStartDate && S.contractEndDate && (S.dateTime.push(S.contractStartDate, S.contractEndDate), S.allDays = sr(S.contractStartDate, S.contractEndDate)), P(), S.attachmentList = (Oe = Ue.contractCatalogueDTO) == null ? void 0 : Oe.attachmentList;
      const Je = ((fe = (Re = Ue.contractCatalogueDTO) == null ? void 0 : Re.attachmentList) == null ? void 0 : fe.map((Xe) => Xe.id)) || [];
      S.attachments = A(Je) ? Je.join(",") : S.attachments;
    } else R();
  }
  function P() {
    S.infoSource === Cl.MANAGER_SELLER.V || S.infoSource === Cl.NEW_MANAGER.V ? S.boolCoordinate = true : S.boolCoordinate = false;
  }
  function L() {
    A(S.dateTime) ? (S.contractStartDate = S.dateTime[0], S.contractEndDate = S.dateTime[1], S.allDays = sr(S.contractStartDate, S.contractEndDate)) : (S.contractStartDate = void 0, S.contractEndDate = void 0);
  }
  function O(x) {
    S.countryId = void 0, S.provinceId = void 0, S.cityId = void 0, S.regionId = void 0, x && x.forEach((I, Y) => {
      Y === 0 && (S.countryId = I), Y === 1 && (S.provinceId = I), Y === 2 && (S.cityId = I), Y === 3 && (S.regionId = I);
    }), pt(() => {
      var Y;
      const I = (Y = b.value) == null ? void 0 : Y.getNodeInfo();
      S.locationId = I == null ? void 0 : I.locationId, S.locationValue = I == null ? void 0 : I.locationName;
    });
  }
  return Ce(() => g == null ? void 0 : g.submitResult, () => {
    var x;
    ((x = g == null ? void 0 : g.submitResult) == null ? void 0 : x.code) === 40206 && (S.preRegistrationId = void 0, m());
  }, { deep: true }), M.HOOK.beforeToAdd = () => {
    var x, I, Y, ee;
    S.applicantId = S.applicantId || ((x = c.value) == null ? void 0 : x.id), S.applicantName = S.applicantName || ((I = c.value) == null ? void 0 : I.name), S.deptId = S.deptId || ((Y = c.value) == null ? void 0 : Y.deptId), S.deptName = S.deptName || ((ee = c.value) == null ? void 0 : ee.dept), S.applicationDate = S.applicationDate || (/* @__PURE__ */ new Date()).getTime();
  }, M.HOOK.beforeSubmit = async () => {
    var I, Y;
    g.form.boolSupplement = false;
    const x = ((I = g.form.attachmentList) == null ? void 0 : I.map((ee) => ee.id)) || [];
    g.form.attachments = A(x) ? x.join(",") : g.form.attachments, g.form.signerName = (Y = y == null ? void 0 : y.value.getNodeInfo()) == null ? void 0 : Y.label, g.status.edit > 0 && (g.crudApi.edit = vhe.edit);
  }, M.HOOK.beforeEditDetailLoaded = async (x) => {
    const I = [], Y = [];
    r.value = true, S.countryId && I.push(S.countryId), S.provinceId && I.push(S.provinceId), S.cityId && I.push(S.cityId), S.regionId && I.push(S.regionId), S.contractStartDate && S.contractEndDate && Y.push(S.contractStartDate, S.contractEndDate), S.region = I, S.dateTime = Y, S.boolBindingPreRegistration = !!S.preRegistrationId, S.infoSource === Cl.MANAGER_SELLER.V || S.infoSource === Cl.NEW_MANAGER.V ? S.boolCoordinate = true : S.boolCoordinate = false, setTimeout(() => {
      r.value = false;
    });
  }, (x, I) => {
    const Y = Ve("common-button"), ee = Ve("common-select"), B = Zi, q = Bn, ae = Mt, j = Rl, le = Ve("common-select-v2"), oe = Ve("common-input-number"), ye = Hn, ce = Li, se = Ve("common-drawer");
    return w(), U(se, { "append-to-body": "", "close-on-click-modal": false, "before-close": l(g).cancelCU, visible: l(g).status.cu > 0, title: "合同评审登记申请", "wrapper-closable": false, size: "80%" }, { titleRight: p(() => [s(Y, { loading: l(g).status.cu === 2, type: "primary", size: "default", onClick: l(g).submitCU }, { default: p(() => I[41] || (I[41] = [Te("提交")])), _: 1, __: [41] }, 8, ["loading", "onClick"])]), content: p(() => [s(ce, { ref_key: "formRef", ref: u, model: l(S), rules: f, size: "default", "label-width": "120px", "label-position": "right" }, { default: p(() => [s(ye, { style: { border: "1px solid #ebeef5", "margin-bottom": "10px" } }, { default: p(() => [s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[42] || (I[42] = C("span", { class: "item-title common-class needItem" }, "合同预登记", -1)), C("div", e1e, [s(B, { class: "el-form-item-18", label: "", prop: "boolBindingPreRegistration", "label-width": "0" }, { default: p(() => [s(ee, { modelValue: l(S).boolBindingPreRegistration, "onUpdate:modelValue": I[0] || (I[0] = (he) => l(S).boolBindingPreRegistration = he), options: l(ea).ENUM, type: "enum", size: "default", clearable: "", style: { width: "100%" }, class: "input-underline", placeholder: "请选择", onChange: v }, null, 8, ["modelValue", "options"])]), _: 1 })])]), _: 1, __: [42] }), s(q, { span: 16, class: "item-wrap" }, { default: p(() => [I[43] || (I[43] = C("span", { class: "item-title common-class needItem" }, "标题", -1)), C("div", t1e, [s(B, { class: "el-form-item-18", label: "", prop: "title", "label-width": "0" }, { default: p(() => [s(ae, { modelValue: l(S).title, "onUpdate:modelValue": I[1] || (I[1] = (he) => l(S).title = he), modelModifiers: { trim: true }, type: "text", placeholder: "标题", class: "input-underline", maxlength: "60" }, null, 8, ["modelValue"])]), _: 1 })])]), _: 1, __: [43] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[44] || (I[44] = C("span", { class: "item-title common-class" }, "申请人", -1)), C("div", i1e, [s(B, { class: "el-form-item-18", label: "", prop: "branchCompanyId", "label-width": "0" }, { default: p(() => [Te(K(l(S).applicantName), 1)]), _: 1 })])]), _: 1, __: [44] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[45] || (I[45] = C("span", { class: "item-title common-class" }, "申请人部门", -1)), C("div", a1e, [s(B, { class: "el-form-item-18", label: "", prop: "branchCompanyId", "label-width": "0" }, { default: p(() => [Te(K(l(S).deptName), 1)]), _: 1 })])]), _: 1, __: [45] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[47] || (I[47] = C("span", { class: "item-title common-class" }, "申请编号", -1)), C("div", l1e, [s(B, { class: "el-form-item-18", label: "", prop: "", "label-width": "0" }, { default: p(() => I[46] || (I[46] = [C("span", null, "-", -1)])), _: 1, __: [46] })])]), _: 1, __: [47] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[48] || (I[48] = C("span", { class: "item-title common-class needItem" }, "申请时间", -1)), C("div", o1e, [s(B, { class: "el-form-item-18", label: "", prop: "branchCompanyId", "label-width": "0" }, { default: p(() => [s(j, { modelValue: l(S).applicationDate, "onUpdate:modelValue": I[2] || (I[2] = (he) => l(S).applicationDate = he), type: "date", size: "default", class: "input-underline", "value-format": "x", style: { width: "100%" }, disabled: "" }, null, 8, ["modelValue"])]), _: 1 })])]), _: 1, __: [48] }), s(q, { span: 16, class: "item-wrap" }, { default: p(() => [I[49] || (I[49] = C("span", { class: "item-title common-class needItem" }, "项目名称", -1)), C("div", n1e, [s(B, { class: "el-form-item-18", label: "", prop: "projectName", "label-width": "0" }, { default: p(() => [l(S).boolBindingPreRegistration === l(ea).TRUE.V ? (w(), U(le, { key: 0, modelValue: l(S).preRegistrationId, "onUpdate:modelValue": I[3] || (I[3] = (he) => l(S).preRegistrationId = he), options: V.value, dataStructure: { key: "id", label: "label", value: "id" }, disabled: !l(o), clearable: "", filterable: "", class: "input-underline", placeholder: "请选择项目", style: { width: "100%" }, onChange: N }, null, 8, ["modelValue", "options", "disabled"])) : (w(), U(ae, { key: 1, modelValue: l(S).projectName, "onUpdate:modelValue": I[4] || (I[4] = (he) => l(S).projectName = he), modelModifiers: { trim: true }, type: "text", placeholder: "项目名称", class: "input-underline", maxlength: "60" }, null, 8, ["modelValue"]))]), _: 1 })])]), _: 1, __: [49] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[50] || (I[50] = C("span", { class: "item-title common-class needItem" }, "签订人", -1)), C("div", s1e, [s(B, { class: "el-form-item-18", label: "", prop: "signerId", "label-width": "0" }, { default: p(() => [s(Ds, { ref_key: "userDeptRef", ref: y, modelValue: l(S).signerId, "onUpdate:modelValue": I[5] || (I[5] = (he) => l(S).signerId = he), "collapse-tags": false, nofilterBlankDept: "", class: "input-underline", clearable: "", filterable: "", placeholder: "签订人", style: { width: "200px" } }, null, 8, ["modelValue"])]), _: 1 })])]), _: 1, __: [50] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[51] || (I[51] = C("span", { class: "item-title common-class needItem" }, "所属一级部门", -1)), C("div", r1e, [s(B, { class: "el-form-item-18", label: "", prop: "firstLevelDept", "label-width": "0" }, { default: p(() => [s(ee, { modelValue: l(S).firstLevelDept, "onUpdate:modelValue": I[6] || (I[6] = (he) => l(S).firstLevelDept = he), options: l(n)[l(Ja).FIRST_LEVEL_DEPT.V], dataStructure: { key: "id", label: "fieldValue", value: "id" }, disabled: !l(o), clearable: "", class: "input-underline", placeholder: "请选择所属一级部门", style: { width: "100%" } }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 })])]), _: 1, __: [51] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [C("span", { class: Zt(l(A)(h.value) ? "item-title common-class needItem" : "item-title common-class") }, "所属二级部门", 2), C("div", u1e, [s(B, { class: "el-form-item-18", label: "", prop: "secondLevelDept", "label-width": "0" }, { default: p(() => [s(ee, { modelValue: l(S).secondLevelDept, "onUpdate:modelValue": I[7] || (I[7] = (he) => l(S).secondLevelDept = he), options: h.value, dataStructure: { key: "id", label: "fieldValue", value: "id" }, disabled: !l(o) || !l(S).firstLevelDept, clearable: "", class: "input-underline", placeholder: "请选择所属二级部门", style: { width: "100%" } }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 })])]), _: 1 }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[52] || (I[52] = C("span", { class: "item-title common-class needItem" }, "合同金额（元）", -1)), C("div", c1e, [s(B, { class: "el-form-item-18", label: "", prop: "contractAmount", "label-width": "0" }, { default: p(() => [s(oe, { modelValue: l(S).contractAmount, "onUpdate:modelValue": I[8] || (I[8] = (he) => l(S).contractAmount = he), controls: false, max: 999999999999, min: 0, precision: l(Ze).YUAN, step: 1, autocomplete: "off", class: "input-underline", placeholder: "请填写合同金额", style: { width: "100%" } }, null, 8, ["modelValue", "precision"])]), _: 1 })])]), _: 1, __: [52] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[53] || (I[53] = C("span", { class: "item-title common-class" }, "合同金额大写", -1)), C("div", d1e, [s(B, { class: "el-form-item-18", label: "", prop: "", "label-width": "0" }, { default: p(() => [Te(K(l(S).contractAmount ? l(iu)(l(S).contractAmount) : "-"), 1)]), _: 1 })])]), _: 1, __: [53] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[54] || (I[54] = C("span", { class: "item-title common-class needItem" }, "税率（%）", -1)), C("div", m1e, [s(B, { class: "el-form-item-18", label: "", prop: "taxRate", "label-width": "0" }, { default: p(() => [s(oe, { modelValue: l(S).taxRate, "onUpdate:modelValue": I[9] || (I[9] = (he) => l(S).taxRate = he), controls: false, max: 100, min: 0, precision: 0, step: 1, autocomplete: "off", class: "input-underline", placeholder: "税率", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 })])]), _: 1, __: [54] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[55] || (I[55] = C("span", { class: "item-title common-class needItem" }, "合同类型", -1)), C("div", p1e, [s(B, { class: "el-form-item-18", label: "", prop: "contractType", "label-width": "0" }, { default: p(() => [s(ee, { modelValue: l(S).contractType, "onUpdate:modelValue": I[10] || (I[10] = (he) => l(S).contractType = he), options: l(n)[l(Ja).CONTRACT_TYPE.V], dataStructure: { key: "id", label: "fieldValue", value: "id" }, disabled: !l(o), clearable: "", class: "input-underline", placeholder: "请选择合同类型", style: { width: "100%" } }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 })])]), _: 1, __: [55] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[56] || (I[56] = C("span", { class: "item-title common-class needItem" }, "信息来源", -1)), C("div", h1e, [s(B, { class: "el-form-item-18", label: "", prop: "infoSource", "label-width": "0" }, { default: p(() => [s(ee, { modelValue: l(S).infoSource, "onUpdate:modelValue": I[11] || (I[11] = (he) => l(S).infoSource = he), options: l(Cl).ENUM, type: "enum", size: "default", clearable: "", disabled: !l(o), style: { width: "100%" }, class: "input-underline", placeholder: "请选择信息来源", onChange: P }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 })])]), _: 1, __: [56] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[57] || (I[57] = C("span", { class: "item-title common-class" }, "项目经理", -1)), C("div", f1e, [s(B, { class: "el-form-item-18", label: "", prop: "projectManager", "label-width": "0" }, { default: p(() => [s(ae, { modelValue: l(S).projectManager, "onUpdate:modelValue": I[12] || (I[12] = (he) => l(S).projectManager = he), modelModifiers: { trim: true }, type: "text", placeholder: "项目经理", class: "input-underline", maxlength: "60" }, null, 8, ["modelValue"])]), _: 1 })])]), _: 1, __: [57] }), s(q, { span: 24, class: "item-wrap" }, { default: p(() => [I[58] || (I[58] = C("span", { class: "item-title common-class" }, "销售员是否配合", -1)), C("div", g1e, [s(B, { class: "el-form-item-18", label: "", prop: "branchCompanyId", "label-width": "0" }, { default: p(() => [l(S).infoSource ? (w(), Q("span", E1e, K(l(A)(l(S).boolCoordinate) ? l(S).boolCoordinate ? "是" : "否" : "-"), 1)) : (w(), Q("span", y1e, "-"))]), _: 1 })])]), _: 1, __: [58] }), s(q, { span: 24, class: "item-wrap" }, { default: p(() => I[59] || (I[59] = [C("div", { class: "single-class" }, "签订方", -1)])), _: 1, __: [59] }), s(q, { span: 12, class: "item-wrap" }, { default: p(() => [I[60] || (I[60] = C("span", { class: "item-title common-class needItem" }, "甲方", -1)), C("div", T1e, [s(B, { class: "el-form-item-18", label: "", prop: "partyA", "label-width": "0" }, { default: p(() => [s(ae, { modelValue: l(S).partyA, "onUpdate:modelValue": I[13] || (I[13] = (he) => l(S).partyA = he), modelModifiers: { trim: true }, type: "text", placeholder: "甲方", class: "input-underline", maxlength: "60" }, null, 8, ["modelValue"])]), _: 1 })])]), _: 1, __: [60] }), s(q, { span: 12, class: "item-wrap" }, { default: p(() => [I[61] || (I[61] = C("span", { class: "item-title common-class needItem" }, "乙方", -1)), C("div", _1e, [s(B, { class: "el-form-item-18", label: "", prop: "partyB", "label-width": "0" }, { default: p(() => [s(ae, { modelValue: l(S).partyB, "onUpdate:modelValue": I[14] || (I[14] = (he) => l(S).partyB = he), modelModifiers: { trim: true }, type: "text", placeholder: "乙方", class: "input-underline", maxlength: "60" }, null, 8, ["modelValue"])]), _: 1 })])]), _: 1, __: [61] }), s(q, { span: 12, class: "item-wrap" }, { default: p(() => [I[62] || (I[62] = C("span", { class: "item-title common-class" }, "丙方", -1)), C("div", b1e, [s(B, { class: "el-form-item-18", label: "", prop: "partyC", "label-width": "0" }, { default: p(() => [s(ae, { modelValue: l(S).partyC, "onUpdate:modelValue": I[15] || (I[15] = (he) => l(S).partyC = he), modelModifiers: { trim: true }, type: "text", placeholder: "丙方", class: "input-underline", maxlength: "60" }, null, 8, ["modelValue"])]), _: 1 })])]), _: 1, __: [62] }), s(q, { span: 12, class: "item-wrap" }, { default: p(() => [I[63] || (I[63] = C("span", { class: "item-title common-class" }, "丁方", -1)), C("div", V1e, [s(B, { class: "el-form-item-18", label: "", prop: "partyD", "label-width": "0" }, { default: p(() => [s(ae, { modelValue: l(S).name, "onUpdate:modelValue": I[16] || (I[16] = (he) => l(S).name = he), modelModifiers: { trim: true }, type: "text", placeholder: "丁方", class: "input-underline", maxlength: "60" }, null, 8, ["modelValue"])]), _: 1 })])]), _: 1, __: [63] }), s(q, { span: 24, class: "item-wrap" }, { default: p(() => I[64] || (I[64] = [C("div", { class: "single-class" }, "主要内容", -1)])), _: 1, __: [64] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[65] || (I[65] = C("span", { class: "item-title common-class" }, "中标通知书", -1)), C("div", w1e, [s(B, { class: "el-form-item-18", label: "", prop: "boolBidWinningNotice", "label-width": "0" }, { default: p(() => [s(ee, { modelValue: l(S).boolBidWinningNotice, "onUpdate:modelValue": I[17] || (I[17] = (he) => l(S).boolBidWinningNotice = he), options: l(qn).ENUM, type: "enum", size: "default", clearable: "", style: { width: "100%" }, class: "input-underline", placeholder: "请选择" }, null, 8, ["modelValue", "options"])]), _: 1 })])]), _: 1, __: [65] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[66] || (I[66] = C("span", { class: "item-title common-class" }, "图纸", -1)), C("div", S1e, [s(B, { class: "el-form-item-18", label: "", prop: "drawing", "label-width": "0" }, { default: p(() => [s(ee, { modelValue: l(S).drawing, "onUpdate:modelValue": I[18] || (I[18] = (he) => l(S).drawing = he), options: l(gr).ENUM, type: "enum", size: "default", clearable: "", style: { width: "100%" }, class: "input-underline", placeholder: "请选择" }, null, 8, ["modelValue", "options"])]), _: 1 })])]), _: 1, __: [66] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[67] || (I[67] = C("span", { class: "item-title common-class" }, "是否有报价书", -1)), C("div", v1e, [s(B, { class: "el-form-item-18", label: "", prop: "boolBidProposals", "label-width": "0" }, { default: p(() => [s(ee, { modelValue: l(S).boolBidProposals, "onUpdate:modelValue": I[19] || (I[19] = (he) => l(S).boolBidProposals = he), options: l(ea).ENUM, type: "enum", size: "default", clearable: "", style: { width: "100%" }, class: "input-underline", placeholder: "请选择" }, null, 8, ["modelValue", "options"])]), _: 1 })])]), _: 1, __: [67] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[68] || (I[68] = C("span", { class: "item-title common-class" }, "是否有招标文件", -1)), C("div", R1e, [s(B, { class: "el-form-item-18", label: "", prop: "boolBidDocument", "label-width": "0" }, { default: p(() => [s(ee, { modelValue: l(S).boolBidDocument, "onUpdate:modelValue": I[20] || (I[20] = (he) => l(S).boolBidDocument = he), options: l(ea).ENUM, type: "enum", size: "default", clearable: "", style: { width: "100%" }, class: "input-underline", placeholder: "请选择" }, null, 8, ["modelValue", "options"])]), _: 1 })])]), _: 1, __: [68] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[69] || (I[69] = C("span", { class: "item-title common-class" }, "承包性质", -1)), C("div", M1e, [s(B, { class: "el-form-item-18", label: "", prop: "contractualNature", "label-width": "0" }, { default: p(() => [s(ee, { modelValue: l(S).contractualNature, "onUpdate:modelValue": I[21] || (I[21] = (he) => l(S).contractualNature = he), options: l(n)[l(Ja).CONTRACTUAL_NATURE.V], dataStructure: { key: "id", label: "fieldValue", value: "id" }, disabled: !l(o), clearable: "", class: "input-underline", placeholder: "请选择承包性质", style: { width: "100%" } }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 })])]), _: 1, __: [69] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[70] || (I[70] = C("span", { class: "item-title common-class" }, "招标方式", -1)), C("div", A1e, [s(B, { class: "el-form-item-18", label: "", prop: "biddingMethod", "label-width": "0" }, { default: p(() => [s(ee, { modelValue: l(S).biddingMethod, "onUpdate:modelValue": I[22] || (I[22] = (he) => l(S).biddingMethod = he), options: l(n)[l(Ja).BIDDING_METHOD.V], dataStructure: { key: "id", label: "fieldValue", value: "id" }, disabled: !l(o), clearable: "", class: "input-underline", placeholder: "请选择招标方式", style: { width: "100%" } }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 })])]), _: 1, __: [70] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[71] || (I[71] = C("span", { class: "item-title common-class" }, "甲方类别", -1)), C("div", N1e, [s(B, { class: "el-form-item-18", label: "", prop: "partyType", "label-width": "0" }, { default: p(() => [s(ee, { modelValue: l(S).partyType, "onUpdate:modelValue": I[23] || (I[23] = (he) => l(S).partyType = he), options: l(n)[l(Ja).PARTY_TYPE.V], dataStructure: { key: "id", label: "fieldValue", value: "id" }, disabled: !l(o), clearable: "", class: "input-underline", placeholder: "请选择甲方类别", style: { width: "100%" } }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 })])]), _: 1, __: [71] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[72] || (I[72] = C("span", { class: "item-title common-class" }, "是否装配式建筑", -1)), C("div", L1e, [s(B, { class: "el-form-item-18", label: "", prop: "boolFabricatedStructure", "label-width": "0" }, { default: p(() => [s(ee, { modelValue: l(S).boolFabricatedStructure, "onUpdate:modelValue": I[24] || (I[24] = (he) => l(S).boolFabricatedStructure = he), options: l(ea).ENUM, type: "enum", size: "default", clearable: "", style: { width: "100%" }, class: "input-underline", placeholder: "请选择" }, null, 8, ["modelValue", "options"])]), _: 1 })])]), _: 1, __: [72] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[73] || (I[73] = C("span", { class: "item-title common-class" }, "是否示范合同", -1)), C("div", I1e, [s(B, { class: "el-form-item-18", label: "", prop: "boolModelContract", "label-width": "0" }, { default: p(() => [s(ee, { modelValue: l(S).boolModelContract, "onUpdate:modelValue": I[25] || (I[25] = (he) => l(S).boolModelContract = he), options: l(ea).ENUM, type: "enum", size: "default", clearable: "", style: { width: "100%" }, class: "input-underline", placeholder: "请选择" }, null, 8, ["modelValue", "options"])]), _: 1 })])]), _: 1, __: [73] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[74] || (I[74] = C("span", { class: "item-title common-class" }, "工程所在地", -1)), C("div", C1e, [s(B, { class: "el-form-item-18", label: "", prop: "region", "label-width": "0" }, { default: p(() => [s(l(f2), { ref_key: "region", ref: b, modelValue: l(S).region, "onUpdate:modelValue": I[26] || (I[26] = (he) => l(S).region = he), class: "input-underline", clearable: "", filterable: "", placeholder: "工程所在地", style: { width: "100%" }, onChange: O }, null, 8, ["modelValue"])]), _: 1 })])]), _: 1, __: [74] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[75] || (I[75] = C("span", { class: "item-title common-class" }, "区域", -1)), C("div", P1e, [s(B, { class: "el-form-item-18", label: "", prop: "locationValue", "label-width": "0" }, { default: p(() => [C("span", null, K(l(S).locationValue), 1)]), _: 1 })])]), _: 1, __: [75] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[76] || (I[76] = C("span", { class: "item-title common-class" }, "结构类型", -1)), C("div", O1e, [s(B, { class: "el-form-item-18", label: "", prop: "structureType", "label-width": "0" }, { default: p(() => [s(ee, { modelValue: l(S).structureType, "onUpdate:modelValue": I[27] || (I[27] = (he) => l(S).structureType = he), options: l(n)[l(Ja).STRUCTURE_TYPE.V], dataStructure: { key: "id", label: "fieldValue", value: "id" }, disabled: !l(o), clearable: "", class: "input-underline", placeholder: "请选择结构类型", style: { width: "100%" } }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 })])]), _: 1, __: [76] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[77] || (I[77] = C("span", { class: "item-title common-class" }, "建筑面积（平方米）", -1)), C("div", k1e, [s(B, { class: "el-form-item-18", label: "", prop: "structureArea", "label-width": "0" }, { default: p(() => [s(oe, { modelValue: l(S).structureArea, "onUpdate:modelValue": I[28] || (I[28] = (he) => l(S).structureArea = he), controls: false, max: 999999999999, precision: l(Ze).COM_AREA__M2, step: 1, autocomplete: "off", class: "input-underline", placeholder: "请填写建筑面积", style: { width: "100%" } }, null, 8, ["modelValue", "precision"])]), _: 1 })])]), _: 1, __: [77] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[78] || (I[78] = C("span", { class: "item-title common-class needItem" }, "主结构用钢量(吨)", -1)), C("div", D1e, [s(B, { class: "el-form-item-18", label: "", prop: "mainStructureSteelMete", "label-width": "0" }, { default: p(() => [s(oe, { modelValue: l(S).mainStructureSteelMete, "onUpdate:modelValue": I[29] || (I[29] = (he) => l(S).mainStructureSteelMete = he), controls: false, max: 999999999999, precision: l(Ze).COM_WT__G, step: 1, autocomplete: "off", class: "input-underline", placeholder: "请填写主结构用钢量(吨)", style: { width: "100%" } }, null, 8, ["modelValue", "precision"])]), _: 1 })])]), _: 1, __: [78] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[79] || (I[79] = C("span", { class: "item-title common-class" }, "次结构用钢量(吨)", -1)), C("div", x1e, [s(B, { class: "el-form-item-18", label: "", prop: "subfabricSteelMete", "label-width": "0" }, { default: p(() => [s(oe, { modelValue: l(S).subfabricSteelMete, "onUpdate:modelValue": I[30] || (I[30] = (he) => l(S).subfabricSteelMete = he), controls: false, max: 999999999999, precision: l(Ze).COM_WT__G, step: 1, autocomplete: "off", class: "input-underline", placeholder: "请填写次结构用钢量(吨)", style: { width: "100%" } }, null, 8, ["modelValue", "precision"])]), _: 1 })])]), _: 1, __: [79] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[80] || (I[80] = C("span", { class: "item-title common-class" }, "最大跨度/高度", -1)), C("div", U1e, [s(B, { class: "el-form-item-18", label: "", prop: "maximumSpan", "label-width": "0" }, { default: p(() => [s(oe, { modelValue: l(S).maximumSpan, "onUpdate:modelValue": I[31] || (I[31] = (he) => l(S).maximumSpan = he), controls: false, max: 999999999999, precision: l(Ze).COM_T__MM, step: 1, autocomplete: "off", class: "input-underline", placeholder: "请填写建筑面积", style: { width: "100%" } }, null, 8, ["modelValue", "precision"])]), _: 1 })])]), _: 1, __: [80] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[81] || (I[81] = C("span", { class: "item-title common-class needItem" }, "开竣工日期", -1)), C("div", Y1e, [s(B, { class: "el-form-item-18", label: "", prop: "dateTime", "label-width": "0" }, { default: p(() => [s(j, { modelValue: l(S).dateTime, "onUpdate:modelValue": I[32] || (I[32] = (he) => l(S).dateTime = he), type: "daterange", "range-separator": ":", size: "default", class: "input-underline", "start-placeholder": "开工日期", "end-placeholder": "竣工日期", "value-format": "x", style: { width: "100%" }, onChange: L }, null, 8, ["modelValue"])]), _: 1 })])]), _: 1, __: [81] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[82] || (I[82] = C("span", { class: "item-title common-class" }, "总工期（天）", -1)), C("div", K1e, [s(B, { class: "el-form-item-18", label: "", prop: "", "label-width": "0" }, { default: p(() => [Te(K(l(S).allDays || "-"), 1)]), _: 1 })])]), _: 1, __: [82] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[83] || (I[83] = C("span", { class: "item-title common-class" }, "预付款比例", -1)), C("div", W1e, [s(B, { class: "el-form-item-18", label: "", prop: "prepaymentRatio", "label-width": "0" }, { default: p(() => [s(ae, { modelValue: l(S).prepaymentRatio, "onUpdate:modelValue": I[33] || (I[33] = (he) => l(S).prepaymentRatio = he), modelModifiers: { trim: true }, type: "text", placeholder: "预付款比例", class: "input-underline", maxlength: "200" }, null, 8, ["modelValue"])]), _: 1 })])]), _: 1, __: [83] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[84] || (I[84] = C("span", { class: "item-title common-class" }, "质保金比例(%)", -1)), C("div", j1e, [s(B, { class: "el-form-item-18", label: "", prop: "warrantyRatio", "label-width": "0" }, { default: p(() => [s(oe, { modelValue: l(S).warrantyRatio, "onUpdate:modelValue": I[34] || (I[34] = (he) => l(S).warrantyRatio = he), controls: false, max: 100, precision: 2, step: 1, autocomplete: "off", class: "input-underline", placeholder: "请填写质保金比例", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 })])]), _: 1, __: [84] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[85] || (I[85] = C("span", { class: "item-title common-class" }, "农民工工资专户", -1)), C("div", F1e, [s(B, { class: "el-form-item-18", label: "", prop: "boolPeasantWorkerWageAccount", "label-width": "0" }, { default: p(() => [s(ee, { modelValue: l(S).boolPeasantWorkerWageAccount, "onUpdate:modelValue": I[35] || (I[35] = (he) => l(S).boolPeasantWorkerWageAccount = he), options: l(ea).ENUM, type: "enum", size: "default", clearable: "", style: { width: "100%" }, class: "input-underline", placeholder: "请选择" }, null, 8, ["modelValue", "options"])]), _: 1 })])]), _: 1, __: [85] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[86] || (I[86] = C("span", { class: "item-title common-class" }, "农民工工资专户比例", -1)), C("div", z1e, [s(B, { class: "el-form-item-18", label: "", prop: "peasantWorkerWageRatio", "label-width": "0" }, { default: p(() => [s(ae, { modelValue: l(S).peasantWorkerWageRatio, "onUpdate:modelValue": I[36] || (I[36] = (he) => l(S).peasantWorkerWageRatio = he), modelModifiers: { trim: true }, type: "text", placeholder: "农民工工资专户比例", class: "input-underline", maxlength: "200" }, null, 8, ["modelValue"])]), _: 1 })])]), _: 1, __: [86] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[87] || (I[87] = C("span", { class: "item-title common-class" }, "进度款", -1)), C("div", B1e, [s(B, { class: "el-form-item-18", label: "", prop: "progressPayment", "label-width": "0" }, { default: p(() => [s(ae, { modelValue: l(S).progressPayment, "onUpdate:modelValue": I[37] || (I[37] = (he) => l(S).progressPayment = he), modelModifiers: { trim: true }, type: "text", placeholder: "进度款", class: "input-underline", maxlength: "200" }, null, 8, ["modelValue"])]), _: 1 })])]), _: 1, __: [87] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[88] || (I[88] = C("span", { class: "item-title common-class" }, "材料调差", -1)), C("div", H1e, [s(B, { class: "el-form-item-18", label: "", prop: "materialInspection", "label-width": "0" }, { default: p(() => [s(ae, { modelValue: l(S).materialInspection, "onUpdate:modelValue": I[38] || (I[38] = (he) => l(S).materialInspection = he), modelModifiers: { trim: true }, type: "text", placeholder: "材料调差", class: "input-underline", maxlength: "200" }, null, 8, ["modelValue"])]), _: 1 })])]), _: 1, __: [88] }), s(q, { span: 8, class: "item-wrap" }, { default: p(() => [I[89] || (I[89] = C("span", { class: "item-title common-class" }, "说明", -1)), C("div", q1e, [s(B, { class: "el-form-item-18", label: "", prop: "remark", "label-width": "0" }, { default: p(() => [s(ae, { modelValue: l(S).remark, "onUpdate:modelValue": I[39] || (I[39] = (he) => l(S).remark = he), rows: 2, maxlength: "1000", placeholder: "说明", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue"])]), _: 1 })])]), _: 1, __: [89] }), s(q, { span: 16, class: "item-wrap" }, { default: p(() => [I[90] || (I[90] = C("span", { class: "item-title common-class" }, "合同附件", -1)), C("div", G1e, [s(B, { class: "el-form-item-18", label: "", prop: "branchCompanyId", "label-width": "0" }, { default: p(() => [s(dl, { files: l(S).attachmentList, "onUpdate:files": I[40] || (I[40] = (he) => l(S).attachmentList = he), showView: true, class: "el-form-item-15", "empty-text": "暂未上传合同附件", "show-download": "" }, null, 8, ["files"])]), _: 1 })])]), _: 1, __: [90] })]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible"]);
  };
} }, J8 = ut(Q1e, [["__scopeId", "data-v-f5384770"]]), Z1e = Object.freeze(Object.defineProperty({ __proto__: null, default: J8 }, Symbol.toStringTag, { value: "Module" }));
const J1e = { style: { "max-height": "260px", overflow: "auto", "min-height": "80px" } }, X1e = { key: 1, class: "approval-actions" }, $1e = { class: "summary-bar" }, eEe = { class: "summary-item" }, tEe = { class: "summary-value" }, iEe = { class: "summary-item" }, aEe = { class: "summary-value" }, lEe = { class: "summary-item" }, oEe = { class: "summary-value" }, nEe = { class: "summary-item" }, sEe = { class: "summary-value" }, rEe = { __name: "approval-detail", props: { modelValue: { type: Boolean, default: false }, ApprovalFlag: { type: Boolean, default: false }, journalId: { type: [String, Number], default: void 0 }, form: { type: Object, default: () => ({}) } }, emits: ["update:modelValue", "auditSuccess"], setup(e, { emit: o }) {
  const n = { background: "#e0e0e0", color: "#303133", textAlign: "center", fontWeight: 500 }, c = e, u = o, r = Z(""), E = Z([]), y = Z([]), b = Z(false), V = Z({}), M = Z(false), g = Z([]), S = Ee({ get: () => c.modelValue, set: (oe) => u("update:modelValue", oe) }), h = Ee(() => c.journalId), T = Ee(() => Object.keys(V.value || {}).length ? V.value : c.form || {}), _ = Ee(() => ee(T.value, ["supplierName", "subjoinSupplierName"]) || "未选择"), f = Ee(() => ({ evaluateTime: B(ee(T.value, ["evaluateTime", "evaluateDate", "createTime"])), reviewResult: ee(T.value, ["score", "reviewResult", "evaluateResult"]), scoreRating: ee(T.value, ["scoreRating", "scoreRatingName", "ratingName"]), evaluatorName: ee(T.value, ["evaluatorName", "evaluateUserName", "createUserName"]) })), m = Ee(() => {
    const oe = c.form || {};
    return oe.evaluateId || oe.dataId || oe.id;
  });
  Ce(() => c.modelValue, async (oe) => {
    oe && (r.value = "", await v());
  }, { immediate: true });
  function R() {
    S.value = false;
  }
  async function v() {
    b.value = true, V.value = {};
    try {
      if (m.value) {
        const oe = await F8(m.value);
        V.value = L(oe);
      }
    } catch (oe) {
      console.log("供应商评价审批详情获取失败", oe);
    } finally {
      P(T.value), b.value = false;
    }
  }
  async function N() {
    if (!(!h.value || M.value) && !(Array.isArray(g.value) && g.value.length)) {
      M.value = true;
      try {
        const oe = await Jn(h.value);
        g.value = Array.isArray(oe) ? oe : oe || [];
      } catch (oe) {
        console.log("供应商评价审批记录获取失败", oe), g.value = [];
      } finally {
        M.value = false;
      }
    }
  }
  function P(oe = {}) {
    const ye = I(ee(oe, ["evaluateDetailsJson", "evaluateJson", "value"])), ce = x(Y(oe.columnMap || oe.columnMapJson), ye);
    E.value = ce, y.value = ye.filter((se) => ae(se)).map((se) => ({ ...se, score: q(ee(se, ["score", "evaluateScore", "actualScore"])) }));
  }
  function L(oe) {
    return oe ? oe.data && typeof oe.data == "object" && !Array.isArray(oe.data) ? oe.data : typeof oe == "object" && !Array.isArray(oe) ? oe : {} : {};
  }
  async function O(oe) {
    var ce;
    if (!c.ApprovalFlag) return;
    if (oe === Lt.REFUSE.V && !A(r.value)) {
      ot.error("请输入审批意见");
      return;
    }
    const ye = ((ce = V.value) == null ? void 0 : ce.id) || m.value;
    if (!ye) {
      ot.error("缺少评价记录ID，无法审批");
      return;
    }
    await mhe({ decision: oe, evaluateId: ye, opinion: r.value || void 0 }), ot.success(oe === Lt.PASS.V ? "审批通过" : "审批驳回"), R(), u("auditSuccess");
  }
  function x(oe, ye) {
    const ce = Object.keys(oe || {}).filter((be) => !["serialNumber", "score", "hasVeto"].includes(be)), se = ye.length ? Object.keys(ye[0]).filter((be) => !["serialNumber", "score", "hasVeto"].includes(be)) : [];
    return (ce.length ? ce : se).map((be) => ({ key: be, title: oe && oe[be] || be }));
  }
  function I(oe) {
    if (Array.isArray(oe)) return oe;
    if (!oe || typeof oe != "string") return [];
    try {
      const ye = JSON.parse(oe);
      return Array.isArray(ye) ? ye : [];
    } catch {
      return [];
    }
  }
  function Y(oe) {
    if (oe && typeof oe == "object" && !Array.isArray(oe)) return oe;
    if (typeof oe == "string") try {
      const ye = JSON.parse(oe);
      return ye && typeof ye == "object" && !Array.isArray(ye) ? ye : {};
    } catch {
      return {};
    }
    return {};
  }
  function ee(oe, ye = []) {
    return !oe || typeof oe != "object" ? "" : ye.map((se) => oe == null ? void 0 : oe[se]).find((se) => se != null && se !== "") || "";
  }
  function B(oe) {
    if (oe == null || oe === "") return "";
    const ye = Number(oe);
    return Number.isNaN(ye) ? String(oe) : Qi(ye);
  }
  function q(oe) {
    if (oe == null || oe === "") return "";
    const ye = Number(oe);
    return Number.isFinite(ye) ? ye : oe;
  }
  function ae(oe = {}) {
    return j(oe) ? le(oe.hasVeto) === true : true;
  }
  function j(oe = {}) {
    return String(oe.assessmentProject || "").trim() === "否决项";
  }
  function le(oe) {
    if (oe === true || oe === false) return oe;
    const ye = String(oe || "").trim().toLowerCase();
    if (["1", "true", "是", "y", "yes"].includes(ye)) return true;
    if (["0", "false", "否", "n", "no"].includes(ye)) return false;
  }
  return (oe, ye) => {
    const ce = wi, se = Ve("common-button"), he = La, be = pa, me = vt, ge = BV, Le = jm, Ie = Mt, Se = Ve("common-drawer"), X = oi;
    return w(), U(Se, { "before-close": R, visible: S.value, "custom-class": "supplier-evaluation-approval-drawer", size: "100%", title: "供应商评价审批" }, { titleAfter: p(() => [s(ce, { effect: "plain" }, { default: p(() => [Te("当前供应商：" + K(_.value), 1)]), _: 1 })]), titleRight: p(() => [e.ApprovalFlag && h.value ? (w(), U(he, { key: 0, width: 400, placement: "bottom-start", trigger: "hover", onShow: N }, { reference: p(() => [s(se, { style: { width: "140px" } }, { default: p(() => ye[3] || (ye[3] = [Te("查看审批记录")])), _: 1, __: [3] })]), default: p(() => [qe((w(), Q("div", J1e, [s(tl, { data: g.value || [] }, null, 8, ["data"])])), [[X, M.value]])]), _: 1 })) : H("", true), e.ApprovalFlag ? (w(), Q("div", X1e, [s(be, { title: "确认通过", onConfirm: ye[0] || (ye[0] = ($) => O(l(Lt).PASS.V)) }, { reference: p(() => [s(se, { type: "success" }, { default: p(() => ye[4] || (ye[4] = [Te("通过")])), _: 1, __: [4] })]), _: 1 }), s(be, { title: "确认驳回", onConfirm: ye[1] || (ye[1] = ($) => O(l(Lt).REFUSE.V)) }, { reference: p(() => [s(se, { type: "danger" }, { default: p(() => ye[5] || (ye[5] = [Te("驳回")])), _: 1, __: [5] })]), _: 1 })])) : H("", true)]), content: p(() => [qe((w(), U(Le, { shadow: "always" }, { default: p(() => [C("div", $1e, [C("div", eEe, [ye[6] || (ye[6] = C("div", { class: "summary-label" }, "评价时间", -1)), C("div", tEe, K(f.value.evaluateTime || "-"), 1)]), C("div", iEe, [ye[7] || (ye[7] = C("div", { class: "summary-label" }, "评审结果", -1)), C("div", aEe, K(f.value.reviewResult || "-"), 1)]), C("div", lEe, [ye[8] || (ye[8] = C("div", { class: "summary-label" }, "评级", -1)), C("div", oEe, K(f.value.scoreRating || "-"), 1)]), C("div", nEe, [ye[9] || (ye[9] = C("div", { class: "summary-label" }, "评价人", -1)), C("div", sEe, K(f.value.evaluatorName || "-"), 1)])]), s(ge, { data: y.value, "header-cell-style": n, border: "", class: "detail-table" }, { default: p(() => [(w(true), Q(Qe, null, ki(E.value, ($) => (w(), U(me, { key: $.key, label: $.title, "min-width": $.key === "assessmentContents" ? 280 : 160, align: "center", "show-overflow-tooltip": "" }, { default: p(({ row: k }) => [Te(K(k[$.key] || "-"), 1)]), _: 2 }, 1032, ["label", "min-width"]))), 128)), s(me, { label: "评分", width: "140", align: "center" }, { default: p(({ row: $ }) => [Te(K($.score ?? "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data"])]), _: 1 })), [[X, b.value]]), e.ApprovalFlag ? (w(), U(Ie, { key: 0, modelValue: r.value, "onUpdate:modelValue": ye[2] || (ye[2] = ($) => r.value = $), modelModifiers: { trim: true }, rows: 2, class: "approval-comments", maxlength: "1000", placeholder: "审核意见", "show-word-limit": "", style: { "margin-top": "8px" }, type: "textarea" }, null, 8, ["modelValue"])) : H("", true)]), _: 1 }, 8, ["visible"]);
  };
} }, X8 = ut(rEe, [["__scopeId", "data-v-9016c828"]]), uEe = Object.freeze(Object.defineProperty({ __proto__: null, default: X8 }, Symbol.toStringTag, { value: "Module" }));
function e0t(e) {
  return W({ url: "/api/project/v2/standingbook", method: "get", params: e });
}
function t0t(e) {
  return W({ url: "/api/project/v2/standingbook/sum", method: "get", params: e });
}
function i0t(e) {
  return W({ url: "/api/user/tree", method: "get", params: e });
}
function a0t(e) {
  return W({ url: "/api/project/tree", method: "get", params: e });
}
function l0t(e) {
  return W({ url: "/api/project/v2/getProjectAttributeList", method: "get", params: e });
}
function o0t(e) {
  return W({ url: "/api/project/v2/standingbook/incomeAndExpenses", method: "get", params: e });
}
function n0t(e) {
  return W({ url: "/api/project/v2/detailList", method: "get", params: e });
}
function s0t(e) {
  return W({ url: "/api/project/v2/standingbook/incomeAndExpensesList", params: e });
}
function r0t(e) {
  return W({ url: "/api/project/v2/getAbstract", method: "get", params: e });
}
function u0t(e) {
  return W({ url: "/api/contract/collection/v2/save", method: "post", data: e });
}
function cEe(e) {
  return W({ url: "/api/contract/audit/project/collection", method: "put", data: e });
}
function dEe(e) {
  return W({ url: "/api/contract/audit/project/collection/info", method: "get", params: { auditId: e } });
}
function c0t(e) {
  return W({ url: "/api/contract/collection/v2/listPage", method: "get", params: e });
}
function d0t(e) {
  return W({ url: "/api/contract/collection/v2/getCollection", method: "get", params: { ...e } });
}
function m0t(e) {
  return W({ url: "/api/contract/invoice/V2/listPage", method: "get", params: e });
}
function p0t(e) {
  return W({ url: "/api/contract/invoice/save", method: "post", data: e });
}
function h0t(e) {
  return W({ url: "/api/contract/invoice/getInvoice", method: "get", params: { ...e } });
}
function f0t(e) {
  return W({ url: "/api/common/attachment", method: "post", data: e, headers: { "Content-Type": "multipart/form-data" } });
}
function g0t(e) {
  return W({ url: `/api/common/attachment/download/${e.id}`, method: "get", responseType: "blob", headers: { "Content-Type": "application/x-www-form-urlencoded" } });
}
function E0t() {
  return W({ url: "/api/dictDetail/all?name=invoice_tax_rate", method: "get" });
}
function y0t(e) {
  return W({ url: "/api/contractManagementCost/getProjectManagementCost", method: "get", params: e });
}
function T0t(e) {
  return W({ url: "/api/securityAndManagementCost/page", method: "get", params: e });
}
function _0t(e) {
  return W({ url: "/api/securityAndManagementCost/accruingAmounts", method: "get", params: e });
}
function b0t(e) {
  return W({ url: "/api/securityAndManagementCost/sendBack", method: "post", data: e });
}
function V0t(e) {
  return W({ url: "/api/contractManagementCost/projectManagementCost", method: "post", data: e });
}
function w0t(e) {
  return W({ url: "/api/contractEarnestMoney/earnestMoney", method: "put", data: e });
}
const mEe = { key: 0, class: "main-content" }, pEe = { key: 0, class: "title" }, hEe = { key: 1, class: "main-content" }, fEe = { class: "chunk-text" }, gEe = { class: "sub-title-container" }, EEe = { __name: "table-header", props: { typeOne: { type: Boolean, default: true }, headerTitle: { type: String, required: true }, color: { type: String, default: "#72767b" }, textColor: { type: String, default: "#72767b" } }, setup(e) {
  const o = e;
  return (n, c) => (w(), Q("div", { style: ri(`--title-color:${o.color};--text-color:${o.textColor}`), class: "header-container" }, [xt(n.$slots, "headerLeft", {}, void 0, true), e.typeOne ? (w(), Q("div", mEe, [o.headerTitle ? (w(), Q("div", pEe, K(o.headerTitle), 1)) : H("", true), xt(n.$slots, "subTitle", {}, void 0, true)])) : (w(), Q("div", hEe, [c[0] || (c[0] = C("div", { class: "chunk" }, null, -1)), C("span", fEe, K(o.headerTitle), 1), C("div", gEe, [xt(n.$slots, "subTitle", {}, void 0, true)])])), xt(n.$slots, "headerRight", {}, void 0, true)], 4));
} }, $8 = ut(EEe, [["__scopeId", "data-v-d39815f3"]]), yEe = { key: 0, class: "approval-container" }, e6 = { __name: "approval-status-collection", props: { currentDetail: { type: Object, default: () => {
} } }, setup(e) {
  const o = e, n = Ee(() => o.currentDetail || {}), c = Z([]), u = Z(), r = async () => {
    var E;
    try {
      const y = await lpe((E = n.value) == null ? void 0 : E.auditId);
      y.forEach((b) => {
        b.approveResult === 1 ? b.type = "warning" : b.approveResult === 2 ? b.type = "success" : b.type = "danger";
      }), c.value = h2(y, [], true);
    } catch (y) {
      console.error("获取审批流程失败:/api/contract/audit/getAudit", y);
    }
  };
  return Dt(() => {
    var E;
    (E = n.value) != null && E.auditId && r();
  }), (E, y) => {
    const b = vt, V = Ve("common-table");
    return c.value.length ? (w(), Q("div", yEe, [s($8, { "header-title": "审批状态" }), s(V, { ref_key: "tableRef", ref: u, data: c.value }, { default: p(() => [s(b, { align: "center", label: "节点" }, { default: p(({ row: M }) => [C("span", null, K(l(wc).VL[M.approveType]), 1)]), _: 1 }), s(b, { align: "center", label: "关联审批人", prop: "userName" }), s(b, { align: "center", label: "到达时间", prop: "arriveTime" }), s(b, { align: "center", label: "处理时间", prop: "approveTime" }), s(b, { align: "center", label: "处理意见", prop: "approveOpinion" })]), _: 1 }, 8, ["data"])])) : H("", true);
  };
} }, TEe = Object.freeze(Object.defineProperty({ __proto__: null, default: e6 }, Symbol.toStringTag, { value: "Module" }));
const _Ee = { key: 0 }, bEe = { class: "prop-span label" }, VEe = { class: "prop-span label" }, wEe = { class: "prop-span label" }, SEe = { key: 1 }, vEe = { class: "label" }, REe = { class: "prop-span label" }, MEe = { class: "prop-span label" }, AEe = { class: "label" }, NEe = { class: "prop-span label" }, LEe = { class: "label" }, IEe = { class: "prop-span label" }, CEe = { __name: "collection-audit", props: { componentName: { type: String, default: void 0 }, journalId: { type: Number, default: void 0 }, ApprovalFlag: { type: Boolean, default: false } }, emits: ["auditSuccess"], setup(e, { emit: o }) {
  const n = e, c = o, u = Z({}), { CRUD: r, crud: E, detail: y } = qi();
  r.HOOK.beforeDetailLoaded = async (M, g) => {
    u.value = g;
  };
  const b = () => {
    const M = y.collectionAmount;
    y.collectionAmount = Mpe(M, { allowNegative: true, decimalPlaces: 2 });
  };
  async function V(M) {
    const g = { auditId: y == null ? void 0 : y.auditId, remark: y.approvalComments, collectionAmount: y.collectionAmount, auditStatusEnum: M };
    if (M === Lt.REFUSE.V && !A(g.remark)) {
      ot.error("请输入审批意见");
      return;
    }
    await cEe(g).then((S) => {
      M === Lt.PASS.V ? ot.success("审批通过") : ot.error("审批驳回"), c("auditSuccess"), E.cancelDetail();
    });
  }
  return (M, g) => {
    const S = wi, h = Ve("common-button"), T = pa, _ = Bn, f = Zi, m = Hn, R = Mt, v = Li, N = Ml, P = Ve("common-drawer"), L = _t("ellipsis");
    return w(), U(P, { visible: l(E).detailVisible, "before-close": l(E).cancelDetail, "close-on-click-modal": false, title: "收款填报审批", size: "40%" }, { titleAfter: p(() => [s(S, null, { default: p(() => {
      var O, x;
      return [Te(K(((O = l(y)) == null ? void 0 : O.auditStatus) === 1 ? "审核中" : l(Lt).VL[(x = l(y)) == null ? void 0 : x.auditStatus]), 1)];
    }), _: 1 })]), titleRight: p(() => {
      var O;
      return [e.ApprovalFlag && ((O = l(y)) == null ? void 0 : O.auditStatus) === 1 ? (w(), Q("div", _Ee, [s(T, { title: "确认通过", onConfirm: g[0] || (g[0] = (x) => V(l(Lt).PASS.V)) }, { reference: p(() => [s(h, { class: "filter-item", size: "default", type: "success" }, { default: p(() => g[5] || (g[5] = [Te("通过")])), _: 1, __: [5] })]), _: 1 }), s(T, { title: "确认驳回", onConfirm: g[1] || (g[1] = (x) => V(l(Lt).REFUSE.V)) }, { reference: p(() => [s(h, { class: "filter-item", size: "default", type: "danger" }, { default: p(() => g[6] || (g[6] = [Te(" 驳回 ")])), _: 1, __: [6] })]), _: 1 })])) : H("", true)];
    }), content: p(() => [s(v, { ref: "formRef", class: "form-container", "label-position": "left" }, { default: p(() => [s(m, null, { default: p(() => [s(_, { span: 5 }, { default: p(() => [qe((w(), Q("span", bEe, g[7] || (g[7] = [Te("收款日期：")]))), [[L]])]), _: 1 }), s(_, { span: 19 }, { default: p(() => [s(f, { prop: "collectionDate" }, { default: p(() => [C("span", null, K(l(y).collectionDate ? l(Qi)(l(y).collectionDate, "{y}-{m}-{d}") : "-"), 1)]), _: 1 })]), _: 1 })]), _: 1 }), s(m, null, { default: p(() => [s(_, { span: 5 }, { default: p(() => [qe((w(), Q("span", VEe, g[8] || (g[8] = [Te("项目：")]))), [[L]])]), _: 1 }), s(_, { span: 19 }, { default: p(() => [s(f, { prop: "projectId" }, { default: p(() => [C("span", null, K(l(y).project ? l(di)(l(y).project) : "-"), 1)]), _: 1 })]), _: 1 })]), _: 1 }), s(m, null, { default: p(() => [s(_, { span: 5 }, { default: p(() => [qe((w(), Q("span", wEe, g[9] || (g[9] = [Te("本次收款：")]))), [[L]])]), _: 1 }), s(_, { span: 19 }, { default: p(() => [s(f, null, { default: p(() => {
      var O;
      return [l(y).boolFinalApprover && e.ApprovalFlag && ((O = l(y)) == null ? void 0 : O.auditStatus) === 1 ? (w(), U(R, { key: 0, modelValue: l(y).collectionAmount, "onUpdate:modelValue": g[2] || (g[2] = (x) => l(y).collectionAmount = x), class: "input-border-none", clearable: "", placeholder: "请输入金额", onInput: b }, null, 8, ["modelValue"])) : (w(), Q("span", SEe, K(l(y).collectionAmount ? l(Mi)(l(y).collectionAmount, l(Ze).YUAN) : "-"), 1))];
    }), _: 1 })]), _: 1 })]), _: 1 }), s(m, null, { default: p(() => [s(_, { span: 5 }, { default: p(() => [qe((w(), Q("span", vEe, g[10] || (g[10] = [Te("大写：")]))), [[L]])]), _: 1 }), s(_, { span: 19 }, { default: p(() => [s(f, null, { default: p(() => [C("span", null, K(l(y).collectionAmount ? l(iu)(l(y).collectionAmount) : "-"), 1)]), _: 1 })]), _: 1 })]), _: 1 }), s(m, null, { default: p(() => [s(_, { span: 5 }, { default: p(() => [qe((w(), Q("span", REe, g[11] || (g[11] = [Te("收款类型：")]))), [[L]])]), _: 1 }), s(_, { span: 19 }, { default: p(() => [s(f, { prop: "collectionMode" }, { default: p(() => [C("span", null, K(l(y).collectionMode ? l(nu).VL[l(y).collectionMode] : "-"), 1)]), _: 1 })]), _: 1 })]), _: 1 }), s(m, null, { default: p(() => [s(_, { span: 5 }, { default: p(() => [qe((w(), Q("span", MEe, g[12] || (g[12] = [Te("付款单位：")]))), [[L]])]), _: 1 }), s(_, { span: 19 }, { default: p(() => [s(f, { prop: "paymentUnit" }, { default: p(() => [C("span", null, K(l(y).paymentUnit || "-"), 1)]), _: 1 })]), _: 1 })]), _: 1 }), s(m, null, { default: p(() => [s(_, { span: 5 }, { default: p(() => [qe((w(), Q("span", AEe, g[13] || (g[13] = [Te("付款银行：")]))), [[L]])]), _: 1 }), s(_, { span: 19 }, { default: p(() => [s(f, null, { default: p(() => [C("span", null, K(l(y).paymentDepositBank || "-"), 1)]), _: 1 })]), _: 1 })]), _: 1 }), s(m, null, { default: p(() => [s(_, { span: 5 }, { default: p(() => [qe((w(), Q("span", NEe, g[14] || (g[14] = [Te("收款银行：")]))), [[L]])]), _: 1 }), s(_, { span: 19 }, { default: p(() => [s(f, null, { default: p(() => [C("span", null, K(l(y).collectionDepositBank || "-"), 1)]), _: 1 })]), _: 1 })]), _: 1 }), s(m, null, { default: p(() => [s(_, { span: 5 }, { default: p(() => [qe((w(), Q("span", LEe, g[15] || (g[15] = [Te("收款单位：")]))), [[L]])]), _: 1 }), s(_, { span: 19 }, { default: p(() => [s(f, { prop: "collectionUnit" }, { default: p(() => [C("span", null, K(l(y).collectionUnit || "-"), 1)]), _: 1 })]), _: 1 })]), _: 1 }), s(m, null, { default: p(() => [s(_, { span: 5 }, { default: p(() => [qe((w(), Q("span", IEe, g[16] || (g[16] = [Te("创建人：")]))), [[L]])]), _: 1 }), s(_, { span: 19 }, { default: p(() => [s(f, { prop: "writtenById" }, { default: p(() => [C("span", null, K(l(y).writtenByName || "-"), 1)]), _: 1 })]), _: 1 })]), _: 1 })]), _: 1 }, 512), s(N, null, { default: p(() => g[17] || (g[17] = [C("span", { class: "title" }, "附件", -1)])), _: 1, __: [17] }), s(dl, { files: l(y).attachmentList, "onUpdate:files": g[3] || (g[3] = (O) => l(y).attachmentList = O), "empty-text": "暂未上传附件", "show-download": "", showView: "", style: { "margin-top": "10px", "": "10px", padding: "0" } }, null, 8, ["files"]), n.ApprovalFlag ? (w(), U(R, { key: 0, modelValue: l(y).approvalComments, "onUpdate:modelValue": g[4] || (g[4] = (O) => l(y).approvalComments = O), rows: 2, class: "approval-comments", maxlength: "1000", placeholder: "审核意见", "show-word-limit": "", style: { "margin-top": "5px", width: "100%" }, type: "textarea" }, null, 8, ["modelValue"])) : H("", true), s(e6, { style: { "margin-top": "10px" }, currentDetail: u.value }, null, 8, ["currentDetail"])]), _: 1 }, 8, ["visible", "before-close"]);
  };
} }, t6 = ut(CEe, [["__scopeId", "data-v-8f00f6fd"]]), PEe = Object.freeze(Object.defineProperty({ __proto__: null, default: t6 }, Symbol.toStringTag, { value: "Module" }));
const OEe = ["onClick"], kEe = { key: 1 }, DEe = ["innerHTML"], xEe = { class: "ellipsis-text" }, UEe = { style: { "max-height": "200px", overflow: "auto", "min-height": "150px" } }, YEe = { key: 1, style: { "margin-left": "5px" } }, KEe = { key: 2, style: { "margin-left": "5px" } }, WEe = { __name: "index", props: { modelValue: { type: Boolean, default: false }, isManufactured: { type: Boolean, default: false }, form: { type: Object, default: () => ({}) } }, emits: ["saveSuccess", "update:modelValue", "manuf-del", "success", "close"], setup(e, { emit: o }) {
  const n = Ht(), { user: c } = ka(["user"]);
  d3();
  const u = o, r = e, E = { add: false, edit: false, del: false, download: false }, y = Z(), { visible: b, handleClose: V } = Ta({ emit: u, props: r }), M = Z(false), g = Z([["project", ["parse-project", { onlyShortName: true }]], ["reviewStatus", ["parse-enum", rr, { f: "L" }]], ["materialType", ["parse-enum", ct, { f: "L", bit: true, split: "、" }]], ["createTime", "parse-time"], ["lastApprovalTime", "parse-time"], ["flowArrivalTime", "parse-time"], ["updateTime", "parse-time"], ["reviewStatus", ["parse-enum", ws, { f: "L" }]]]), { CRUD: S, crud: h, columns: T } = cu({ title: "审批列表", invisibleColumns: [], requiredQuery: ["isOpened"], crudApi: { ..._9 }, optShow: { ...E } }, y), _ = Z(), { maxHeight: f } = Kt({ extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], navbar: false, clientHRepMainH: true, paginate: true, extraHeight: 210 }, _), { BusinessModuleEnum: m } = kO(), { subjoinMsgBool: R } = Zme(), v = Z(false), N = Z("detail");
  S.HOOK.beforeRefresh = () => (h.query.isOpened = true, b.value), S.HOOK.handleRefresh = async (he, { data: be }) => {
    be.content.forEach((me) => {
      var ge, Le, Ie, Se;
      if (me.inboundWay = (ge = JSON.parse(me.jsonData)) == null ? void 0 : ge.inboundWay, me.journalId = me.id, me.id = me.dataId, me.applicantName = (Le = me.applicantUserVO) == null ? void 0 : Le.name, me.wmsApproveFlowDTO.type !== null) switch (me.wmsApproveFlowDTO.type) {
        case Pn.COUNTERSIGNATURE.V:
          me.wmsApproveFlowDTO.tagColor = "#636fbc";
          break;
        case Pn.OR_SIGN.V:
          me.wmsApproveFlowDTO.tagColor = "#888585";
          break;
        case Pn.SINGLE_SIGNATURE.V:
          me.wmsApproveFlowDTO.tagColor = "#b95252";
          break;
        default:
          me.wmsApproveFlowDTO.tagColor = "#ff6f16";
          break;
      }
      me.lastApproverName = [], (Ie = me.wmsApproveFlowDTO.userSimpleResponseVOS) == null || Ie.forEach((X) => {
        X && me.lastApproverName.push(X.name);
      }), me.subjoinMsgStr = (Se = me.subjoinMsgList) == null ? void 0 : Se.join("<br />");
    });
  };
  const P = Z(false), L = Z(), O = Z({}), x = [at.PURCHASE_ORDER_V2_PAYMENT.V, at.PURCHASE_ORDER_V2_SETTLEMENT.V, at.PURCHASE_ORDER_V2_PRE_SETTLEMENT.V, at.PURCHASE_ORDER_V2_INVOICE.V, at.STANDING_BOOK_SELF_INVOICE.V, at.PROJECT_SETTLEMENT.V, at.SUPPLIER_SETTLE.V, at.SELF_SUBPACKAGE_PAYMENT.V, at.SELF_SUBPACKAGE_SETTLE.V, at.SELF_SUBPACKAGE_INVOICE.V, at.SELF_SUBPACKAGE_PRESETTLE.V, at.PROJECT_PRESETTLE.V, at.TEST_COST_AUDIT.V, at.WATER_ELECTRICITY_PROPERTY_AUDIT.V, at.REIMBURSE_AUDIT.V, at.WAGE_COST_AUDIT.V], I = Ee(() => {
    if (A(O.value) && O.value.componentName) {
      if (O.value.componentName && x.includes(O.value.componentName)) return D8;
      switch (O.value.componentName) {
        case at.REQUISITIONS_V2.V:
          return $_;
        case at.PURCHASE_ORDER_V2.V:
          return ks;
        case at.PURCHASE_ORDER_BG.V:
          return PS;
        case at.INBOUND_PURCHASE.V:
          return D_;
        case at.INBOUND_PARTY_A.V:
          return u4;
        case at.PLAN_MODEL_DOCUMENT_MANAGE.V:
        case at.PLAN_DRAWING_DOCUMENT_MANAGE.V:
        case at.PLAN_NUMERICAL_CONTROL_DOCUMENT_MANAGE.V:
        case at.PLAN_CHANGE_FILE.V:
        case at.PLAN_CONSTRUCTION_BLUEPRINT.V:
        case at.PLAN_PROCESS_DOCUMENT.V:
          return z4;
        case at.OUTBOUND_PURCHASE.V:
          return x_;
        case at.RETURN_V2.V:
        case at.ALL_RETURN.V:
          return H4;
        case at.MANUF_INBOUND_PURCHASE.V:
          return S8;
        case at.OUTBOUND_PARTYA.V:
          return B4;
        case at.INVENTORY_LOSS.V:
          return z_;
        case at.PRICE_ADJUST.V:
          return F_;
        case at.INVENTORY_PROFIT.V:
          return B_;
        case at.MOVING_INVENTORY.V:
          return d8;
        case at.STRIP_CONVERSION_LIST.V:
          return p8;
        case at.REJECT_REVIEW.V:
          return W_;
        case at.INSTALL_VISA_MANAGE.V:
          return h8;
        case at.CRM_PROJECT_FOLLOW_UP.V:
          return f8;
        case at.CRM_PROJECT_GIVE_UP.V:
          return g8;
        case at.CRM_PROJECT_ANTECEDENT_TRIAL.V:
          return E8;
        case at.CRM_PROJECT_BUSINESS_BID.V:
        case at.CRM_PROJECT_DEEP_DESIGN_BID.V:
        case at.CRM_PROJECT_STRUCTURAL_DESIGN_BID.V:
        case at.CRM_PROJECT_TECHNOLOGY_BID.V:
          return y8;
        case at.CRM_PROJECT_RECORD.V:
          return T8;
        case at.CRM_DIRECT.V:
        case at.CRM_NON_DIRECT.V:
          return _8;
        case at.MES_REPORTING_APPROVAL.V:
          return b8;
        case at.MES_COATING_PROCESS_APPROVAL.V:
          return V8;
        case at.Part_Approval.V:
          return x8;
        case at.MES_WMS_RECEIPT_AUDIT.V:
          return K8;
        case at.MES_WMS_ship_RECEIPT_AUDIT.V:
          return j8;
        case at.CONTRACT_CATALOG_PRE_REGISTER.V:
          return G8;
        case at.CONTRACT_CATALOG_REVIEW_REGISTER.V:
          return Z8;
        case at.SUPPLIER_EVALUATION.V:
          return X8;
        case at.LEDGER_COLLECTION_AUDIT.V:
          return t6;
        default:
          return null;
      }
    }
    return null;
  }), Y = Ee(() => {
    if (A(O.value) && O.value.componentName) switch (O.value.componentName) {
      case at.REQUISITIONS_V2.V:
        return X_;
      case at.PURCHASE_ORDER_V2.V:
        return r3;
      case at.PURCHASE_ORDER_BG.V:
        return mR;
      case at.INBOUND_PURCHASE.V:
        return r4;
      case at.INBOUND_PARTY_A.V:
        return F4;
      case at.RETURN_V2.V:
      case at.ALL_RETURN.V:
        return c8;
      case at.MANUF_INBOUND_PURCHASE.V:
        return v8;
      case at.PLAN_MODEL_DOCUMENT_MANAGE.V:
        return null;
      case at.PLAN_DRAWING_DOCUMENT_MANAGE.V:
        return null;
      case at.PLAN_NUMERICAL_CONTROL_DOCUMENT_MANAGE.V:
        return null;
      case at.PLAN_CHANGE_FILE.V:
        return null;
      case at.PLAN_CONSTRUCTION_BLUEPRINT.V:
        return null;
      case at.PLAN_PROCESS_DOCUMENT.V:
        return null;
      case at.CONTRACT_CATALOG_PRE_REGISTER.V:
        return Q8;
      case at.CONTRACT_CATALOG_REVIEW_REGISTER.V:
        return J8;
      default:
        return null;
    }
    return null;
  }), ee = Ee(() => {
    var he, be;
    if (A(O.value) && O.value.componentName) switch (O.value.componentName) {
      case at.REQUISITIONS_V2.V:
        return y9;
      case at.PURCHASE_ORDER_V2.V:
        return Tr;
      case at.PURCHASE_ORDER_BG.V:
        return Ew;
      case at.INBOUND_PURCHASE.V:
      case at.INBOUND_PARTY_A.V:
        return TS;
      case at.OUTBOUND_PARTYA.V:
      case at.OUTBOUND_PURCHASE.V:
        return y_;
      case at.RETURN_V2.V:
      case at.ALL_RETURN.V:
        return T_;
      case at.MANUF_INBOUND_PURCHASE.V:
        return SS;
      case at.INVENTORY_PROFIT.V:
        return __;
      case at.PLAN_MODEL_DOCUMENT_MANAGE.V:
      case at.PLAN_DRAWING_DOCUMENT_MANAGE.V:
      case at.PLAN_NUMERICAL_CONTROL_DOCUMENT_MANAGE.V:
      case at.PLAN_CHANGE_FILE.V:
      case at.PLAN_CONSTRUCTION_BLUEPRINT.V:
      case at.PLAN_PROCESS_DOCUMENT.V:
        return ML;
      case at.INSTALL_VISA_MANAGE.V:
        return VS;
      case at.CRM_PROJECT_FOLLOW_UP.V:
        return wO;
      case at.CRM_PROJECT_ANTECEDENT_TRIAL.V:
        return vO;
      case at.CRM_PROJECT_BUSINESS_BID.V:
      case at.CRM_PROJECT_DEEP_DESIGN_BID.V:
      case at.CRM_PROJECT_STRUCTURAL_DESIGN_BID.V:
      case at.CRM_PROJECT_TECHNOLOGY_BID.V:
        return MO;
      case at.CRM_PROJECT_GIVE_UP.V:
        return NO;
      case at.CRM_PROJECT_RECORD.V:
        return IO;
      case at.CRM_DIRECT.V:
      case at.CRM_NON_DIRECT.V:
        return PO;
      case at.MES_REPORTING_APPROVAL.V:
        return wS;
      case at.MES_COATING_PROCESS_APPROVAL.V:
        return rO;
      case at.Part_Approval.V:
        return (he = O.value.dataSerialNumber) != null && he.includes("(直)") ? Lpe : (be = O.value.dataSerialNumber) != null && be.includes("(型)") ? Ipe : Cpe;
      case at.MES_WMS_RECEIPT_AUDIT.V:
        return U8;
      case at.MES_WMS_ship_RECEIPT_AUDIT.V:
        return W8;
      case at.MOVING_INVENTORY.V:
        return A_;
      case at.STRIP_CONVERSION_LIST.V:
        return m8;
      case at.REJECT_REVIEW.V:
        return N_;
      case at.CONTRACT_CATALOG_PRE_REGISTER.V:
        return z8;
      case at.CONTRACT_CATALOG_REVIEW_REGISTER.V:
        return H8;
      case at.SUPPLIER_EVALUATION.V:
        return F8;
      case at.LEDGER_COLLECTION_AUDIT.V:
        return dEe;
      default:
        return null;
    }
    return null;
  });
  function B(he) {
    A(he) && (h.detailKey = "id", he.moduleType === qr.PLAN_MANAGEMENT.V ? he.id = he.journalId : he.id = he.dataId, M.value = false, L.value = he == null ? void 0 : he.journalId, P.value = false, O.value = he || {}, he.componentName === at.PRICE_ADJUST.V && (O.value.showSerialNumber = he.dataSerialNumber), he.componentName !== at.INVENTORY_LOSS.V && (h.crudApi.detail = ee.value), h.crudApi.detail = ee.value);
  }
  function q(he, be) {
    B(he), he.componentName !== at.INVENTORY_LOSS.V && le(he), N.value = be, setTimeout(() => {
      v.value = true;
    }, 10);
  }
  async function ae(he) {
    if (x.includes(he.componentName) && console.log(he.componentName), !A(he)) return false;
    he.componentName === at.REQUISITIONS_V2.V && he.componentName === at.PURCHASE_ORDER_V2.V && he.componentName === at.PURCHASE_ORDER_BG.V && he.componentName === at.INBOUND_PURCHASE.V && he.componentName === at.INBOUND_PARTY_A.V && he.componentName === at.RETURN_V2.V && he.componentName === at.ALL_RETURN.V && he.componentName === at.MANUF_INBOUND_PURCHASE.V && await n.dispatch("wms/fetchSteelDensityCfg");
    const be = { id: he == null ? void 0 : he.journalId };
    if (!await E9(be)) return false;
    B(he), M.value = true, h.crudApi.detail = ee.value, h.detailKey = "id", h.submitResultJudge = he.componentName === at.CONTRACT_CATALOG_REVIEW_REGISTER.V;
  }
  function j(he) {
    if (!he.boolOperation) {
      ot.error("请前往APP审核");
      return;
    }
    console.log(he, "currentData"), B(he), N.value = "audit", P.value = true, he.componentName !== at.INVENTORY_LOSS.V && le(he), M.value = false, setTimeout(() => {
      v.value = true;
    }, 0);
  }
  function le(he) {
    setTimeout(() => {
      h.toDetail(he, { approveProcessTypeEnumV2: (he == null ? void 0 : he.approveProcessType) || void 0 });
    }, 0);
  }
  async function oe(he) {
    var ge;
    if (console.log(he), ((ge = he.dataSerialNumber) == null ? void 0 : ge.length) === 6) {
      try {
        await z5({ oaUserId: n.getters.user.oaUserId, requestId: he.requestId, approveProcessType: he.approveProcessType }), ot.success("撤销成功"), h.refresh();
      } catch (Le) {
        console.log(Le);
      }
      return;
    }
    if (!he.boolOperation) {
      ot.error("请前往APP撤销");
      return;
    }
    const be = {};
    if (he.moduleType === qr.PLAN_MANAGEMENT.V ? be.approvalRecordId = he.journalId : (be.id = he.id, be.approveProcessTypeEnumV2 = (he == null ? void 0 : he.approveProcessType) || void 0), !A(he)) return;
    let me;
    switch (he.componentName) {
      case at.REQUISITIONS_V2.V:
        me = h5;
        break;
      case at.PURCHASE_ORDER_V2.V:
        me = Y5;
        break;
      case at.PURCHASE_ORDER_BG.V:
        me = N5;
        break;
      case at.INBOUND_PURCHASE.V:
        me = z2;
        break;
      case at.INBOUND_PARTY_A.V:
        me = z2;
        break;
      case at.PLAN_MODEL_DOCUMENT_MANAGE.V:
      case at.PLAN_DRAWING_DOCUMENT_MANAGE.V:
      case at.PLAN_NUMERICAL_CONTROL_DOCUMENT_MANAGE.V:
      case at.PLAN_CHANGE_FILE.V:
      case at.PLAN_CONSTRUCTION_BLUEPRINT.V:
      case at.PLAN_PROCESS_DOCUMENT.V:
        me = AL;
        break;
      case at.OUTBOUND_PURCHASE.V:
      case at.OUTBOUND_PARTYA.V:
        me = J7;
        break;
      case at.INSTALL_VISA_MANAGE.V:
        me = aO;
        break;
      case at.CRM_PROJECT_FOLLOW_UP.V:
        me = SO;
        break;
      case at.CRM_PROJECT_ANTECEDENT_TRIAL.V:
        me = RO;
        break;
      case at.CRM_PROJECT_BUSINESS_BID.V:
      case at.CRM_PROJECT_DEEP_DESIGN_BID.V:
      case at.CRM_PROJECT_STRUCTURAL_DESIGN_BID.V:
      case at.CRM_PROJECT_TECHNOLOGY_BID.V:
        me = AO;
        break;
      case at.CRM_PROJECT_GIVE_UP.V:
        me = LO;
        break;
      case at.CRM_PROJECT_RECORD.V:
        me = CO;
        break;
      case at.CRM_DIRECT.V:
      case at.CRM_NON_DIRECT.V:
        me = OO;
        break;
      case at.MES_REPORTING_APPROVAL.V:
        me = sO;
        break;
      case at.MES_COATING_PROCESS_APPROVAL.V:
        me = cO;
        break;
      case at.MANUF_INBOUND_PURCHASE.V:
        me = fO;
        break;
      case at.MES_WMS_RECEIPT_AUDIT.V:
        me = Wpe;
        break;
      case at.INVENTORY_LOSS.V:
        me = TO;
        break;
      case at.PRICE_ADJUST.V:
        me = fF;
        break;
      case at.INVENTORY_PROFIT.V:
        me = VO;
        break;
      case at.ALL_RETURN.V:
        me = pue;
        break;
      case at.MES_WMS_ship_RECEIPT_AUDIT.V:
        me = rhe;
        break;
      case at.MOVING_INVENTORY.V:
        me = HU;
        break;
      case at.REJECT_REVIEW.V:
        me = ZU;
        break;
      case at.STRIP_CONVERSION_LIST.V:
        me = yde;
        break;
      case at.CONTRACT_CATALOG_PRE_REGISTER.V:
        me = yhe;
        break;
      case at.CONTRACT_CATALOG_REVIEW_REGISTER.V:
        me = She;
        break;
      case at.SUPPLIER_EVALUATION.V:
        me = () => phe(he.dataId || he.id);
        break;
    }
    await me(be), ot.success("撤销成功"), await n.dispatch("approval_list/fetchApprovalNum", he.componentName), await n.dispatch("approval_list/fetchSubNum", he.componentName), (he.componentName === at.PURCHASE_ORDER_BG.V || he.componentName === at.PURCHASE_ORDER_V2.V) && await n.dispatch("config/fetchSupplyUsedProject"), h.refresh();
  }
  async function ye(he) {
    he.loading = true;
    try {
      Ae(he.wmsApproveRecordFlowDTO) && (he.wmsApproveRecordFlowDTO = await Jn(he.journalId));
    } catch (be) {
      console.log(be, "获取失败");
    } finally {
      he.loading = false;
    }
  }
  function ce() {
    h.cancelDetail(), h.refresh();
  }
  Ce(b, async (he) => {
    he && (h.query.isOpened = true, h.toQuery(), await n.dispatch("wms/fetchSteelDensityCfg"), await n.dispatch("approval_list/fetchRefresh", false)), he || (h.query.isOpened = void 0, await n.dispatch("approval_list/fetchApprovalNum"), await n.dispatch("approval_list/fetchRefresh", true));
  });
  function se() {
    u("close");
  }
  return (he, be) => {
    const me = vt, ge = jt, Le = wi, Ie = La, Se = Ve("common-button"), X = pa, $ = Ve("common-table"), k = Ve("common-dialog"), J = oi;
    return w(), Q(Qe, null, [s(k, { ref_key: "dialogRef", ref: _, modelValue: l(b), "onUpdate:modelValue": be[0] || (be[0] = (z) => Gt(b) ? b.value = z : null), "before-close": l(V), title: l(h).title, "custom-class": "requisitions-application-preview", fullscreen: "", onClose: se }, { default: p(() => [s(l(BO), { BusinessModuleEnum: l(m), dialogVisible: l(b), form: r.form, subjoinMsgBool: l(R) }, null, 8, ["BusinessModuleEnum", "dialogVisible", "form", "subjoinMsgBool"]), qe((w(), U($, { ref_key: "tableRef", ref: y, data: l(h).data, "data-format": g.value, "max-height": l(f) - 40, style: { width: "100%" } }, { default: p(() => [s(me, { align: "center", label: "序号", type: "index", width: "55" }), l(T).visible("createTime") ? (w(), U(me, { key: "createTime", align: "center", label: "申请日期", "min-width": "130", prop: "createTime" })) : H("", true), l(T).visible("applicantName") ? (w(), U(me, { key: "applicantName", align: "center", label: "申请人", "min-width": "85", prop: "applicantName" })) : H("", true), l(T).visible("serialNumber") ? (w(), U(me, { key: "serialNumber", align: "center", label: "流程编号", "min-width": "150", prop: "serialNumber", "show-overflow-tooltip": "" })) : H("", true), l(T).visible("moduleTypeName") ? (w(), U(me, { key: "moduleTypeName", align: "center", label: "业务模块", "min-width": "80", prop: "moduleTypeName", "show-overflow-tooltip": "" })) : H("", true), l(T).visible("approveProcessTypeName") ? (w(), U(me, { key: "approveProcessTypeName", align: "left", label: "流程类型", "min-width": "180", prop: "approveProcessTypeName", "show-overflow-tooltip": "" }, { default: p(({ row: { sourceRow: z } }) => {
      var F;
      return [C("span", null, K(z.approveProcessTypeName) + " " + K(z.componentName === l(at).PURCHASE_ORDER_V2.V || z.componentName === l(at).PURCHASE_ORDER_BG.V ? "【" + ((F = l(at).V[z.componentName]) == null ? void 0 : F.SL) + "】" : ""), 1)];
    }), _: 1 })) : H("", true), l(T).visible("approveVersionsName") ? (w(), U(me, { key: "approveVersionsName", align: "center", label: "流程名称", "min-width": "120", prop: "approveVersionsName", "show-overflow-tooltip": "" })) : H("", true), l(T).visible("dataSerialNumber") ? (w(), U(me, { key: "dataSerialNumber", align: "center", label: "单据编号", "min-width": "200", prop: "dataSerialNumber", "show-overflow-tooltip": "" }, { default: p(({ row: { sourceRow: z } }) => [z.boolOperation || l(A)(z.componentName) ? (w(), Q("div", { key: 0, class: "text-clickable", onClick: Pi((F) => q(z, "detail"), ["stop"]) }, K(z.dataSerialNumber || "-"), 9, OEe)) : (w(), Q("div", kEe, K(z.dataSerialNumber || "-"), 1))]), _: 1 })) : H("", true), l(T).visible("subjoinMsg") && l(R) ? (w(), U(me, { key: "subjoinMsg", align: "center", label: "附加信息", "min-width": "220", prop: "subjoinMsg" }, { default: p(({ row: z }) => {
      var F;
      return [s(ge, { disabled: !((F = z.subjoinMsgList) != null && F.length), effect: "dark", placement: "top" }, { content: p(() => [C("span", { innerHTML: z.subjoinMsgStr }, null, 8, DEe)]), default: p(() => {
        var G;
        return [C("div", xEe, K((G = z.subjoinMsgList) == null ? void 0 : G.join(",")), 1)];
      }), _: 2 }, 1032, ["disabled"])];
    }), _: 1 })) : H("", true), l(T).visible("reviewStatus") ? (w(), U(me, { key: "reviewStatus", align: "center", label: "审批状态", "min-width": "80", prop: "reviewStatus", "show-overflow-tooltip": "" })) : H("", true), l(T).visible("flowArrivalTime") ? (w(), U(me, { key: "flowArrivalTime", align: "center", label: "节点流转日期", "min-width": "150", prop: "flowArrivalTime" })) : H("", true), l(T).visible("wmsApproveFlowDTO") ? (w(), U(me, { key: "wmsApproveFlowDTO", label: "审批流程", "min-width": "200", prop: "wmsApproveFlowDTO", "show-overflow-tooltip": "" }, { default: p(({ row: z }) => {
      var F, G, ie, ue;
      return [(F = z.wmsApproveFlowDTO) != null && F.tagColor ? (w(), U(Ie, { key: 0, width: 400, placement: "top", trigger: "click", onShow: (ne) => ye(z) }, { reference: p(() => {
        var ne;
        return [s(Le, { color: (ne = z.wmsApproveFlowDTO) == null ? void 0 : ne.tagColor, effect: "dark", style: { cursor: "pointer" } }, { default: p(() => {
          var te;
          return [Te(K((te = z.wmsApproveFlowDTO) == null ? void 0 : te.typeName), 1)];
        }), _: 2 }, 1032, ["color"])];
      }), default: p(() => [qe((w(), Q("div", UEe, [s(tl, { data: z.wmsApproveRecordFlowDTO }, null, 8, ["data"])])), [[J, z.loading]])]), _: 2 }, 1032, ["onShow"])) : H("", true), (G = z.wmsApproveFlowDTO) != null && G.tagColor ? (w(), Q("span", YEe, K((ie = z.lastApproverName) == null ? void 0 : ie.join("/")), 1)) : H("", true), (ue = z.wmsApproveFlowDTO) != null && ue.tagColor ? H("", true) : (w(), Q("span", KEe, "/"))];
    }), _: 1 })) : H("", true), l(T).visible("lastApprovalTime") ? (w(), U(me, { key: "lastApprovalTime", align: "center", label: "最后操作日期", "min-width": "130", prop: "lastApprovalTime", "show-overflow-tooltip": "" })) : H("", true), s(me, { align: "left", fixed: "right", label: "操作", "min-width": "170" }, { default: p(({ row: { sourceRow: z } }) => {
      var F, G, ie;
      return [!(x.includes(z.componentName) || z.componentName === l(at).Part_Approval.V) && z.boolCancel && ((F = l(c)) == null ? void 0 : F.id) === z.applicantId && z.boolOperation && z.componentName !== l(at).LEDGER_COLLECTION_AUDIT.V ? (w(), U(X, { key: 0, title: "确认撤销", onConfirm: (ue) => oe(z) }, { reference: p(() => [s(Se, { size: "default", type: "info" }, { default: p(() => [s(_o, { "icon-class": "wms-revoke" })]), _: 1 })]), _: 2 }, 1032, ["onConfirm"])) : H("", true), z.boolCancel && ((G = l(c)) == null ? void 0 : G.id) === z.applicantId && !z.boolOperation ? (w(), U(ge, { key: 1, class: "box-item", content: `请前往${z.approveSource === 2 && z.requestId ? "OA" : "APP"}撤销`, effect: "dark", placement: "top" }, { default: p(() => [s(Se, { disabled: true, size: "default", type: "info" }, { default: p(() => [s(_o, { "icon-class": "wms-APP" })]), _: 1 })]), _: 2 }, 1032, ["content"])) : H("", true), z.boolCheck && z.boolOperation ? (w(), U(Se, { key: 2, size: "default", type: "warning", onClick: Pi((ue) => j(z), ["stop"]) }, { default: p(() => [s(_o, { "icon-class": "wms-auditing" })]), _: 2 }, 1032, ["onClick"])) : H("", true), z.boolCheck && !z.boolOperation ? (w(), U(ge, { key: 3, class: "box-item", content: `请前往${z.approveSource === 2 && z.requestId ? "OA" : "APP"}审核`, effect: "dark", placement: "top" }, { default: p(() => [s(Se, { disabled: true, size: "default", type: "warning" }, { default: p(() => [s(_o, { "icon-class": "wms-APP" })]), _: 1 })]), _: 2 }, 1032, ["content"])) : H("", true), s(V_, { beforeToEdit: ae, data: z, "show-del": false, "show-detail": false, "show-edit": z.boolRewrite && ((ie = l(c)) == null ? void 0 : ie.id) === z.applicantId && z.inboundWay !== 2 }, null, 8, ["data", "show-edit"])];
    }), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[J, l(h).loading]]), s(td)]), _: 1 }, 8, ["modelValue", "before-close", "title"]), (w(), U(Ri(I.value), { modelValue: v.value, "onUpdate:modelValue": be[1] || (be[1] = (z) => v.value = z), ApprovalFlag: P.value, componentName: O.value.componentName, form: O.value, journalId: L.value, showBtn: false, submitType: N.value, onAuditSuccess: ce }, null, 40, ["modelValue", "ApprovalFlag", "componentName", "form", "journalId", "submitType"])), (w(), U(Ri(Y.value), { componentName: O.value.componentName, onSuccess: l(h).toQuery }, null, 40, ["componentName", "onSuccess"]))], 64);
  };
} }, jEe = ut(WEe, [["__scopeId", "data-v-2ee533ad"]]), FEe = () => {
  const e = jn(), o = () => {
    var r, E, y;
    const u = e.currentRoute.value.matched;
    for (const b of u) {
      const V = b.components.default;
      if (V && !((r = V.name) != null && r.toLowerCase().includes("layout")) && !((E = V.name) != null && E.toLowerCase().includes("navbar")) && !((y = V.name) != null && y.toLowerCase().includes("sidebar"))) return b.instances.default;
    }
    return null;
  };
  return { refreshCurrentPage: () => {
    var u;
    const c = o();
    c && ((u = c.exposed) != null && u.refresh ? c.exposed.refresh() : c.refresh ? c.refresh() : c.fetchData ? c.fetchData() : c.loadData && c.loadData());
  } };
}, zEe = { class: "right-menu-item hover-effect", style: { "padding-top": "5px", "padding-right": "7px" } }, BEe = { __name: "index", setup(e) {
  const o = Ht(), n = Z(false), c = Z(0), u = Z(0), { maxHeight: r } = Kt({ mainBox: ".switch-factory-dialog", extraBox: [".el-dialog__header", ".head-container"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, minHeight: 300, navbar: false, paginate: true, extraHeight: c.value + 120 }, n), E = Z([]), y = [["project", ["parse-project", { onlyShortName: true }]]], b = () => {
    n.value = false, pt(() => {
      var M;
      c.value = (M = document.querySelector("#navbar")) == null ? void 0 : M.offsetHeight, u.value = 100;
    });
  };
  async function V() {
    E.value = await H5();
  }
  return Ce(() => n.value, async () => {
    if (n.value) await V();
    else {
      const M = E.value.map((g) => g.id);
      await q5(M), await o.dispatch("approval_list/fetchRemindNumbers");
    }
  }), El(() => {
    b(), window.addEventListener("resize", b);
  }), (M, g) => {
    const S = ml, h = zn, T = vt, _ = Ve("common-table"), f = Ve("common-dialog");
    return w(), Q("div", null, [s(h, { max: 99, value: l(o).state.approval_list.remindNumbers }, { default: p(() => [C("div", zEe, [s(S, null, { default: p(() => [s(l(I6), { style: { width: "100%" }, onClick: g[0] || (g[0] = (m) => n.value = true) })]), _: 1 })])]), _: 1 }, 8, ["value"]), s(f, { modelValue: n.value, "onUpdate:modelValue": g[1] || (g[1] = (m) => n.value = m), modal: false, style: ri(`left:calc(100vw - 730px);top:${c.value + 10}px; margin: 0 `), "append-to-body": "", "custom-class": "switch-factory-dialog", "show-close": "", title: "提示", width: "700px" }, { default: p(() => [s(_, { ref: "tableRef", data: E.value, "data-format": y, "max-height": l(r), "highlight-current-row": "", "row-key": "id", style: { width: "100%" } }, { default: p(() => [s(T, { align: "center", label: "序号", type: "index", width: "60" }), s(T, { label: "提醒内容", "min-width": "100px", prop: "content", "show-overflow-tooltip": "" }), s(T, { label: "关联项目", "min-width": "140px", prop: "project", "show-overflow-tooltip": "" }), s(T, { label: "关联单据", "min-width": "140px", prop: "receipt.serialNumber", "show-overflow-tooltip": "" })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["modelValue", "style"])]);
  };
} };
const HEe = { class: "right-menu" }, qEe = { class: "right-menu-item hover-effect", style: { height: "65px" } }, GEe = { class: "right-menu-item hover-effect avatar-container avatar" }, QEe = { __name: "Navbar", setup(e) {
  const o = Ht(), n = jn(), { sidebar: c, menus: u, device: r, inventoryNotifyPerm: E, switchBackgroundColor: y, currentMenu: b, homePageShowConfig: V } = ka(["sidebar", "menus", "device", "inventoryNotifyPerm", "switchBackgroundColor", "currentMenu", "homePageShowConfig"]), M = Z(false), g = Z();
  Ce(() => b, () => {
    var R;
    g.value = (R = b.value) == null ? void 0 : R.redirect;
  }, { immediate: true, deep: true });
  function S(R) {
    return V.value ? !R.iframe : true;
  }
  function h() {
    o.dispatch("app/toggleSideBar");
  }
  function T() {
    M.value = true;
  }
  function _(R) {
    if (/^https?:\/\//i.test(R)) {
      let N = R;
      R.indexOf("/device") !== -1 && v2() && (N = R + v2()), window.location.href = N;
    } else n.push({ path: R });
  }
  El(() => {
    o.dispatch("approval_list/fetchApprovalNum"), setInterval(() => {
      o.dispatch("approval_list/fetchRemindNumbers");
    }, 6e4);
  });
  const { refreshCurrentPage: f } = FEe();
  function m() {
    f();
  }
  return (R, v) => {
    const N = em, P = HV, L = zn;
    return w(), Q(Qe, null, [C("div", { style: ri(l(y) ? "background: #e3e3e3" : ""), class: "navbar" }, [s(D1, { "is-active": l(c).opened, class: "hamburger-container", style: { padding: "0 15px" }, onToggleClick: h }, null, 8, ["is-active"]), s(P, { "default-active": g.value, class: "menus-container", mode: "horizontal", onSelect: _ }, { default: p(() => [(w(true), Q(Qe, null, ki(l(u), (O) => (w(), Q(Qe, { key: O.id }, [S(O) ? (w(), U(N, { key: 0, index: O.redirect }, { default: p(() => [s(_o, { "icon-class": O.icon }, null, 8, ["icon-class"]), Te(" " + K(O.name), 1)]), _: 2 }, 1032, ["index"])) : H("", true)], 64))), 128))]), _: 1 }, 8, ["default-active"]), C("div", HEe, [C("span", { class: "replica-edition" }, "复刻版"), l(r) !== "mobile" ? (w(), Q(Qe, { key: 0 }, [l(E) ? (w(), U(B7, { key: 0, class: "right-menu-item hover-effect" })) : H("", true), s(BEe, { class: "right-menu-item hover-effect" }), s(L, { max: 99, value: l(o).state.approval_list.approvalNum }, { default: p(() => [C("div", qEe, [s(_o, { "icon-class": "auditing", onClick: Pi(T, ["stop"]) })])]), _: 1 }, 8, ["value"])], 64)) : H("", true), C("div", GEe, [s(LN, { placement: "bottom" })])]), s(l(kN), { style: { height: "35px", "margin-left": "44px" } })], 4), s(jEe, { modelValue: M.value, "onUpdate:modelValue": v[0] || (v[0] = (O) => M.value = O), onClose: m }, null, 8, ["modelValue"])], 64);
  };
} }, ZEe = ut(QEe, [["__scopeId", "data-v-ebd41136"]]);
const JEe = (e) => {
  const o = Ht(), n = Ee(() => o.state.config.loaded.mesWarehouseConfig);
  if (n.value || o.dispatch("config/fetchMesWarehouseConfig"), e) {
    const c = Ce(n, (u) => {
      u && setTimeout(() => {
        e(), c();
      }, 0);
    }, { immediate: true });
  }
  return { mesWarehouseConfig: Ee(() => o.state.config.mesWarehouseConfig), loaded: n };
};
const XEe = ["src"], $Ee = { key: 1, class: "sidebar-title" }, eye = ["src"], tye = { key: 1, class: "sidebar-title" }, iye = { __name: "logo", props: { collapse: { type: Boolean, default: true } }, setup(e) {
  const o = e, { sidebarLogo: n, logo: c, title: u, menus: r, homePageShowConfig: E } = ka(["sidebarLogo", "title", "logo", "menus", "homePageShowConfig"]);
  function y() {
    const V = r.value.findIndex((M) => !M.iframe);
    return V === -1 ? "/iframe" : r.value[V].redirect;
  }
  const b = Ee(() => E.value ? "/home-page" : y());
  return (V, M) => {
    const g = Ve("router-link");
    return w(), Q("div", { class: Zt(["sidebar-logo-container", { collapse: e.collapse }]) }, [s($d, { name: "sidebarLogoFade" }, { default: p(() => [o.collapse ? (w(), U(g, { key: "collapse", class: "sidebar-logo-link", to: b.value }, { default: p(() => [l(n) ? (w(), Q("img", { key: 0, src: l(n), class: "sidebar-logo" }, null, 8, XEe)) : (w(), Q("h1", $Ee, K(l(u)), 1))]), _: 1 }, 8, ["to"])) : (w(), U(g, { key: "expand", class: "sidebar-logo-link", to: b.value }, { default: p(() => [l(n) ? (w(), Q("img", { key: 0, src: l(c), class: "sidebar-logo" }, null, 8, eye)) : (w(), Q("h1", tye, K(l(u)), 1))]), _: 1 }, 8, ["to"]))]), _: 1 })], 2);
  };
} }, aye = ut(iye, [["__scopeId", "data-v-d5365aba"]]), lye = { class: "system-menu-title" }, oye = { __name: "item", props: { icon: { type: String, default: "" }, title: { type: String, default: "" } }, setup(e) {
  const o = e;
  return (n, c) => {
    const u = _o;
    return w(), Q(Qe, null, [s(u, { "icon-class": o.icon }, null, 8, ["icon-class"]), C("span", lye, K(o.title), 1)], 64);
  };
} }, nye = ["href"], sye = { __name: "link", props: { to: { type: String, required: true } }, setup(e) {
  const o = e;
  return (n, c) => {
    const u = Ve("router-link");
    return l(am)(o.to) ? (w(), Q("a", { key: 0, href: o.to, target: "_blank", rel: "noopener" }, [xt(n.$slots, "default")], 8, nye)) : (w(), U(u, { key: 1, to: o.to }, { default: p(() => [xt(n.$slots, "default")]), _: 3 }, 8, ["to"]));
  };
} }, rye = { key: 0, class: "menu-wrapper" }, uye = { name: "SidebarItem" }, cye = Object.assign(uye, { props: { item: { type: Object, required: true }, isNest: { type: Boolean, default: false }, boolEnableWarehouse: { type: Boolean, default: false }, basePath: { type: String, default: "" } }, setup(e) {
  const o = e, { globalProject: n, currentMenu: c, globalProjectId: u, globalProContentBit: r } = ka(["globalProject", "currentMenu", "globalProjectId", "globalProContentBit"]), E = ["enclosureSandwichBoard", "enclosureProfiledPlate", "enclosurePressureBearingPlate", "enclosureTrussFloorPlate", "enclosureBending", "PlanArtifactTreeList", "PlanArtifactList", "PlanMachinePartList", "PlanAssemblyList", "PlanArtifactManifest", "PlanPartsManifest"], y = [{ name: "enclosureBending", no: Xi.BENDING.V }, { name: "enclosureTrussFloorPlate", no: Xi.TRUSS_FLOOR_PLATE.V }, { name: "enclosureSandwichBoard", no: Xi.SANDWICH_BOARD.V }, { name: "enclosurePressureBearingPlate", no: Xi.PRESSURE_BEARING_PLATE.V }, { name: "enclosureProfiledPlate", no: Xi.PROFILED_PLATE.V }, { name: "PlanArtifactTreeList", no: Xi.STRUCTURE.V }, { name: "PlanArtifactManifest", no: Xi.BRIDGE.V }], b = ["ProductProgress", "SelfMadeReceiving", "SendAndReceivingReport", "IssueRecord", "LaborManage", "InstallationManage", "SafetyQualityManage", "InstallReportConfig"], V = ["ManufWarehouseConfig", "ShipWarehouseManage", "ShipWarehouseManageInduction"], M = Z([]);
  Ce(() => n.value, (f) => {
    var m;
    if (A(f)) {
      const R = [], v = [];
      f.projectContentList && f.projectContentList.length > 0 && f.projectContentList.forEach((N) => {
        v.push(N);
      }), v.length > 0 && y.forEach((N) => {
        v.find((L) => Number(L.no) === N.no) && (R.push(N.name), N.no === Xi.STRUCTURE.V ? (n.value.mode !== ko.STRUCTURE.V && R.push("PlanAssemblyList"), R.push("PlanArtifactList", "PlanMachinePartList")) : N.no === Xi.BRIDGE.V && R.push("PlanPartsManifest"));
      }), ((m = n.value) == null ? void 0 : m.businessType) === xi.INSTALLATION.V && (b == null || b.forEach((N) => {
        R.push(N);
      })), M.value = E || R;
    } else M.value = [];
  }, { deep: true, immediate: true });
  const g = Ee(() => {
    var v;
    const f = !o.item.hidden, m = o.item.meta && c.value && c.value.id === o.item.meta.moduleId, R = true;
    return !o.boolEnableWarehouse && V.includes(o.item.name) || ((v = n.value) == null ? void 0 : v.businessType) === xi.MACHINING.V && b.includes(o.item.name) ? false : f && m && R;
  }), S = Ee(() => {
    const f = o.item, m = o.item.children || [];
    let R, v = false;
    const N = m.filter((P) => !P.hidden);
    return N.length === 1 && (R = N[0]), N.length === 0 && !v && (R = { ...f, path: "" }), R;
  }), h = Ee(() => {
    var f, m;
    return A(S.value) && !o.item.alwaysShow && !((m = (f = S.value) == null ? void 0 : f.children) != null && m.length);
  }), T = Ee(() => o.item.children ? o.item.children.some((f) => true) : false);
  function _(f) {
    var m;
    return (!f.productType || f.productType && f.productType & r.value) && (!f.projectMode || f.projectMode && f.projectMode & ((m = n.value) == null ? void 0 : m.mode));
  }
  return (f, m) => {
    const R = _o, v = Ve("sidebar-item", true);
    return g.value ? (w(), Q("div", rye, [h.value ? (w(), Q(Qe, { key: 0 }, [S.value.meta ? (w(), U(sye, { key: 0, to: l(ds)(e.basePath, S.value.path) }, { default: p(() => [e.item.name && E.indexOf(e.item.name) > -1 ? (w(), Q(Qe, { key: 0 }, [M.value.indexOf(e.item.name) > -1 ? (w(), U(l(em), { key: 0, index: l(ds)(e.basePath, S.value.path), class: Zt({ "submenu-title-noDropdown": !o.isNest }) }, { title: p(() => [Te(K(S.value.meta.title), 1)]), default: p(() => [s(R, { "icon-class": S.value.meta.icon || o.item.meta && o.item.meta.icon }, null, 8, ["icon-class"])]), _: 1 }, 8, ["index", "class"])) : H("", true)], 64)) : _(S.value.meta) ? (w(), U(l(em), { key: 1, index: l(ds)(e.basePath, S.value.path), class: Zt({ "submenu-title-noDropdown": !o.isNest }) }, { title: p(() => {
      var N;
      return [C("span", { style: ri({ "font-size": ((N = S.value.meta.title) == null ? void 0 : N.length) > 8 ? "12px" : "" }) }, K(S.value.meta.title), 5)];
    }), default: p(() => [s(R, { "icon-class": S.value.meta.icon || o.item.meta && o.item.meta.icon }, null, 8, ["icon-class"])]), _: 1 }, 8, ["index", "class"])) : H("", true)]), _: 1 }, 8, ["to"])) : H("", true)], 64)) : (w(), Q(Qe, { key: 1 }, [T.value && _(e.item.meta) ? (w(), U(l(C6), { key: 0, ref: "subMenu", index: l(ds)(e.basePath, o.item.path), "popper-append-to-body": "" }, { title: p(() => [o.item.meta ? (w(), U(oye, { key: 0, icon: o.item.meta.icon, title: o.item.meta.title }, null, 8, ["icon", "title"])) : H("", true)]), default: p(() => [(w(true), Q(Qe, null, ki(o.item.children, (N) => (w(), U(v, { key: N.path, "is-nest": true, item: N, "base-path": l(ds)(e.basePath, N.path), boolEnableWarehouse: o.boolEnableWarehouse, class: "nest-menu" }, null, 8, ["item", "base-path", "boolEnableWarehouse"]))), 128))]), _: 1 }, 8, ["index"])) : H("", true)], 64))])) : H("", true);
  };
} }), dye = { __name: "index", setup(e) {
  const { mesWarehouseConfig: o } = JEe(), n = eu(), c = Ct({ menuText: "#fff", menuActiveText: "#ffd04b", menuBg: "#545c64" }), { showSidebarLogo: u, routes: r, sidebar: E } = ka(["showSidebarLogo", "routes", "sidebar"]), y = Ee(() => {
    const { meta: V, path: M } = n;
    return V.activeMenu ? V.activeMenu : M;
  }), b = Ee(() => !E.value.opened);
  return (V, M) => (w(), Q("div", { class: Zt({ "has-logo": l(u) }) }, [l(u) ? (w(), U(aye, { key: 0, collapse: b.value }, null, 8, ["collapse"])) : H("", true), s(l(P6), { "wrap-class": "scrollbar-wrapper" }, { default: p(() => [s(l(HV), { "active-text-color": c.menuActiveText, "background-color": c.menuBg, collapse: b.value, "default-active": y.value, "text-color": c.menuText, "unique-opened": false, "collapse-transition": "", mode: "vertical" }, { default: p(() => [(w(true), Q(Qe, null, ki(l(r), (g) => (w(), U(l(cye), { key: g.path, item: g, "base-path": g.path, boolEnableWarehouse: l(o).boolEnableWarehouse }, null, 8, ["item", "base-path", "boolEnableWarehouse"]))), 128))]), _: 1 }, 8, ["active-text-color", "background-color", "collapse", "default-active", "text-color"])]), _: 1 })], 2));
} };
const mye = { __name: "watermark", setup(e) {
  const { user: o, watermark: n } = ka(["user", "watermark"]), c = Z(null);
  let u = null;
  Ce(() => n.value.boolEnableWatermark, () => {
    y();
  });
  const r = (V) => V * (96 / 25.4), E = Ee(() => {
    const V = document.createElement("canvas"), M = window.devicePixelRatio || 1, g = r(n.value.fontSize) * M, S = r(n.value.spacing) * M;
    V.width = S, V.height = S;
    const h = V.getContext("2d");
    return h.font = `${g}px Arial`, h.fillStyle = `rgba(128, 128, 128, ${n.value.transparency})`, h.textAlign = "center", h.textBaseline = "middle", h.translate(V.width / 2, V.height / 2), h.rotate(Math.PI / 180 * n.value.angle), h.fillText(o.value.name, 0, 0), n.value.boolEnableWatermark ? `url(${V.toDataURL("image/png")})` : "";
  }), y = () => {
    c.value && (c.value.style.backgroundImage = E.value, c.value.style.backgroundRepeat = "repeat", c.value.style.width = "100%", c.value.style.height = "100%", c.value.style.position = "fixed", c.value.style.top = 0, c.value.style.left = 0, c.value.style.zIndex = 2147483647);
  }, b = (V) => {
    V.forEach((M) => {
      const g = M.removedNodes.length > 0, S = M.type === "attributes" && (M.attributeName === "style" || M.attributeName === "class");
      (g || S) && setTimeout(() => {
        y(), c.value && (c.value.className = "watermark-container", c.value.innerHTML = "");
      }, 10);
    });
  };
  return El(() => {
    y(), u = new MutationObserver(b), u.observe(c.value, { attributes: true, childList: true, subtree: true, attributeFilter: ["style", "class"] });
  }), Ym(() => {
    u == null || u.disconnect();
  }), Dt(y), (V, M) => (w(), Q("div", { ref_key: "watermarkContainerRef", ref: c, class: "watermark-container", style: { width: "100%", height: "100%", position: "fixed", "z-index": "2147483647", "pointer-events": "none" } }, null, 512));
} }, pye = ut(mye, [["__scopeId", "data-v-6a488d87"]]), { body: hye } = document, fye = 992, gye = { watch: { $route(e) {
  this.device === "mobile" && this.sidebar.opened && _e.dispatch("app/closeSideBar", { withoutAnimation: false });
} }, beforeMount() {
  window.addEventListener("resize", this.$_resizeHandler, { passive: false });
}, beforeDestroy() {
  window.removeEventListener("resize", this.$_resizeHandler);
}, mounted() {
  this.$_isMobile() && (_e.dispatch("app/toggleDevice", "mobile"), _e.dispatch("app/closeSideBar", { withoutAnimation: true }));
}, methods: { $_isMobile() {
  return hye.getBoundingClientRect().width - 1 < fye;
}, $_resizeHandler() {
  if (!document.hidden) {
    const e = this.$_isMobile();
    _e.dispatch("app/toggleDevice", e ? "mobile" : "desktop"), e && _e.dispatch("app/closeSideBar", { withoutAnimation: true });
  }
} } };
const Eye = { name: "Layout", components: { Watermark: pye, AppMain: cw, Navbar: ZEe, Sidebar: dye }, mixins: [gye], computed: { ...O6({ sidebar: (e) => e.app.sidebar, device: (e) => e.app.device, showSettings: (e) => e.settings.showSettings, fixedHeader: (e) => e.settings.fixedHeader, switchBackgroundColor: (e) => e.settings.switchBackgroundColor }), classObj() {
  return { hideSidebar: !this.sidebar.opened, openSidebar: this.sidebar.opened, withoutAnimation: this.sidebar.withoutAnimation, mobile: this.device === "mobile" };
} }, methods: { handleClickOutside() {
  this.$store.dispatch("app/closeSideBar", { withoutAnimation: false });
} } }, yye = { class: "main-container" };
function Tye(e, o, n, c, u, r) {
  const E = Ve("watermark"), y = Ve("sidebar"), b = Ve("navbar"), V = Ve("app-main");
  return w(), Q("div", { class: Zt([r.classObj, "app-wrapper"]), style: ri(e.switchBackgroundColor ? "background: #ebebeb" : "") }, [s(E), e.device === "mobile" && e.sidebar.opened ? (w(), Q("div", { key: 0, class: "drawer-bg", onClick: o[0] || (o[0] = (...M) => r.handleClickOutside && r.handleClickOutside(...M)) })) : H("", true), s(y, { class: "sidebar-container" }), C("div", yye, [C("div", { id: "navbar", class: Zt({ "fixed-header": e.fixedHeader }) }, [s(b, { ref: "navberRef" }, null, 512)], 2), s(V)])], 6);
}
const ac = ut(Eye, [["render", Tye], ["__scopeId", "data-v-682bee16"]]), E2 = [{ path: "/home-page", component: () => d(() => import("./index-4ecafa08.js"), ["static/js/index-4ecafa08.js", "static/js/index-a798e05d.js", "static/js/show-dialog-654b4e12.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/css/show-dialog-25c128b0.css", "static/css/index-b58bac34.css", "static/js/system-app-94508909.js", "static/js/home-card-head-ee3bbb36.js", "static/js/home-page-66a3681d.js", "static/css/system-app-261ca187.css", "static/js/third-app-9e3bc5aa.js", "static/js/common-09583abc.js", "static/css/third-app-d289e9c4.css", "static/js/index-ee87f42a.js", "static/js/schedule-dialog-15c8f5ae.js", "static/css/el-time-picker-7e0a570c.css", "static/css/index-95da8c2b.css", "static/js/index-439aaf2c.js", "static/js/notification-announcement-a0e50fbd.js", "static/js/add-dialog-afcf71cd.js", "static/js/detail-dialog-044ab420.js", "static/js/list-drawer-82f301ab.js", "static/css/index-c9dd4174.css", "static/js/personal-information-29d8834c.js", "static/css/personal-information-78b73dca.css", "static/js/index-92735c53.js", "static/js/add-dialog-74c8995d.js", "static/js/PicUpload-8580ccfc.js", "static/css/PicUpload-3e8367bf.css", "static/css/index-2ca4a92f.css", "static/js/index-f37b0bea.js", "static/js/company-dynamics-34941552.js", "static/js/add-dialog-dcfa4d6f.js", "static/js/detail-dialog-d43af62f.js", "static/js/list-drawer-37a2c419.js", "static/css/index-94cc905b.css", "static/js/index-865c6fef.js", "static/js/enterprise-cloud-disk-7c8bf938.js", "static/js/add-dialog-4306a186.js", "static/js/list-drawer-0ac04dd1.js", "static/js/detail-dialog-61415ee6.js", "static/css/index-f47957b2.css", "static/js/enterprise-information-0f51625a.js", "static/css/index-74faca9b.css"]), hidden: true }, { path: "/redirect", component: ac, hidden: true, children: [{ path: "/redirect/:path*", component: () => d(() => import("./index-68b40604.js"), []) }] }, { path: "/login", component: () => d(() => import("./index-c401283b.js"), ["static/js/index-c401283b.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-e7d40d16.js", "static/js/forgot-password-81b6a378.js", "static/css/forgot-password-b1ec7350.css", "static/css/index-6869eef4.css", "static/js/index-bb5aa7bc.js", "static/css/index-a96d1af9.css", "static/js/index-aa94c654.js", "static/css/index-574d2a9c.css", "static/css/index-45d05b37.css"]), meta: { projectType: 0 }, hidden: true }, { path: "/", redirect: "/home-page", hidden: true }, { path: "" + er.QR_SCAN_ARTIFACT_TASK, component: () => d(() => import("./artifact-92267f96.js"), ["static/js/artifact-92267f96.js", "static/js/black-bg-05289b55.js", "static/js/qr-scan-info-657de68e.js", "static/js/externalRequest-4308f5b0.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-f09320a8.js", "static/css/artifact-3aee88fd.css"]), meta: { title: "构件信息" }, hidden: true }, { path: "/trace", component: () => d(() => import("./index-60e5844f.js"), ["static/js/index-60e5844f.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/qr-scan-info-657de68e.js", "static/js/externalRequest-4308f5b0.js", "static/js/drawing-preview-fullscreen-dialog-60155503.js", "static/js/bimfaceAPI-c2661893.js", "static/js/model-0ac957f7.js", "static/css/drawing-preview-fullscreen-dialog-b7fd0a79.css", "static/js/bim-model-view-dbf77a11.js", "static/js/index-d6a37d29.js", "static/css/index-9d794dc3.css", "static/js/use-chart-59e4b63c.js", "static/js/index-18acf776.js", "static/css/bim-model-view-bc5817db.css", "static/js/index-f09320a8.js", "static/css/index-18168317.css"]), meta: { title: "溯源查询系统" }, hidden: true }, { path: "" + er.QR_SCAN_ENCLOSURE_TASK, component: () => d(() => import("./enclosure-7c052160.js"), ["static/js/enclosure-7c052160.js", "static/js/black-bg-05289b55.js", "static/js/qr-scan-info-657de68e.js", "static/js/externalRequest-4308f5b0.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-f09320a8.js", "static/css/enclosure-2fe94f9e.css"]), meta: { title: "围护信息" }, hidden: true }, { path: "" + er.QR_SCAN_AUXILIARY_MATERIAL, component: () => d(() => import("./auxiliary-material-5673fa40.js"), ["static/js/auxiliary-material-5673fa40.js", "static/js/black-bg-05289b55.js", "static/js/qr-scan-info-657de68e.js", "static/js/externalRequest-4308f5b0.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/css/auxiliary-material-a00010be.css"]), meta: { title: "配套件信息" }, hidden: true }, { path: FA, component: () => d(() => import("./index-4d9d2740.js"), ["static/js/index-4d9d2740.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/bim-model-view-dbf77a11.js", "static/js/bimfaceAPI-c2661893.js", "static/js/model-0ac957f7.js", "static/js/index-d6a37d29.js", "static/css/index-9d794dc3.css", "static/js/drawing-preview-fullscreen-dialog-60155503.js", "static/css/drawing-preview-fullscreen-dialog-b7fd0a79.css", "static/js/use-chart-59e4b63c.js", "static/js/index-18acf776.js", "static/css/bim-model-view-bc5817db.css", "static/css/index-b49641be.css"]), meta: { title: "模型" }, hidden: true, beforeEnter(e, o, n) {
  if (!or()) {
    const c = e.query.token;
    JV(c);
  }
  if (!yn()) {
    const c = e.query.requestUrl;
    XV(c);
  }
  n();
} }, { path: "/personal", component: ac, hidden: true, redirect: "noRedirect", children: [{ path: "center", component: () => d(() => import("./index-4c2f92d4.js"), ["static/js/index-4c2f92d4.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/update-pwd-c7b0adb1.js", "static/js/password-validation-8d186430.js", "static/css/update-pwd-f82155bd.css", "static/css/index-42ac60dd.css"]), name: "个人中心", meta: { title: "个人中心" } }] }, { path: "/iframe", component: ac, hidden: true, redirect: "noRedirect", children: [{ path: "", component: () => d(() => import("./index-03288312.js"), ["static/js/index-03288312.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css"]), name: "iframe中转", meta: { title: "" } }] }, { path: "/external/model", component: () => d(() => import("./index-9d9f723f.js"), ["static/js/index-9d9f723f.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/bimfaceAPI-c2661893.js", "static/css/index-ba18173d.css"]), name: "ExternalModel", meta: { title: "模型展示" }, hidden: true }, { path: "/auth-redirect", component: () => d(() => import("./auth-redirect-d670e2ec.js"), []), hidden: true }, { path: "/401", component: () => d(() => import("./401-1fcb6863.js"), ["static/js/401-1fcb6863.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/css/401-ee0591c2.css"]), hidden: true }, { path: "/404", component: () => d(() => import("./404-9964631f.js"), ["static/js/404-9964631f.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/css/404-693735e5.css"]), hidden: true }], As = qV({ history: GV(), routes: E2 }), i6 = () => {
  const e = qV({ history: GV(), routes: E2 });
  As.matcher = e.matcher;
}, Sd = (e = [], o) => {
  e.forEach((n) => {
    o ? As.addRoute(o, n) : As.addRoute(n), A(n.name) && A(n.children) && Sd(n.children, n.name);
  });
};
// Homepage configuration is evaluated by the authenticated session guard after user info loads.
console.log("当前业财版本:", {}.VITE_FINANCE_VERSION);
const _ye = { manufacture: { ledger: { path: "/contract/standing-book", name: "StandingBook", component: "Layout", hidden: false, alwaysShow: true, redirect: "/contract/standing-book/list-manufacture", meta: { title: "项目台账", icon: "contract2", noCache: true }, children: [{ path: "list-manufacture", name: "ListManufacture", hidden: false, component: "/contract/standing-book/self-healing/index", meta: { title: "收入台账", icon: "contract2", noCache: true } }, { path: "supplier-manufacture", name: "SupplierManufacture", hidden: false, component: "/contract/standing-book/supplier/index", meta: { title: "支出台账", icon: "contract2", noCache: true } }, { name: "ScrapLedger", path: "scrap-ledger", hidden: false, component: "/contract/scrap-ledger/index", meta: { title: "废料台账", icon: "menu-list-ScrapLedger", noCache: true } }] } }, group_joint: { ledger: { path: "/contract/standing-book", name: "StandingBook", component: "Layout", hidden: false, alwaysShow: true, redirect: "/contract/standing-book/stair-unit", meta: { title: "项目台账", icon: "contract2", noCache: true }, children: [{ path: "stair-unit", name: "StairUnit", hidden: false, alwaysShow: false, redirect: "/contract/standing-book/stair-unit/self-healing/index", meta: { title: "一级单位", icon: "contract2", noCache: true }, children: [{ path: "inner-package", name: "StairUnitInnerPackage", hidden: false, component: "/contract/standing-book/inner-package/index", meta: { title: "内包(合营)项目", icon: "contract2", noCache: true } }, { path: "interior", name: "Interior", hidden: false, component: "/contract/standing-book/interior/index", meta: { title: "內包(合营)项目-v2", icon: "contract2", noCache: true } }, { path: "self", name: "StairUnitSelf", hidden: false, alwaysShow: false, redirect: "/contract/standing-book/stair-unit/self-healing/index", meta: { title: "自营项目", icon: "contract2", noCache: true }, children: [{ path: "index", name: "Index", hidden: false, component: "/contract/standing-book/self-healing/index", meta: { title: "项目台账", icon: "contract2", noCache: true } }, { path: "supplier", name: "Supplier", hidden: false, component: "/contract/standing-book/supplier/index", meta: { title: "支出台账", icon: "contract2", noCache: true } }] }, { path: "grant-extension", name: "GranTextEnSion", hidden: false, component: "/contract/grant-extension/index", meta: { title: "授信管理", icon: "contract2", noCache: true } }] }, { path: "second-unit", name: "SecondUnit", hidden: false, alwaysShow: true, redirect: "/contract/standing-book/second-unit/self", meta: { title: "二级单位", icon: "contract2", noCache: true }, children: [{ path: "self", name: "SecondUnitSelf", hidden: false, component: "/contract/standing-book/second-unit/self-healing/index", meta: { title: "收入台账", icon: "contract2", noCache: true } }, { path: "supplier", name: "SecondUnitSupplier", hidden: false, component: "/contract/standing-book/second-unit/supplier/index", meta: { title: "支出台账", icon: "contract2", noCache: true } }, { name: "FabricatingCostStatistics", path: "fabricating-cost-statistics", hidden: false, component: "/contract/fabricating-cost-statistics/index", meta: { title: "制造成本统计", icon: "project", noCache: true } }, { name: "FabricatingCostStatistics", path: "fabricating-cost-statistics", hidden: false, component: "/contract/scrap-ledger/index", meta: { title: "废料台账", icon: "contract2", noCache: true } }] }] } }, group: { ledger: { path: "/contract/standing-book", name: "StandingBook", component: "Layout", hidden: false, alwaysShow: true, redirect: "/contract/standing-book/stair-unit", meta: { title: "项目台账", icon: "contract2", noCache: true }, children: [{ path: "stair-unit", name: "StairUnit", hidden: false, alwaysShow: false, redirect: "/contract/standing-book/stair-unit/self-healing/index", meta: { title: "一级单位", icon: "contract2", noCache: true }, children: [{ path: "self", name: "StairUnitSelf", hidden: false, alwaysShow: false, redirect: "/contract/standing-book/stair-unit/self-healing/index", meta: { title: "项目管理", icon: "contract2", noCache: true }, children: [{ path: "index", name: "Index", hidden: false, component: "/contract/standing-book/self-healing/index", meta: { title: "收入台账", icon: "contract2", noCache: true } }, { path: "supplier", name: "Supplier", hidden: false, component: "/contract/standing-book/supplier/index", meta: { title: "支出台账", icon: "contract2", noCache: true } }] }] }, { path: "second-unit", name: "SecondUnit", hidden: false, alwaysShow: true, redirect: "/contract/standing-book/second-unit/self", meta: { title: "二级单位", icon: "contract2", noCache: true }, children: [{ path: "self", name: "SecondUnitSelf", hidden: false, component: "/contract/standing-book/second-unit/self-healing/index", meta: { title: "收入台账", icon: "contract2", noCache: true } }, { path: "supplier", name: "SecondUnitSupplier", hidden: false, component: "/contract/standing-book/second-unit/supplier/index", meta: { title: "支出台账", icon: "contract2", noCache: true } }, { name: "FabricatingCostStatistics", path: "fabricating-cost-statistics", hidden: false, component: "/contract/fabricating-cost-statistics/index", meta: { title: "制造成本统计", icon: "project", noCache: true } }, { path: "scrap-ledger", name: "ScrapLedger", hidden: false, component: "/contract/scrap-ledger/index", meta: { title: "废料台账", icon: "menu-list-ScrapLedger", noCache: true } }] }] } } };
var VV;
const S0t = ((VV = _ye[{}.VITE_FINANCE_VERSION]) == null ? void 0 : VV.ledger) || {};
zm.configure({ showSpinner: false });
const bye = ["/login", "/external/model", "/auth-redirect", "/mobile-model-preview", "/trace", "" + er.QR_SCAN_ARTIFACT_TASK, "" + er.QR_SCAN_ENCLOSURE_TASK, "" + er.QR_SCAN_AUXILIARY_MATERIAL];
