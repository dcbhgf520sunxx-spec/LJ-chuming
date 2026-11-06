function Tz(e, o) {
  for (const n in e) e[n] = void 0;
  for (const n in o) e[n] = o[n];
}
function Iv(e, o, n = Ms.TYPE.normal) {
  if (!e.isRegister) return false;
  const c = o || e.form;
  try {
    return ci.set(`${Ms.KEY_PREFIX}_${e.key}`, { type: n, content: c }, e.expired), true;
  } catch (u) {
    return console.log("缓存错误信息", u), console.log("缓存", c), false;
  }
}
function Nb(e) {
  ci.remove(`${Ms.KEY_PREFIX}_${e.key}`);
}
function Lb(e, o) {
  if (!e.isRegister) return;
  o.status.cu > 0 && !tu(e.initForm, e.form) && Iv(e, null, Ms.TYPE.browserClose);
}
function _z(e) {
  return ci.get(`${Ms.KEY_PREFIX}_${e}`);
}
const Ea = {};
function Pa(e, o, n, c = true) {
  const u = Vz(e);
  return Object.seal(u), c ? bz(u, o, n) : { crud: u };
}
function bz(e, o, n) {
  const c = Mn(), u = e.registerVM(Ea.VM_TYPE.FORM, c, 2);
  u.formRef = o, e.ref.form = o, e.resetForm();
  let r = {};
  return e.formStore && (r = gz(e.formStoreKey, e, u.FORM, { useDraftCallback: e.useDraftCallback, clearDraftCallback: e.clearDraftCallback })), El(() => {
    e.toEdit(n);
  }), bl(() => {
    e.unregisterVM(c), delete e.ref.form;
  }), Ym(() => {
    e.init();
  }), yi("cu", e), yi("permission", e.permission), yi("form", e.form), { FORM: u.FORM, cu: e, form: e.form, ADD_FORM: r };
}
function Wi(e = {}) {
  const o = ft("cu"), n = Mn(), c = o.registerVM(Ea.VM_TYPE.OTHER, n);
  return bl(() => {
    o.unregisterVM(n);
  }), { FORM: c.FORM, cu: o, form: o.form };
}
function Vz(e) {
  const o = wz(), n = Nz(o, e), c = Sz(n), u = uo.cloneDeep(c), r = Ct(Object.assign({}, u));
  return vz(r), Rz(r), Mz(r), Az(r, c), r;
}
function wz() {
  return { title: "", form: {}, defaultForm: () => {
  }, formStoreKey: "", formStore: false, useDraftCallback: null, clearDraftCallback: null, requiredSubmitField: [], submitResult: null, time: 50, api: null, props: {}, permission: [], debug: false };
}
function Sz(e) {
  return { ...e, initOptions: e, dataStatus: {}, msg: { submit: "提交成功" } };
}
function vz(e, o) {
  Object.assign(e, { vms: [], ref: {}, tableColumns: {}, status: { edit: Ea.STATUS.PREPARED } });
}
function Rz(e) {
  const o = () => {
    e.notify(e.msg.submit, Ea.NOTIFICATION_TYPE.SUCCESS);
  }, n = async (E) => {
    e.resetForm(A(E) ? JSON.parse(JSON.stringify(E)) : void 0), await Po(e, Ea.HOOK.beforeToEdit, e.form) && await Po(e, Ea.HOOK.beforeToCU, e.form) && (e.submitResult = null, await Po(e, Ea.HOOK.afterToEdit, e.form), await Po(e, Ea.HOOK.afterToCU, e.form));
  }, c = async () => {
    r() && await Po(e, Ea.HOOK.beforeValidateCU) && e.ref.form.validate(async (E) => {
      E && await Po(e, Ea.HOOK.afterValidateCU) && e.status.edit === Ea.STATUS.PREPARED && u();
    });
  }, u = async () => {
    if (await Po(e, Ea.HOOK.beforeSubmit)) try {
      e.status.edit = Ea.STATUS.PROCESSING;
      const E = await e.submitFormFormat(uo.cloneDeep(e.form));
      e.submitResult = await e.api(E), e.submitResult.code === 40206 ? (e.status.edit = Ea.STATUS.PREPARED, await Po(e, Ea.HOOK.afterEditError)) : (await Po(e, Ea.HOOK.afterEditSuccess), e.status.edit = Ea.STATUS.PREPARED, e.submitSuccessNotify(), e.resetForm(), e.ref.form && pt(() => {
        e.ref.form.clearValidate();
      }), await Po(e, Ea.HOOK.afterSubmit));
    } catch (E) {
      console.log("编辑", E), e.status.edit = Ea.STATUS.PREPARED, await Po(e, Ea.HOOK.afterEditError);
    }
  }, r = () => !e.requiredSubmitField.some((y) => e.form[y] === null || e.form[y] === void 0);
  Object.assign(e, { submitSuccessNotify: o, toEdit: n, submit: c });
}
function Mz(e, o) {
  Object.assign(e, { resetForm: (y) => {
    const b = e.ref.form;
    b && b.resetFields();
    const V = y || (typeof e.defaultForm == "object" ? JSON.parse(JSON.stringify(e.defaultForm)) : e.defaultForm()), M = e.form;
    for (const g in M) M[g] = void 0;
    for (const g in V) M[g] = V[g];
    b && pt(() => {
      b.clearValidate();
    });
  }, validateField: (y) => {
    e.ref.form.validateField(y);
  }, submitFormFormat: (y) => y, notify: (y, b = Ea.NOTIFICATION_TYPE.INFO) => {
    Di({ title: y, type: b, duration: 2500 });
  }, updateProp: (y, b) => {
    e.props[y] = b;
  } });
}
function Az(e, o) {
  Object.assign(e, { init: () => {
    Object.assign(e, uo.cloneDeep(o)), e.status.edit = Ea.STATUS.PREPARED;
  }, registerVM: (E, y, b = -1) => {
    const V = { uid: y.uid, uuid: `${y.uid}_${(/* @__PURE__ */ new Date()).getTime()}_${e.vms.length}`, type: E, vm: y, FORM: { HOOK: {}, STATUS: Ea.STATUS, NOTIFICATION_TYPE: Ea.NOTIFICATION_TYPE } };
    return b < 0 ? e.vms.push(V) : (e.vms.length = Math.max(e.vms.length, b), e.vms.splice(b, 1, V)), V;
  }, unregisterVM: (E) => e.vms.splice(e.vms.findIndex((b) => b && b.uid === E.uid), 1), findVM: (E, y = "type") => e.vms.find((b) => b && b[y] === E).vm });
}
async function Po(e, o) {
  e.debug && console.log("callVmHook: " + o);
  let n = true;
  const c = [e];
  for (let u = 2; u < arguments.length; ++u) c.push(arguments[u]);
  for (const u of e.vms) u && u.FORM.HOOK[o] && (n = await u.FORM.HOOK[o].apply(u, c) !== false && n);
  return n;
}
function Nz(e, o) {
  const n = { ...e };
  return Object.keys(e).forEach((c) => {
    Object.prototype.hasOwnProperty.call(o, c) && (n[c] = o[c]);
  }), n;
}
Ea.VM_TYPE = { FORM: "form", OTHER: "other" };
Ea.STATUS = { NORMAL: 0, PREPARED: 1, PROCESSING: 2 };
Ea.NOTIFICATION_TYPE = { SUCCESS: "success", WARNING: "warning", INFO: "info", ERROR: "error" };
Ea.HOOK = { beforeToEdit: "beforeToEdit", afterToEdit: "afterToEdit", beforeToCU: "beforeToCU", afterToCU: "afterToCU", beforeValidateCU: "beforeValidateCU", afterValidateCU: "afterValidateCU", beforeSubmit: "beforeSubmit", afterSubmit: "afterSubmit", afterEditError: "afterEditError", afterEditSuccess: "afterEditSuccess" };
const Lz = { class: "requisitions-application-footer" }, Iz = { class: "total-box" }, Cz = { class: "total-name" }, Pz = { class: "total-item" }, Oz = { __name: "common-footer", props: { permission: { type: Array, default: void 0 }, totalName: { type: String, default: "合计" }, btnName: { type: String, default: "确认并提交" }, unit: { type: String, default: "" }, totalValue: { type: [Number, String], default: 0 }, showTotal: { type: Boolean, default: true }, isSubmit: { type: Boolean, default: false } }, emits: ["submit"], setup(e, { emit: o }) {
  const n = o, c = e, { cu: u, FORM: r } = Wi(), E = Ht();
  async function y() {
    if (c.isSubmit) try {
      u.form.clickTime = E.state.config.getTreeClickTime, await u.submit(), n("submit");
    } catch (b) {
      console.log("入库表单提交", b);
    }
    else n("submit");
  }
  return (b, V) => {
    const M = Ve("common-button");
    return w(), Q("div", Lz, [C("div", Iz, [c.showTotal ? (w(), Q(Qe, { key: 0 }, [C("div", Cz, K(c.totalName), 1), C("div", Pz, K(`${c.totalValue || 0} ${c.unit || ""}`), 1)], 64)) : H("", true)]), C("div", null, [xt(b.$slots, "calculator", {}, void 0, true), s(M, { loading: l(u).status.edit === l(r).STATUS.PROCESSING, size: "default", style: { "margin-left": "10px" }, type: "primary", onClick: y }, { default: p(() => [Te(K(e.btnName), 1)]), _: 1 }, 8, ["loading"])])]);
  };
} }, q_ = ut(Oz, [["__scopeId", "data-v-b1b0a77e"]]), kz = Object.freeze(Object.defineProperty({ __proto__: null, default: q_ }, Symbol.toStringTag, { value: "Module" }));
function Cv(e) {
  return W({ url: "/api/sys/approve-process", method: "get", params: e, cancelKey: false });
}
function Dz(e) {
  return W({ url: "/api/sys/approve-process", method: "post", data: e });
}
function xz(e) {
  return W({ url: "/api/sys/approve-process", method: "put", data: e });
}
function Tft(e) {
  return W({ url: "/api/sys/approve-process/code", method: "get", params: e });
}
function Uz(e) {
  return W({ url: "/api/sys/approve-process", method: "delete", data: e });
}
const _ft = { get: Cv, add: Dz, edit: xz, del: Uz }, cn = (e) => {
  const o = Ht(), n = Ee(() => o.state.wms.loaded.steelDensityCfg);
  if (n.value || o.dispatch("wms/fetchSteelDensityCfg"), e) {
    const c = Ce(n, (u) => {
      u && setTimeout(() => {
        e(), c();
      }, 0);
    }, { immediate: true });
  }
  return { steelDensityCfg: Ee(() => o.state.wms.steelDensityCfg), loaded: Ee(() => o.state.wms.loaded.steelDensityCfg) };
}, Pv = (e, o) => {
  const n = Ht(), c = Ee(() => n.state.config.loaded.enclosureList);
  if (c.value || n.dispatch("config/fetchEnclosureList", o), e) {
    const u = Ce(c, (r) => {
      r && setTimeout(() => {
        e(), u();
      }, 0);
    }, { immediate: true });
  }
  return { enclosureDictList: Ee(() => n.state.config.enclosureList), loaded: Ee(() => n.state.config.loaded.enclosureList) };
};
const Yz = { class: "table-remark" }, Kz = { style: { "padding-bottom": "40px" } }, Wz = { __name: "confirm-dialog", props: { modelValue: { type: Boolean, default: false }, isManufactured: { type: Boolean, default: false } }, emits: ["saveSuccess", "update:modelValue", "manuf-del", "manuf-del-all"], setup(e, { emit: o }) {
  const n = Ht(), c = o, u = e, r = Z(), E = Z([]), { enclosureDictList: y } = Pv(), b = Z([...Da]), { visible: V, handleClose: M } = Ta({ emit: c, props: u }), { cu: g, form: S, FORM: h } = Wi(), T = { arrivalTime: [{ required: true, message: "请选择需求完成日期", trigger: "change" }] }, _ = /* @__PURE__ */ new Map([["arrivalTime", "同上"]]), { tableValidate: f, cleanUpData: m, wrongCellMask: R } = ui({ rules: T, ditto: _ }), { steelDensityCfg: v } = cn(), { maxHeight: N } = Kt({ mainBox: ".requisitions-application-preview", extraBox: [".el-dialog__header", ".footer", ".table-remark"], wrapperBox: [".el-dialog__body"], navbar: false, clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, V);
  function P({ row: B, rowIndex: q }) {
    var ae, j;
    if ((j = (ae = g == null ? void 0 : g.submitResult) == null ? void 0 : ae.data) != null && j.includes(B.classifyId)) return { backgroundColor: "#ffdede" };
  }
  Ce(() => u.modelValue, (B) => {
    E.value = [], r.value = void 0, B && L(), u.isManufactured && S.list.forEach((q, ae) => {
      ae !== 0 && (q.arrivalTime = "同上");
    });
  }, { immediate: true }), g.submitFormFormat = async (B) => (B.list = m(B.list), B.attachmentIds = B.attachments ? B.attachments.map((q) => q.id) : void 0, u.isManufactured ? B.list = B.list.map((q) => ({ artifactEnclosureId: B.finishedProductType === Fa.STRUC_MANUFACTURED.V ? q.productId : q.id, basicClass: B.finishedProductType === Fa.STRUC_MANUFACTURED.V ? on.STRUC_MANUFACTURED.V : on.ENCL_MANUFACTURED.V, arrivalTime: q.arrivalTime, quantity: q.quantity })) : B.list = await Ut(B.list, { toSmallest: true, toNum: true }), B), h.HOOK.beforeSubmit = async () => {
    var q;
    if (await n.dispatch("wms/fetchSteelDensityCfg"), S.dataStatus === rl.PASSED.V && (g.api = y5), S.dataStatus === rl.UNDER_APPROVAL.V && (g.api = E5), S.materialType & ct.STEEL.V) {
      const ae = [];
      let j = [];
      if ((q = S.list) == null || q.forEach((le) => {
        (le.basicClass === Pe.STEEL_PLATE.V || le.basicClass === Pe.STEEL_COIL.V) && le.steelDensity !== v.value[le.classifyId] && (ae.push(`<div>【${le.classifyName}】最新设置密度与该单据创建时设置密度不一致！！！</div>`), le.steelDensity = v.value[le.classifyId]);
      }), j = Array.from(new Set(ae)), j.length) {
        const le = j.join("");
        ot({ message: le, dangerouslyUseHTMLString: true, type: "warning", duration: 5e3 });
      }
    }
    const { validResult: B } = f(S.list);
    if (!B) return !u.isManufactured && r.value && (r.value = void 0), false;
  }, h.HOOK.afterSubmit = async () => {
    M();
  };
  async function L() {
    const B = await Cv() || [];
    E.value = B;
  }
  function O(B, q, ae) {
    ae !== 0 && !B && (q.arrivalTime = "同上");
  }
  const x = Ee(() => u.isManufactured ? S.list.map((B) => B) : S.list.filter((B) => {
    let q = true;
    return r.value && B.requisitionMode !== r.value && (q = false), q;
  }));
  function I(B, q) {
    c("manuf-del", { id: B.id, quantity: B.quantity }, B, q);
  }
  function Y() {
    c("manuf-del-all");
  }
  function ee(B) {
    return Hi(B, { props: ["quantity", "totalWeight"] });
  }
  return (B, q) => {
    const ae = Ve("common-button"), j = pa, le = Ve("table-cell-tag"), oe = vt, ye = Ve("common-table"), ce = Rl, se = Mt, he = Li, be = Ve("common-drawer");
    return w(), U(be, { "before-close": l(M), "show-close": true, visible: l(V), "custom-class": "requisitions-application-preview", fullscreen: "", size: "80%", title: "材料申购汇总" }, { titleRight: p(() => [l(S).materialType === l(ct).MANUFACTURED.V ? (w(), U(j, { key: 0, title: "你确定要清空数据吗?", onConfirm: Y }, { reference: p(() => [s(ae, { class: "filter-item", size: "default", type: "danger" }, { default: p(() => q[2] || (q[2] = [Te(" 一键清空")])), _: 1, __: [2] })]), _: 1 })) : H("", true)]), content: p(() => [l(V) ? (w(), U(he, { key: 0, ref: "formRef", disabled: l(g).status.edit === l(h).STATUS.PROCESSING, model: l(S) }, { default: p(() => [e.isManufactured ? (w(), U(ye, { key: 1, "cell-class-name": l(R), data: x.value, "max-height": l(N) - 170, "summary-method": ee, "show-summary": "" }, { default: p(() => [s(oe, { align: "center", fixed: "left", label: "序号", type: "index", width: "55" }), l(S).finishedProductType === l(Fa).STRUC_MANUFACTURED.V ? (w(), Q(Qe, { key: 0 }, [s(oe, { align: "center", label: "单体", "min-width": "120px", prop: "monomer.name", "show-overflow-tooltip": "" }), s(oe, { align: "center", label: "区域", "min-width": "120px", prop: "area.name", "show-overflow-tooltip": "" }), s(oe, { align: "center", label: "名称", "min-width": "100px", prop: "name", "show-overflow-tooltip": "" }), s(oe, { align: "center", label: "编号", "min-width": "100px", prop: "serialNumber", "show-overflow-tooltip": "" }), s(oe, { align: "center", label: "规格", "min-width": "140px", prop: "specification", "show-overflow-tooltip": "" }), s(oe, { align: "center", label: "长度（mm）", prop: "length", "show-overflow-tooltip": "" }), s(oe, { align: "center", label: "材质", prop: "material", "show-overflow-tooltip": "" }), s(oe, { align: "center", label: "数量", "min-width": "100px", prop: "quantity", "show-overflow-tooltip": "" }, { default: p(({ row: { sourceRow: me } }) => [Te(K(me.quantity), 1)]), _: 1 }), s(oe, { align: "center", label: "单重（kg）", prop: "weight", "show-overflow-tooltip": "" }, { default: p(({ row: { sourceRow: me } }) => [C("span", null, K(l(Be)(me.weight, 2)), 1)]), _: 1 }), s(oe, { align: "center", label: "总重（kg）", prop: "totalWeight", "show-overflow-tooltip": "" }, { default: p(({ row: { sourceRow: me } }) => [C("span", null, K(me.totalWeight), 1)]), _: 1 })], 64)) : (w(), Q(Qe, { key: 1 }, [l(S).finishedProductType === l(Fa).ENCL_MANUFACTURED.V ? (w(), U(oe, { key: 0, align: "center", label: "类型", "min-width": "120px", prop: "enclosureType", "show-overflow-tooltip": "" }, { default: p(({ row: me }) => {
      var ge;
      return [Te(K((ge = l(y).find((Le) => Le.id === me.dictionaryId)) == null ? void 0 : ge.label), 1)];
    }), _: 1 })) : H("", true), s(oe, { align: "center", label: "编号", "min-width": "120px", prop: "serialNumber", "show-overflow-tooltip": "" }), s(oe, { align: "center", label: "名称", "min-width": "100px", prop: "name", "show-overflow-tooltip": "" }), s(oe, { align: "center", label: "规格", "min-width": "140px", prop: "specification", "show-overflow-tooltip": "" }), s(oe, { align: "center", label: "有效宽度", "min-width": "100px", prop: "width", "show-overflow-tooltip": "" }), s(oe, { align: "center", label: "厚度（mm）", "min-width": "120px", prop: "thickness", "show-overflow-tooltip": "" }), s(oe, { align: "center", label: "品牌", prop: "brand", "show-overflow-tooltip": "" }), s(oe, { align: "center", label: "颜色", prop: "color", "show-overflow-tooltip": "" }), s(oe, { align: "center", label: "材质", prop: "material", "show-overflow-tooltip": "" }), s(oe, { align: "center", label: "单长（mm）", "min-width": "120px", prop: "length", "show-overflow-tooltip": "" }), s(oe, { align: "center", label: "数量（张）", "min-width": "100px", prop: "quantity", "show-overflow-tooltip": "" }), s(oe, { align: "center", label: "总长（m）", "min-width": "120px", prop: "totalLength", "show-overflow-tooltip": "" }), s(oe, { align: "center", label: "总面积（m²）", "min-width": "120px", prop: "totalArea", "show-overflow-tooltip": "" }), s(oe, { align: "center", label: "总重（kg）", "min-width": "120px", prop: "totalWeight", "show-overflow-tooltip": "" })], 64)), s(oe, { align: "center", label: "到厂日期", prop: "arrivalTime", width: "160px" }, { default: p(({ row: { sourceRow: me }, $index: ge }) => [s(ce, { modelValue: me.arrivalTime, "onUpdate:modelValue": (Le) => me.arrivalTime = Le, disabled: l(g).status.edit === l(h).STATUS.PROCESSING, disabledDate: (Le) => l($a)(Le).valueOf() < l($a)().subtract(1, "days").valueOf(), placeholder: ge === 0 ? "选择日期" : "同上", size: "default", style: { width: "100%" }, type: "date", "value-format": "x", onChange: (Le) => O(Le, me, ge) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "disabledDate", "placeholder", "onChange"])]), _: 1 }), s(oe, { align: "center", fixed: "right", label: "操作", width: "80" }, { default: p(({ row: { sourceRow: me }, $index: ge }) => [s(j, { title: "你确定要删除该数据吗?", onConfirm: (Le) => I(me, ge) }, { reference: p(() => [s(ae, { icon: "el-icon-delete", size: "default", type: "danger" })]), _: 2 }, 1032, ["onConfirm"])]), _: 1 })]), _: 1 }, 8, ["cell-class-name", "data", "max-height"])) : (w(), U(ye, { key: 0, "cell-class-name": l(R), data: x.value, "data-format": b.value, "max-height": l(N), "row-style": P, stripe: false }, { default: p(() => [s(oe, { align: "center", label: "序号", type: "index", width: "55" }, { default: p(({ row: me, $index: ge }) => [s(le, { name: l(Ui).USE_INVENTORY.L, show: me.requisitionMode === l(Ui).USE_INVENTORY.V, color: "#e6a23c" }, null, 8, ["name", "show"]), C("span", null, K(ge + 1), 1)]), _: 1 }), s(fa, { showIndex: false }), s(za, { "show-measure-unit": false, "show-quantity": false }), s(oe, { align: "left", label: "项目", "min-width": "200px", prop: "project" }, { default: p(({ row: { sourceRow: me } }) => [Te(K(l(di)(me.project)), 1)]), _: 1 }), s(oe, { align: "center", label: "到厂日期", width: "160px" }, { default: p(({ row: { sourceRow: me } }) => [Te(K(l($a)(Number(me.arrivalTime)).format("yyyy-MM-DD")), 1)]), _: 1 })]), _: 1 }, 8, ["cell-class-name", "data", "data-format", "max-height"])), C("div", Yz, [q[3] || (q[3] = C("span", null, "备注", -1)), s(se, { modelValue: l(S).remark, "onUpdate:modelValue": q[0] || (q[0] = (me) => l(S).remark = me), rows: 2, class: "remark input-border-none", maxlength: "200", placeholder: "请填写申购备注", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue"])]), C("div", Kz, [s(dl, { files: l(S).attachments, "onUpdate:files": q[1] || (q[1] = (me) => l(S).attachments = me), "file-classify": l(cl).NORMAL.V, showView: true, class: "el-form-item-15", "empty-text": "暂未上传附件", "show-download": "", style: { "margin-top": "10px" } }, null, 8, ["files", "file-classify"])])]), _: 1 }, 8, ["disabled", "model"])) : H("", true), s(q_, { "show-total": false, class: "footer", "is-submit": "" })]), _: 1 }, 8, ["before-close", "visible"]);
  };
} }, G_ = ut(Wz, [["__scopeId", "data-v-6798f412"]]), jz = Object.freeze(Object.defineProperty({ __proto__: null, default: G_ }, Symbol.toStringTag, { value: "Module" }));
const Fz = { class: "main-content" }, zz = { __name: "common-wrapper", props: { validate: { type: Function }, unit: { type: String, default: "" }, totalValue: { type: [Number, String], default: 0 }, totalName: { type: String, default: "合计" }, btnName: { type: String, default: "下一步" }, showTotal: { type: Boolean, default: true }, showFooter: { type: Boolean, default: true }, edit: { type: Boolean, default: false }, isTsData: { type: Boolean, default: false }, basicClass: { type: Number, default: void 0 } }, setup(e, { expose: o }) {
  const n = eu(), c = e, u = Ee(() => {
    var V;
    if (c.isTsData) {
      if (c.basicClass & Pe.MATERIAL.V) return false;
    } else return ((V = n.fullPath) == null ? void 0 : V.includes("requisitions-v2")) && !c.isTsData;
    return false;
  }), r = Z(false), { heightStyle: E, maxHeight: y } = Kt({ mainBox: ".requisitions-application-record-form", extraBox: [".el-drawer__header", ".requisitions-application-select"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, navbar: false });
  async function b() {
    let V = true;
    typeof c.validate == "function" && (V = await c.validate()), r.value = V;
  }
  return o({ submit: b }), (V, M) => (w(), Q("div", { style: ri(`height: ${u.value ? l(y) - 95 : l(y)}px`), class: "requisitions-application-container" }, [C("div", Fz, [xt(V.$slots, "default", {}, void 0, true)]), c.showFooter ? (w(), U(q_, { key: 0, "btn-name": c.btnName, "show-total": c.showTotal, "total-name": c.totalName, "total-value": c.totalValue, unit: c.unit, class: "footer", onSubmit: b }, null, 8, ["btn-name", "show-total", "total-name", "total-value", "unit"])) : H("", true), s(G_, { modelValue: r.value, "onUpdate:modelValue": M[0] || (M[0] = (g) => r.value = g) }, null, 8, ["modelValue"])], 4));
} }, wr = ut(zz, [["__scopeId", "data-v-b3ffdb7d"]]), Bz = Object.freeze(Object.defineProperty({ __proto__: null, default: wr }, Symbol.toStringTag, { value: "Module" })), Ov = (e) => {
  const o = Z(true), n = Ht(), c = async (u) => {
    const r = Array.isArray(u) ? u : [u], E = n.state.config.classifySpec, y = r.filter((b) => E[b] === void 0);
    y.length > 0 && (o.value = false, y.forEach((b) => {
      n.state.config.classifySpec[b] = {};
    }), await n.dispatch("config/fetchMarClsSpec", y), o.value = true);
  };
  return e && c(e), { loaded: o, fetchMatClsSpec: c, matClsSpecKV: Ee(() => n.state.config.classifySpec.specKV), matClsSpec: Ee(() => n.state.config.classifySpec) };
};
const Hz = { key: 0, style: { float: "right", color: "#8492a6", "font-size": "13px", "padding-left": "6px" } }, qz = { __name: "index", props: { modelValue: { type: [Array, Number, String], default: "" }, disabledVal: { type: Array, default: () => [] }, basicClass: { type: Number, default: void 0 }, classifyId: { type: Array }, showSubjectCode: { type: Boolean, default: true }, size: { type: String, default: "default" }, clearable: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, showAllLevels: { type: Boolean, default: false }, separator: { type: String, default: "/" }, collapseTags: { type: Boolean, default: true }, placeholder: { type: String, default: "可搜索：科目名称、编号" }, multiple: { type: Boolean, default: false }, checkStrictly: { type: Boolean, default: false }, emitPath: { type: Boolean, default: false }, deep: { type: Number, default: void 0 }, onlyShowCurrentDeep: { type: Boolean, default: false }, showExtra: { type: Boolean, default: false }, extraOptionLabel: { type: String, default: "同上" }, extraOptionValue: { type: [Number, String, Array, Boolean], default: -1 }, default: { type: Boolean, default: false }, isDefaultExpand: { type: Boolean, default: false } }, emits: ["change", "update:modelValue"], setup(e, { expose: o, emit: n }) {
  const c = n, u = e, r = Ht(), E = Z(), y = Z(), b = Z(), V = Ct({ tree: [], treeOrigin: [] }), M = Z(true), { matClsTree: g } = ka("matClsTree"), { loaded: S, rawMatClsKV: h } = j_(), T = Ee(() => ({ value: "id", label: "name", children: "children", expandTrigger: "hover", emitPath: u.emitPath, multiple: u.multiple, checkStrictly: u.checkStrictly }));
  Ce([() => g.value, () => u.basicClass, () => u.classifyId, S], ([x, I, Y, ee]) => {
    ee && pt(() => {
      m(x);
    });
  }, { deep: true, immediate: true }), Ce(() => u.modelValue, (x) => {
    let I = Array.isArray(x) ? [...x] : x;
    const Y = O(false);
    I = Ae(x) ? Y : I, y.value = I, f(I);
  }, { immediate: true }), Ce([() => u.disabledVal, () => V.tree], () => {
    A(V.tree) && v(V.tree);
  }, { immediate: true, deep: true }), Ae(g.value) && r.dispatch("config/fetchMatClsTree");
  function _(x, I) {
    const { data: Y, pathLabels: ee } = x, B = I.length;
    if (B === 0) return true;
    const q = Y.name.includes(I), ae = ee.includes(I), j = Y.serialNumber && Y.serialNumber.substr(0, B) === I;
    return q || ae || j;
  }
  function f(x) {
    let I = x !== u.modelValue;
    x instanceof Array && (I = !x.equals(u.modelValue));
    const Y = Ae(x) && Ae(u.modelValue);
    return I && !Y ? (c("update:modelValue", x), c("change", x), true) : false;
  }
  function m(x) {
    try {
      if (x) {
        V.treeOrigin = x, b.value = L();
        let I = x.filter((Y) => !u.basicClass || Y.basicClass & u.basicClass);
        I = R(I), b.value && (I = Nw(I, b.value)), V.tree = I;
      } else V.treeOrigin = [], V.tree = [];
      if (y.value) {
        const I = AI(V.tree, y.value);
        (I == null ? void 0 : I.length) === 0 ? f(void 0) : Array.isArray(y.value) && y.value.length !== I.length && f(I);
      } else O();
    } catch (I) {
      console.log("获取科目级联列表失败", I);
    } finally {
      M.value = false;
    }
  }
  function R(x, I = 1) {
    if (Ae(u.deep) || I <= u.deep) {
      const Y = x.map((ee) => {
        let B = 1;
        const q = { id: ee.id, name: ee.name, serialNumber: ee.serialNumber, disabled: false };
        if (A(ee.children)) {
          const ae = R(ee.children, I + 1);
          A(ae) && (B++, q.children = ae);
        }
        return q.maxDeep = B, q;
      });
      return I === 1 && u.onlyShowCurrentDeep ? Y.filter((ee) => ee.maxDeep >= u.deep) : Y;
    } else return [];
  }
  function v(x) {
    x.forEach((I) => (u.disabledVal.includes(I.id) ? (I.disabled = true, I.initDisabled = true) : (I.disabled = false, I.initDisabled = false), A(I.children) && v(I.children), I));
  }
  function N() {
    const x = E.value.getCheckedNodes(true);
    return x.length ? x[0].data : {};
  }
  function P(x) {
    return x.parent ? P(x.parent) : x;
  }
  function L() {
    let x = u.classifyId;
    if (x == null) return null;
    const I = [];
    return Array.isArray(x) || (x = [x]), x.forEach((Y) => {
      const ee = h.value[Y], B = ee.fullPathId;
      I.push.apply(I, B), I.push.apply(I, Aw(ee.children));
    }), I;
  }
  function O(x = true) {
    if (Ae(u.modelValue) && u.default) {
      const I = NI(V.tree);
      if (A(I)) {
        let Y;
        return u.emitPath ? Y = I.map((ee) => ee.id) : Y = I[I.length - 1].id, x && f(Y), Y;
      }
    }
  }
  return o({ getNodeInfo: N, getParentNode: P }), (x, I) => {
    const Y = Ns;
    return w(), U(Y, { ref_key: "cascaderRef", ref: E, class: "classification-cascader", modelValue: y.value, "onUpdate:modelValue": I[0] || (I[0] = (ee) => y.value = ee), "popper-class": l(A)(V.tree) && e.isDefaultExpand ? "classification-custom-pop-layer" : "", placeholder: e.placeholder, options: V.tree, props: T.value, "show-all-levels": e.showAllLevels, separator: e.separator, clearable: e.clearable, disabled: e.disabled || !l(S), "collapse-tags": e.collapseTags, filterable: "", size: e.size, "filter-method": _, onChange: f }, { default: p(({ data: ee }) => [C("span", null, K(ee.name), 1), e.showSubjectCode ? (w(), Q("span", Hz, K(ee.serialNumber), 1)) : H("", true)]), _: 1 }, 8, ["modelValue", "popper-class", "placeholder", "options", "props", "show-all-levels", "separator", "clearable", "disabled", "collapse-tags", "size"]);
  };
} }, Ql = ut(qz, [["__scopeId", "data-v-a6337123"]]);
const Gz = { class: "operate-container" }, Qz = { key: 0, class: "cls-container" }, Zz = { class: "input-container" }, Jz = { key: 1 }, Xz = { class: "container-prepend" }, $z = { class: "spec-container" }, Ou = "无规格", eB = { __name: "index", props: { modelValue: { type: Array, default: () => [] }, rowInitFn: { type: Function }, showClassify: { type: Boolean, default: true }, classifyId: { type: Number }, mode: { type: String, default: "accumulator" }, multiple: { type: Boolean, default: false }, maxHeight: { type: Number, default: 600 }, visible: { type: Boolean, default: true }, expandQuery: { type: Boolean, default: false }, isFirstSelectChange: { type: Boolean, default: false }, basicClass: { type: Number } }, emits: ["change", "accumulateChange", "selectionChange", "update:classifyId", "update:modelValue"], setup(e, { expose: o, emit: n }) {
  const c = Ht(), u = n, r = e, E = Z({ spec: void 0 }), y = Z(), b = Z({}), V = Z(r.expandQuery), M = Z({}), g = Z({}), S = Z(), h = Z([]), T = Z(true), _ = () => {
    T.value = false, Nc(oe, 100, false)();
  }, { loaded: f, matClsSpec: m, matClsSpecKV: R, fetchMatClsSpec: v } = Ov(), N = Ee(() => A(M.value.specList) ? M.value.specList.filter((ye) => {
    const ce = Ae(E.value.spec) || ye.spec.indexOf(E.value.spec) > -1;
    let se = true;
    return M.value.specConfig.forEach((he) => {
      A(E.value[he.id]) && (se = se && ye.specKV[he.id] === E.value[he.id]);
    }), r.basicClass & Ci.SECTION_STEEL.V ? ce && se && ye.status : ce && se;
  }) : []);
  Ce(() => r.modelValue, (ye) => {
    h.value = ye;
  }, { immediate: true }), Ce(() => r.classifyId, (ye) => {
    S.value = ye;
  }, { immediate: true }), Ce(S, (ye) => {
    P(ye);
  }, { immediate: true }), Ce(() => c.state.config.classifySpec, () => {
    P(S.value);
  }), Ce([() => r.visible, () => M.value.specList], ([ye]) => {
    ye && _();
  }, { immediate: true }), El(() => {
    window.addEventListener("resize", _, { passive: false });
  }), bl(() => {
    window.removeEventListener("resize", _);
  });
  async function P(ye) {
    ye ? (await v(ye), M.value = m.value[ye]) : M.value = {}, u("update:classifyId", ye);
  }
  function L({ addList: ye, cancelList: ce }) {
    r.mode === "accumulator" && (A(ye) && ye.forEach((se) => {
      const he = O(R.value[se]);
      he && h.value.push(he);
    }), A(ce) && (h.value = h.value.filter((se) => !ce.map((he) => he.sn).includes(se.sn)))), r.mode === "selector" && (A(ye) && ye.forEach((se) => {
      const he = R.value[se];
      he && h.value.push(he);
    }), A(ce) && (h.value = h.value.filter((se) => !ce.map((he) => he.sn).includes(se.sn)))), u("update:modelValue", h.value), u("change", h.value);
  }
  function O(ye) {
    return typeof r.rowInitFn == "function" ? r.rowInitFn(ye) : { sn: ye.sn, classifyId: ye.classify.id, classifyFullName: ye.classify.fullName, specification: ye.spec, specificationMap: ye.specKV, measureUnit: ye.classify.measureUnit, accountingUnit: ye.classify.accountingUnit, accountingPrecision: ye.classify.accountingPrecision, measurePrecision: ye.classify.measurePrecision };
  }
  function x(ye) {
    ye.forEach((ce) => {
      Ae(g.value[ce]) ? g.value[ce] = 1 : g.value[ce]++;
    });
  }
  function I(ye) {
    if (!r.multiple && g.value[ye]) return;
    g.value[ye] = !g.value[ye];
    const ce = g.value[ye];
    let se = [], he = [];
    r.multiple ? ce ? he = [ye] : (delete g.value[ye], se = [{ sn: ye, num: 1 }]) : (Object.keys(g.value).forEach((me) => {
      me !== ye && (g.value[me] = 0, se.push({ sn: me, num: 1 }));
    }), he = [ye]);
    const be = { snList: Object.keys(g.value), addList: he, cancelList: se };
    L(be), u("selectionChange", be);
  }
  function Y(ye) {
    Ae(g.value[ye]) ? g.value[ye] = 1 : g.value[ye]++;
    const ce = { snList: Object.keys(g.value), addList: [ye], cancelList: [] };
    L(ce), u("accumulateChange", ce);
  }
  function ee(ye, ce) {
    if (r.mode === "accumulator") {
      A(g.value[ye]) && (g.value[ye] -= 1), g.value[ye] === 0 && delete g.value[ye], h.value.splice(ce, 1);
      const se = { snList: Object.keys(g.value), cancelList: [{ sn: ye, num: 1 }] };
      u("accumulateChange", se);
    }
    r.mode, u("update:modelValue", h.value), u("change", h.value);
  }
  function B(ye) {
    const ce = Object.keys(g.value), se = [];
    ce.forEach((he) => {
      const be = R.value[he];
      be && be.classify && be.classify.basicClass & ye && se.push(he);
    }), ae(se);
  }
  function q(ye) {
    const ce = Object.keys(m.value[ye].specKV);
    ae(ce);
  }
  function ae(ye) {
    const ce = Array.isArray(ye) ? ye : [ye];
    if (r.mode === "accumulator") {
      const se = [];
      ce.forEach((be) => {
        const me = g.value[be];
        delete g.value[be], se.push({ sn: be, num: me });
      });
      const he = { snList: Object.keys(g.value), cancelList: se };
      L(he), u("accumulateChange", he);
    }
    r.mode;
  }
  function j() {
    g.value = {}, S.value = void 0;
  }
  function le() {
    ae(Object.keys(g.value));
  }
  function oe() {
    const ye = M.value.specList;
    if (A(ye)) {
      const ce = ye[0].spec || Ou, se = ye[ye.length - 1].spec || Ou, he = ye[Math.floor((ye.length - 1) / 2)].spec || Ou, be = 10, me = (G) => 20 + o7(G, { attribute: /* @__PURE__ */ new Map([["class", "el-tag el-tag--info el-tag--large el-tag--plain"]]) }), ge = me(ce), Le = me(se), Ie = me(he), Se = [ge, Le, Ie], X = Se.maxIndex(), $ = Se[X], k = hS(pS(y.value, "width")) - 10;
      let J = Math.floor(k / $);
      const z = k % $;
      J > 1 && z / J < be && (J -= 1);
      const F = (k - (J - 1) * be) / J;
      b.value = { "grid-template-columns": `repeat(${J}, ${F}px)` };
    } else b.value = {};
    T.value = true;
  }
  return o({ delListItem: ee, init: j, initSelected: x, clear: le, clearByBasicClass: B, clearCurrentClassify: q }), (ye, ce) => {
    const se = Mt, he = Ve("common-select-v2"), be = hr, me = ml, ge = wi, Le = zn;
    return e.isFirstSelectChange ? H("", true) : (w(), Q("div", { key: 0, ref_key: "materialSpecRef", ref: y, style: ri({ "max-height": `${r.maxHeight}px` }), class: "material-spec-select" }, [C("div", Gz, [e.showClassify ? (w(), Q("div", Qz, [ce[3] || (ce[3] = C("div", { class: "container-prepend" }, "科目", -1)), s(Ql, { modelValue: S.value, "onUpdate:modelValue": ce[0] || (ce[0] = (Ie) => S.value = Ie), class: "cls-cascader", clearable: "", separator: " > ", "show-all-levels": "", size: "default" }, null, 8, ["modelValue"])])) : H("", true), C("div", Zz, [s(D1, { "is-active": V.value, class: "hamburger-container", onToggleClick: ce[1] || (ce[1] = (Ie) => V.value = !V.value) }, null, 8, ["is-active"]), s(se, { modelValue: E.value.spec, "onUpdate:modelValue": ce[2] || (ce[2] = (Ie) => E.value.spec = Ie), placeholder: "可输入规格查询" }, { prepend: p(() => ce[4] || (ce[4] = [Te("规格")])), _: 1 }, 8, ["modelValue"])]), V.value ? (w(), Q("div", Jz, [(w(true), Q(Qe, null, ki(M.value.specConfig, (Ie) => (w(), Q("div", { key: Ie.id, class: "select-container" }, [C("div", Xz, K(Ie.name), 1), s(he, { modelValue: E.value[Ie.id], "onUpdate:modelValue": (Se) => E.value[Ie.id] = Se, "data-structure": { key: "name", label: "name", value: "name" }, loading: !l(f), options: Ie.list, placeholder: Ie.name, class: "spec-conf-select", clearable: "", filterable: "", size: "default", type: "other" }, null, 8, ["modelValue", "onUpdate:modelValue", "loading", "options", "placeholder"])]))), 128))])) : H("", true)]), C("div", $z, [!l(f) || !T.value ? (w(), U(ge, { key: 0, class: "tip-tag loading-tag", effect: "plain", size: "large" }, { default: p(() => [s(me, { class: "is-loading" }, { default: p(() => [s(be)]), _: 1 }), ce[5] || (ce[5] = Te(" 科目加载中 "))]), _: 1, __: [5] })) : M.value.hasUnitConfig === false ? (w(), U(ge, { key: 1, class: "tip-tag", effect: "plain", size: "large", type: "danger" }, { default: p(() => ce[6] || (ce[6] = [Te(" 请先在“配置管理-计量配置”中进行该科目的核算单位配置 ")])), _: 1, __: [6] })) : M.value.specList ? (w(), Q("div", { key: 2, style: ri(b.value), class: "tag-container" }, [r.mode === "accumulator" ? (w(true), Q(Qe, { key: 0 }, ki(N.value, (Ie) => (w(), Q("div", { key: Ie.sn, class: "tag-content" }, [s(Le, { max: 99, value: g.value[Ie.sn], class: "badge pointer", type: "warning", onDblclick: (Se) => ae(Ie.sn) }, null, 8, ["value", "onDblclick"]), s(ge, { effect: g.value[Ie.sn] ? void 0 : "plain", type: g.value[Ie.sn] ? "success" : "info", class: "pointer", size: "large", onClick: Pi((Se) => Y(Ie.sn), ["stop"]) }, { default: p(() => [Te(K(Ie.spec || Ou), 1)]), _: 2 }, 1032, ["effect", "type", "onClick"])]))), 128)) : H("", true), r.mode === "selector" ? (w(true), Q(Qe, { key: 1 }, ki(N.value, (Ie) => (w(), U(ge, { key: Ie.sn, effect: g.value[Ie.sn] ? void 0 : "plain", type: g.value[Ie.sn] ? "success" : "info", class: "pointer", size: "large", onClick: (Se) => I(Ie.sn) }, { default: p(() => [Te(K(Ie.spec), 1)]), _: 2 }, 1032, ["effect", "type", "onClick"]))), 128)) : H("", true)], 4)) : (w(), U(ge, { key: 3, class: "tip-tag", effect: "plain", size: "large", type: "warning" }, { default: p(() => ce[7] || (ce[7] = [Te(" * 请先选择科目")])), _: 1, __: [7] }))])], 4));
  };
} }, ba = ut(eB, [["__scopeId", "data-v-7324a65c"]]);
const tB = { class: "material-table-spec-select flex-rss" }, iB = { class: "filter-input-container", style: { "margin-bottom": "10px" } }, aB = { class: "filter-input-container" }, lB = ["onClick"], oB = ["onDblclick"], nB = { key: 0, class: "parent-node-title" }, sB = { __name: "material-table-spec-select", props: { modelValue: { type: Array, default: () => [] }, rowInitFn: { type: Function }, classifyIds: { type: Array }, mode: { type: String, default: "accumulator" }, maxHeight: { type: Number, default: 600 }, tableWidth: { type: [Number, String], default: 350 }, basicClass: { type: Number }, autoSelected: { type: Boolean, default: false }, expandQuery: { type: Boolean, default: false }, visible: { type: Boolean, default: true } }, emits: ["accumulateChange", "selectionChange", "change", "update:modelValue"], setup(e, { expose: o, emit: n }) {
  const c = n, u = e, r = Z({}), E = Z(), y = Z(), b = Z({}), V = Z(), M = Z({}), g = Z([]), S = Z([]), h = Z(false), T = Ee(() => typeof u.tableWidth == "number" ? `${u.tableWidth}px` : u.tableWidth), { matClsSpecKV: _ } = Ov(), { loaded: f, matClsLeafList: m, firstLevelSubjectTree: R } = j_(), v = Ee(() => {
    let ye = g.value;
    return A(E.value) && (ye = ye.filter((ce) => {
      const se = ce.serialNumber.indexOf(E.value) > -1, he = ce.fullPathName.some((be) => be.indexOf(E.value) > -1);
      return se || he;
    })), A(y.value) && (ye = ye.filter((ce) => ce.fullPathName.some((he) => he.indexOf(y.value) > -1))), ye;
  });
  Ce(() => u.modelValue, (ye) => {
    V.value = ye;
  }, { immediate: true }), Dt(() => {
    P(u.basicClass), N(u.basicClass);
  });
  function N(ye) {
    S.value = [];
    let ce = [];
    ye && (ce = R.value.filter((se) => ye & se.basicClass)), A(ce) && (ce = ce.filter((se) => se.boolStatus)), S.value = ce, A(ce) && (y.value = ce[0].name);
  }
  function P(ye) {
    if (!m.value) {
      S.value = [], g.value = [];
      return;
    }
    let ce;
    ye ? ce = m.value.filter((se) => ye & se.basicClass) : ce = m.value, A(u.classifyIds) && (u.classifyIds.includes(0) || (ce = ce.filter((se) => {
      for (const he of u.classifyIds) if (se.fullPathId.includes(he)) return true;
      return false;
    }))), A(ce) && (ce = ce.filter((se) => se.boolStatus)), u.autoSelected && A(ce) ? x(ce[0]) : x(), g.value = ce;
  }
  function L(ye) {
    h.value = false, b.value = ye;
  }
  function O() {
    h.value = true;
  }
  function x(ye = {}) {
    h.value = false, b.value = ye;
  }
  function I(ye) {
    V.value = ye, c("update:modelValue", ye), c("change", ye);
  }
  function Y(ye) {
    M.value[ye] = 0, r.value && r.value.clearCurrentClassify(ye);
  }
  function ee({ snList: ye, addList: ce, cancelList: se }) {
    A(ce) && ce.forEach((he) => {
      const be = _.value[he].classify.id;
      M.value[be] = M.value[be] ? M.value[be] + 1 : 1;
    }), A(se) && se.forEach(({ sn: he, num: be }) => {
      const me = _.value[he].classify.id;
      M.value[me] = M.value[me] ? M.value[me] - be : 0;
    }), c("accumulateChange", { snList: ye, addList: ce, cancelList: se });
  }
  function B(ye) {
    c("selectionChange", ye);
  }
  function q() {
    r.value && r.value.init();
  }
  function ae(ye) {
    A(ye) && ye.forEach(({ classifyId: ce }) => {
      const se = ce;
      M.value[se] = M.value[se] ? M.value[se] + 1 : 1;
    }), r.value && r.value.initSelected(ye.map((ce) => ce.sn));
  }
  function j(ye, ce) {
    r.value && r.value.delListItem(ye, ce);
  }
  function le() {
    r.value && r.value.clear();
  }
  function oe(ye) {
    r.value && r.value.clearByBasicClass(ye);
  }
  return o({ delListItem: j, init: q, initSelected: ae, clear: le, clearByBasicClass: oe }), (ye, ce) => {
    const se = zo, he = Bo, be = Mt, me = jm, ge = wi, Le = hr, Ie = ml, Se = _t("split");
    return w(), Q("div", tB, [C("div", { style: ri({ width: `${T.value}` }), class: "left-container" }, [C("div", iB, [s(he, { modelValue: y.value, "onUpdate:modelValue": ce[0] || (ce[0] = (X) => y.value = X), size: "default", clearable: "", filterable: "", placeholder: "请选择一级科目", style: { width: "100%" }, class: "purchase-sn-select", onChange: O }, { default: p(() => [(w(true), Q(Qe, null, ki(S.value, (X) => (w(), U(se, { key: X.id, label: X.name, value: X.name }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue"])]), C("div", aB, [s(be, { modelValue: E.value, "onUpdate:modelValue": ce[1] || (ce[1] = (X) => E.value = X), placeholder: "可输入编号/名称过滤科目", size: "default" }, null, 8, ["modelValue"])]), l(f) ? (w(), Q("div", { key: 0, style: ri({ "max-height": `${u.maxHeight - 100}px` }), class: "classify-list" }, [y.value ? (w(), Q(Qe, { key: 0 }, [l(A)(g.value) ? (w(), Q(Qe, { key: 0 }, [l(A)(v.value) ? (w(true), Q(Qe, { key: 0 }, ki(v.value, (X) => (w(), U(me, { key: X.id, class: Zt([{ "is-checked": X.id === b.value.id }, "classify-card"]), shadow: "hover" }, { default: p(() => [C("div", { class: "classify-item pointer", onClick: ($) => L(X) }, [C("span", null, [X.id && M.value[X.id] ? (w(), Q("span", { key: 0, class: "number-badge counter-badge", onDblclick: Pi(($) => Y(X.id), ["stop"]) }, K(M.value[X.id]), 41, oB)) : H("", true), Te(" " + K(X.serialNumber), 1)]), C("span", null, [Te(K(X.name) + " ", 1), l(A)(X.parent) ? qe((w(), Q("span", nB, null, 512)), [[Se, { val: X.parent.fullPathName, symbol: ">" }]]) : H("", true)])], 8, lB)]), _: 2 }, 1032, ["class"]))), 128)) : (w(), U(ge, { key: 1, class: "tip-tag", effect: "plain", size: "large", type: "info" }, { default: p(() => ce[3] || (ce[3] = [Te(" 未搜索到相关科目")])), _: 1, __: [3] }))], 64)) : (w(), U(ge, { key: 1, class: "tip-tag", effect: "plain", size: "large", type: "danger" }, { default: p(() => ce[4] || (ce[4] = [Te(" 尚未配置科目")])), _: 1, __: [4] }))], 64)) : (w(), U(ge, { key: 1, class: "tip-tag", effect: "plain", size: "large", type: "danger" }, { default: p(() => ce[5] || (ce[5] = [Te(" 尚未选择一级科目")])), _: 1, __: [5] }))], 4)) : (w(), U(ge, { key: 1, class: "tip-tag loading-tag", effect: "plain", size: "large" }, { default: p(() => [s(Ie, { class: "is-loading" }, { default: p(() => [s(Le)]), _: 1 }), ce[6] || (ce[6] = Te(" 科目加载中 "))]), _: 1, __: [6] }))], 4), s(ba, { ref_key: "specRef", ref: r, modelValue: V.value, "onUpdate:modelValue": ce[2] || (ce[2] = (X) => V.value = X), basicClass: u.basicClass, classifyId: b.value.id, "expand-query": u.expandQuery, isFirstSelectChange: h.value, "max-height": u.maxHeight, mode: u.mode, "row-init-fn": u.rowInitFn, "show-classify": false, visible: u.visible, class: "right-container spec-select", onChange: I, onAccumulateChange: ee, onSelectChange: B }, null, 8, ["modelValue", "basicClass", "classifyId", "expand-query", "isFirstSelectChange", "max-height", "mode", "row-init-fn", "visible"])]);
  };
} }, to = ut(sB, [["__scopeId", "data-v-ae312854"]]);
const rB = { key: 1 }, uB = { key: 1 }, cB = { key: 1 }, dB = { __name: "steel-plate-table", emits: ["search-inventory"], setup(e, { expose: o, emit: n }) {
  const c = n, u = Ge.STEEL_PLATE.V, r = ft("useInventoryInfo"), E = ft("matSpecRef"), { baseUnit: y } = ai(u), { cu: b, form: V } = Wi(), M = (j, le) => A(j) && !isNaN(j) ? j >= 0 : true, g = Ee(() => {
    let j = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], thickness: [{ required: true, message: "请填写厚度", trigger: "blur" }, { pattern: Vi, message: "厚度必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { pattern: Vi, message: "重量必须大于0", trigger: "blur" }], quantity: [{ validator: M, message: "数量必须大于0", trigger: "blur" }], arrivalTime: [{ required: true, message: "请选择需求时间", trigger: "change" }] };
    return V.level === Bt.CONSTRUCTION_SITE.V && (j = Object.assign(j, { projectId: [{ required: true, message: "请选择需求时间", trigger: "change" }] })), j;
  }), S = ft("steelDensityCfg");
  function h({ row: j, rowIndex: le }) {
    var oe, ye;
    if ((ye = (oe = b == null ? void 0 : b.submitResult) == null ? void 0 : oe.data) != null && ye.includes(j.classifyId)) return { backgroundColor: "#ffdede" };
  }
  const T = /* @__PURE__ */ new Map([["arrivalTime", "同上"], ["projectId", -1]]), { tableValidate: _, wrongCellMask: f, cleanUpData: m } = ui({ rules: g, ditto: T, errorMsg: "请修正【钢板清单】中标红的信息" }), { projectAllType: R } = Wa();
  function v(j) {
    var oe, ye;
    const le = Ct({ uid: Tt(), sn: j.sn, requisitionMode: Ui.PURCHASE.V, specificationLabels: j.specificationLabels, classifySerialNumber: j.classify.serialNumber, serialNumber: j.serialNumber, classifyId: j.classify.id, classifyFullName: j.classify.fullName, classifyName: j.classify.name, classifyParentFullName: j.classify.parentFullName, basicClass: j.classify.basicClass, specification: j.spec, specificationMap: j.specKV, measureUnit: j.classify.measureUnit, accountingUnit: j.classify.accountingUnit, accountingPrecision: j.classify.accountingPrecision, measurePrecision: j.classify.measurePrecision, quantity: void 0, thickness: void 0, length: void 0, width: void 0, theoryWeight: void 0, theoryTotalWeight: void 0, weighingTotalWeight: void 0, arrivalTime: ((oe = V.steelPlateList) == null ? void 0 : oe.length) > 0 ? "同上" : void 0, projectId: ((ye = V.steelPlateList) == null ? void 0 : ye.length) > 0 ? -1 : void 0, project: void 0, steelDensity: A(j.steelDensity) ? j.steelDensity : S.value[j.classify.id] });
    return P(le), le;
  }
  function N(j) {
    var le, oe;
    return j.materialInventoryId && V.originInventoryInfo[j.materialInventoryId] ? ((oe = (le = V.originInventoryInfo) == null ? void 0 : le[j.materialInventoryId]) == null ? void 0 : oe.basicClass) & Ge.STEEL_COIL.V ? 1 : V.originInventoryInfo[j.materialInventoryId].quantity - V.originInventoryInfo[j.materialInventoryId].frozenQuantity - r.value[j.materialInventoryId] + j.quantity : 999999999;
  }
  function P(j) {
    j.theoryTotalWeight, Ce([() => j.length, () => j.width, () => j.thickness, y], () => L(j), { immediate: true }), Ce([() => j.theoryWeight, () => j.quantity], () => O(j), { immediate: true }), Ce([() => j.theoryTotalWeight], () => x(j));
  }
  async function L(j) {
    j.theoryWeight = await na({ classifyId: j.classifyId, name: j.classifyFullName, length: j.length, width: j.width, thickness: j.thickness });
  }
  function O(j) {
    A(j.theoryWeight) && j.quantity ? j.theoryTotalWeight = Be(j.theoryWeight * j.quantity, y.value.weight.precision) : j.theoryTotalWeight = void 0;
  }
  function x(j) {
    j.weighingTotalWeight = A(j.theoryTotalWeight) ? Be(j.theoryTotalWeight, y.value.weight.precision) : void 0;
  }
  function I(j, le) {
    c("search-inventory", j, le);
  }
  function Y(j, le, oe) {
    var ye, ce, se, he;
    if ((ce = (ye = b == null ? void 0 : b.submitResult) == null ? void 0 : ye.data) != null && ce.includes(oe.classifyId)) {
      const be = (se = b == null ? void 0 : b.submitResult) == null ? void 0 : se.data.findIndex((ge) => ge === oe.classifyId);
      V.list.filter((ge) => ge.classifyId === oe.classifyId).length === 1 && ((he = b == null ? void 0 : b.submitResult) == null || he.data.splice(be, 1));
    }
    E.value ? E.value.delListItem(j, le) : V.steelPlateList.splice(le, 1);
  }
  function ee() {
    if (Ae(V.steelPlateList)) return true;
    const { validResult: j, dealList: le } = _(V.steelPlateList);
    return j && q(le), j;
  }
  function B() {
    if (Ae(V.steelPlateList)) return true;
    const j = V.steelPlateList.filter((le) => true);
    return q(j), true;
  }
  function q(j) {
    m(j), j.forEach((le, oe) => {
      var ye;
      V.steelPlateList[oe].projectId = le.projectId, V.steelPlateList[oe].project = (ye = R.value) == null ? void 0 : ye.find((ce) => V.steelPlateList[oe].projectId === ce.id), V.steelPlateList[oe].arrivalTime = le.arrivalTime;
    });
  }
  function ae(j) {
    j.projectId = void 0, j.project = void 0;
  }
  return o({ rowInit: v, rowWatch: P, validate: ee, TSValidate: B }), (j, le) => {
    const oe = vt, ye = Ve("table-cell-tag"), ce = jt, se = Ve("common-input-number"), he = Rl, be = Ve("common-button"), me = Ve("common-table"), ge = _t("empty-text");
    return w(), U(me, ii({ "cell-class-name": l(f), data: l(V).steelPlateList, "row-style": h, "show-empty-symbol": false, stripe: false, "return-source-data": "", "row-key": "uid" }, j.$attrs), { default: p(() => [s(oe, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), s(oe, { align: "center", fixed: "left", label: "编号", prop: "serialNumber" }, { default: p(({ row: Le }) => [s(ye, { name: l(Ui).USE_INVENTORY.L, show: Le.requisitionMode === l(Ui).USE_INVENTORY.V, color: "#e6a23c" }, null, 8, ["name", "show"]), C("span", null, K(Le.serialNumber), 1)]), _: 1 }), s(oe, { align: "center", fixed: "left", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "" }, { default: p(({ row: Le }) => [s(ce, { content: Le.classifyParentFullName, disabled: !Le.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[ge, Le.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(oe, { align: "center", fixed: "left", label: "规格", prop: "specification", "show-overflow-tooltip": "" }, { default: p(({ row: Le }) => [s(ce, { content: Le.specificationLabels, placement: "top" }, { default: p(() => [C("span", null, K(Le.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), s(oe, { label: `厚 (${l(y).thickness.unit})`, align: "center", prop: "thickness" }, { default: p(({ row: Le }) => [Le.requisitionMode !== l(Ui).USE_INVENTORY.V ? (w(), U(se, { key: 0, modelValue: Le.thickness, "onUpdate:modelValue": (Ie) => Le.thickness = Ie, controls: false, disabled: !!l(V).boolUsed, max: 99999999, min: 0, precision: l(y).thickness.precision, "controls-position": "right", placeholder: "厚", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision"])) : (w(), Q("span", rB, K(Le.thickness), 1))]), _: 1 }, 8, ["label"]), s(oe, { label: `宽 (${l(y).width.unit})`, align: "center", prop: "width" }, { default: p(({ row: Le }) => [Le.requisitionMode !== l(Ui).USE_INVENTORY.V ? (w(), U(se, { key: 0, modelValue: Le.width, "onUpdate:modelValue": (Ie) => Le.width = Ie, controls: false, disabled: !!l(V).boolUsed, max: 99999999, min: 0, precision: l(y).width.precision, "controls-position": "right", placeholder: "宽", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision"])) : (w(), Q("span", uB, K(Le.width), 1))]), _: 1 }, 8, ["label"]), s(oe, { label: `长 (${l(y).length.unit})`, align: "center", prop: "length" }, { default: p(({ row: Le }) => [Le.requisitionMode !== l(Ui).USE_INVENTORY.V ? (w(), U(se, { key: 0, modelValue: Le.length, "onUpdate:modelValue": (Ie) => Le.length = Ie, controls: false, disabled: !!l(V).boolUsed, max: 999999999, min: 0, precision: l(y).length.precision, placeholder: "长", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision"])) : (w(), Q("span", cB, K(Le.length), 1))]), _: 1 }, 8, ["label"]), s(oe, { label: `数量 (${l(y).measure.unit})`, align: "center", prop: "quantity" }, { default: p(({ row: Le }) => [s(se, { modelValue: Le.quantity, "onUpdate:modelValue": (Ie) => Le.quantity = Ie, controls: false, disabled: !!l(V).boolUsed, max: N(Le), min: 1, precision: l(y).measure.precision, step: 1, "controls-position": "right", placeholder: "数量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "max", "precision"])]), _: 1 }, 8, ["label"]), s(oe, { key: "weighingTotalWeight", label: `总重 (${l(y).weight.unit})`, align: "center", prop: "weighingTotalWeight" }, { default: p(({ row: Le }) => [s(se, { modelValue: Le.weighingTotalWeight, "onUpdate:modelValue": (Ie) => Le.weighingTotalWeight = Ie, controls: false, disabled: !!l(V).boolUsed, max: 999999999, min: 0, precision: l(y).weight.precision, "controls-position": "right", placeholder: "重量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision"])]), _: 1 }, 8, ["label"]), s(oe, { key: "projectId", align: "center", label: "项目", "min-width": "200", prop: "projectId" }, { default: p(({ row: Le, $index: Ie }) => [s(ca, { modelValue: Le.projectId, "onUpdate:modelValue": (Se) => Le.projectId = Se, branchCompanyId: l(V).branchCompanyId, disabled: l(Ae)(l(V).branchCompanyId) || !!l(V).boolUsed, isLumpSum: false, "show-extra": Ie !== 0, clearable: "", style: { width: "100%" }, onClear: (Se) => ae(Le) }, null, 8, ["modelValue", "onUpdate:modelValue", "branchCompanyId", "disabled", "show-extra", "onClear"])]), _: 1 }), s(oe, { key: "arrivalTime", align: "center", label: "期望到场时间", prop: "arrivalTime" }, { default: p(({ row: Le, $index: Ie }) => [s(he, { modelValue: Le.arrivalTime, "onUpdate:modelValue": (Se) => Le.arrivalTime = Se, disabled: !!l(V).boolUsed, disabledDate: (Se) => l(xn)(Se).valueOf() < l(xn)().subtract(1, "days").valueOf(), placeholder: Ie === 0 || l(Ae)(Le.arrivalTime) ? "选择日期" : "同上", size: "default", style: { width: "100%" }, type: "date", "value-format": "x" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "disabledDate", "placeholder"])]), _: 1 }), s(oe, { align: "center", fixed: "right", label: "库存", width: "90" }, { default: p(({ row: Le, $index: Ie }) => [s(be, { size: "default", type: "primary", onClick: (Se) => I(Le, Ie) }, { default: p(() => le[0] || (le[0] = [Te(" 查询")])), _: 2, __: [0] }, 1032, ["onClick"])]), _: 1 }), s(oe, { align: "center", fixed: "right", label: "操作", width: "70" }, { default: p(({ row: Le, $index: Ie }) => [s(be, { disabled: !!l(V).boolUsed, icon: "el-icon-delete", size: "default", type: "danger", onClick: (Se) => Y(Le.sn, Ie, Le) }, null, 8, ["disabled", "onClick"])]), _: 1 })]), _: 1 }, 16, ["cell-class-name", "data"]);
  };
} }, kv = ut(dB, [["__scopeId", "data-v-9b654705"]]), mB = Object.freeze(Object.defineProperty({ __proto__: null, default: kv }, Symbol.toStringTag, { value: "Module" })), pB = { key: 1 }, Dv = { __name: "section-steel-table", emits: ["search-inventory"], setup(e, { expose: o, emit: n }) {
  const c = n, u = Ge.SECTION_STEEL.V, r = ft("useInventoryInfo"), E = ft("matSpecRef"), { baseUnit: y } = ai(u), { cu: b, form: V } = Wi(), M = (j, le) => A(j) && !isNaN(j) ? j >= 0 : true, g = Ee(() => {
    let j = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], length: [{ validator: M, message: "定尺长度必须大于0", trigger: "blur" }], quantity: [{ validator: M, message: "数量必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { pattern: Vi, message: "重量必须大于0", trigger: "blur" }], arrivalTime: [{ required: true, message: "请选择需求时间", trigger: "change" }] };
    return V.level === Bt.CONSTRUCTION_SITE.V && (j = Object.assign(j, { projectId: [{ required: true, message: "请选择需求时间", trigger: "change" }] })), j;
  });
  function S({ row: j, rowIndex: le }) {
    var oe, ye;
    if ((ye = (oe = b == null ? void 0 : b.submitResult) == null ? void 0 : oe.data) != null && ye.includes(j.classifyId)) return { backgroundColor: "#ffdede" };
  }
  const h = /* @__PURE__ */ new Map([["arrivalTime", "同上"], ["projectId", -1]]), { tableValidate: T, wrongCellMask: _, cleanUpData: f } = ui({ rules: g, ditto: h, errorMsg: "请修正【型材清单】中标红的信息" }), { projectAllType: m } = Wa();
  function R(j) {
    var ye, ce, se, he;
    let le;
    j.classify.basicClass === Pe.SECTION_STEEL.V && (le = (ce = (ye = j.nationalStandardOptions) == null ? void 0 : ye.find((be) => be.boolDefault === true)) == null ? void 0 : ce.standardId);
    const oe = Ct({ uid: Tt(), sn: j.sn, requisitionMode: Ui.PURCHASE.V, specificationLabels: j.specificationLabels, classifySerialNumber: j.classify.serialNumber, serialNumber: j.serialNumber, classifyId: j.classify.id, classifyFullName: j.classify.fullName, classifyName: j.classify.name, classifyParentFullName: j.classify.parentFullName, basicClass: j.classify.basicClass, specification: j.spec, specificationMap: j.specKV, measureUnit: j.classify.measureUnit, accountingUnit: j.classify.accountingUnit, accountingPrecision: j.classify.accountingPrecision, measurePrecision: j.classify.measurePrecision, unitWeight: j.unitWeight, quantity: void 0, length: void 0, totalLength: void 0, theoryWeight: void 0, theoryTotalWeight: void 0, weighingTotalWeight: void 0, hasOver: false, arrivalTime: ((se = V.sectionSteelList) == null ? void 0 : se.length) > 0 ? "同上" : void 0, projectId: ((he = V.sectionSteelList) == null ? void 0 : he.length) > 0 ? -1 : void 0, project: void 0, standardId: le, sectionSteelSpec: void 0, doNotSectionSteelSpec: void 0 });
    if (j.classify.basicClass === Pe.SECTION_STEEL.V) {
      let be;
      const me = [];
      for (const ge in oe.specificationMap) ge.indexOf("standard") > -1 ? be = oe.specificationMap[ge] : me.push(oe.specificationMap[ge]);
      oe.sectionSteelSpec = be, oe.doNotSectionSteelSpec = me.join(" * ");
    }
    return N(oe), oe;
  }
  function v(j) {
    return j.materialInventoryId && V.originInventoryInfo[j.materialInventoryId] ? V.originInventoryInfo[j.materialInventoryId].quantity - V.originInventoryInfo[j.materialInventoryId].frozenQuantity - r.value[j.materialInventoryId] + j.quantity : 999999999;
  }
  function N(j) {
    j.theoryTotalWeight, Ce([() => j.length, () => j.unitWeight, y], () => P(j), { immediate: true }), Ce([() => j.theoryWeight, () => j.quantity], () => {
      O(j);
    }, { immediate: true }), Ce([() => j.length, () => j.quantity], () => {
      L(j);
    }, { immediate: true }), Ce([() => j.theoryTotalWeight], () => x(j));
  }
  async function P(j) {
    j.theoryWeight = await xa({ length: j.length, unitWeight: j.unitWeight });
  }
  function L(j) {
    A(j.length) && j.quantity ? j.totalLength = Na({ length: j.length, quantity: j.quantity }) : j.totalLength = void 0;
  }
  function O(j) {
    A(j.theoryWeight) && j.quantity ? j.theoryTotalWeight = Be(j.theoryWeight * j.quantity, y.value.weight.precision) : j.theoryTotalWeight = void 0;
  }
  function x(j) {
    j.weighingTotalWeight = A(j.theoryTotalWeight) ? Be(j.theoryTotalWeight, y.value.weight.precision) : void 0;
  }
  function I(j, le) {
    c("search-inventory", j, le);
  }
  function Y(j, le, oe) {
    var ye, ce, se, he;
    if ((ce = (ye = b == null ? void 0 : b.submitResult) == null ? void 0 : ye.data) != null && ce.includes(oe.classifyId)) {
      const be = (se = b == null ? void 0 : b.submitResult) == null ? void 0 : se.data.findIndex((ge) => ge === oe.classifyId);
      V.list.filter((ge) => ge.classifyId === oe.classifyId).length === 1 && ((he = b == null ? void 0 : b.submitResult) == null || he.data.splice(be, 1));
    }
    E.value ? E.value.delListItem(j, le) : V.sectionSteelList.splice(le, 1);
  }
  function ee() {
    if (Ae(V.sectionSteelList)) return true;
    const { validResult: j, dealList: le } = T(V.sectionSteelList);
    return j && q(le), j;
  }
  function B() {
    if (Ae(V.sectionSteelList)) return true;
    const j = V.sectionSteelList.filter((le) => true);
    return q(j), true;
  }
  function q(j) {
    f(j), j.forEach((le, oe) => {
      var ye;
      V.sectionSteelList[oe].projectId = le.projectId, V.sectionSteelList[oe].project = (ye = m.value) == null ? void 0 : ye.find((ce) => V.sectionSteelList[oe].projectId === ce.id), V.sectionSteelList[oe].arrivalTime = le.arrivalTime;
    });
  }
  function ae(j) {
    j.projectId = void 0, j.project = void 0;
  }
  return o({ rowInit: R, rowWatch: N, validate: ee, TSValidate: B }), (j, le) => {
    const oe = vt, ye = Ve("table-cell-tag"), ce = jt, se = Ve("common-input-number"), he = Rl, be = Ve("common-button"), me = Ve("common-table"), ge = _t("empty-text");
    return w(), U(me, ii({ "cell-class-name": l(_), data: l(V).sectionSteelList, "row-style": S, "show-empty-symbol": false, stripe: false, "return-source-data": "", "row-key": "uid" }, j.$attrs), { default: p(() => [s(oe, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), s(oe, { align: "center", fixed: "left", label: "编号", prop: "serialNumber" }, { default: p(({ row: Le }) => [s(ye, { name: l(Ui).USE_INVENTORY.L, show: Le.requisitionMode === l(Ui).USE_INVENTORY.V, color: "#e6a23c" }, null, 8, ["name", "show"]), C("span", null, K(Le.serialNumber), 1)]), _: 1 }), s(oe, { align: "center", fixed: "left", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "" }, { default: p(({ row: Le }) => [s(ce, { content: Le.classifyParentFullName, disabled: !Le.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[ge, Le.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(oe, { align: "center", fixed: "left", label: "规格", prop: "specification", "show-overflow-tooltip": "" }, { default: p(({ row: Le }) => [s(ce, { content: Le.specificationLabels, placement: "top" }, { default: p(() => [C("span", null, K(Le.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), s(oe, { label: `定尺长度 (${l(y).length.unit})`, align: "center", prop: "length" }, { default: p(({ row: Le }) => [Le.requisitionMode !== l(Ui).USE_INVENTORY.V ? (w(), U(se, { key: 0, modelValue: Le.length, "onUpdate:modelValue": (Ie) => Le.length = Ie, controls: false, disabled: !!l(V).boolUsed, max: 999999999, min: 0, precision: l(y).length.precision, placeholder: "长", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision"])) : (w(), Q("span", pB, K(Le.length), 1))]), _: 1 }, 8, ["label"]), s(oe, { label: `数量 (${l(y).measure.unit})`, align: "center", prop: "quantity" }, { default: p(({ row: Le }) => [s(se, { modelValue: Le.quantity, "onUpdate:modelValue": (Ie) => Le.quantity = Ie, controls: false, disabled: !!l(V).boolUsed, max: v(Le), min: 1, precision: l(y).measure.precision, step: 5, "controls-position": "right", placeholder: "数量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "max", "precision"])]), _: 1 }, 8, ["label"]), s(oe, { label: "总长度 (m)", align: "center", prop: "totalLength" }), s(oe, { key: "weighingTotalWeight", label: `总重 (${l(y).weight.unit})`, align: "center", prop: "weighingTotalWeight" }, { default: p(({ row: Le }) => [s(se, { modelValue: Le.weighingTotalWeight, "onUpdate:modelValue": (Ie) => Le.weighingTotalWeight = Ie, controls: false, disabled: !!l(V).boolUsed, max: 999999999, min: 0, precision: l(y).weight.precision, "controls-position": "right", placeholder: "重量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision"])]), _: 1 }, 8, ["label"]), s(oe, { key: "projectId", align: "center", label: "项目", "min-width": "200", prop: "projectId" }, { default: p(({ row: Le, $index: Ie }) => [s(ca, { modelValue: Le.projectId, "onUpdate:modelValue": (Se) => Le.projectId = Se, branchCompanyId: l(V).branchCompanyId, disabled: l(Ae)(l(V).branchCompanyId) || !!l(V).boolUsed, isLumpSum: false, "show-extra": Ie !== 0, clearable: "", style: { width: "100%" }, onClear: (Se) => ae(Le) }, null, 8, ["modelValue", "onUpdate:modelValue", "branchCompanyId", "disabled", "show-extra", "onClear"])]), _: 1 }), s(oe, { key: "arrivalTime", align: "center", label: "期望到场时间", prop: "arrivalTime" }, { default: p(({ row: Le, $index: Ie }) => [s(he, { modelValue: Le.arrivalTime, "onUpdate:modelValue": (Se) => Le.arrivalTime = Se, disabled: !!l(V).boolUsed, disabledDate: (Se) => l(xn)(Se).valueOf() < l(xn)().subtract(1, "days").valueOf(), placeholder: Ie === 0 || l(Ae)(Le.arrivalTime) ? "选择日期" : "同上", size: "default", style: { width: "100%" }, type: "date", "value-format": "x" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "disabledDate", "placeholder"])]), _: 1 }), s(oe, { align: "center", fixed: "right", label: "库存", width: "90" }, { default: p(({ row: Le, $index: Ie }) => [s(be, { size: "default", type: "primary", onClick: (Se) => I(Le, Ie) }, { default: p(() => le[0] || (le[0] = [Te(" 查询")])), _: 2, __: [0] }, 1032, ["onClick"])]), _: 1 }), s(oe, { align: "center", fixed: "right", label: "操作", width: "70" }, { default: p(({ row: Le, $index: Ie }) => [s(be, { disabled: !!l(V).boolUsed, icon: "el-icon-delete", size: "default", type: "danger", onClick: (Se) => Y(Le.sn, Ie, Le) }, null, 8, ["disabled", "onClick"])]), _: 1 })]), _: 1 }, 16, ["cell-class-name", "data"]);
  };
} }, hB = Object.freeze(Object.defineProperty({ __proto__: null, default: Dv }, Symbol.toStringTag, { value: "Module" })), fB = { key: 1 }, gB = { key: 1 }, EB = { key: 1 }, yB = { key: 1 }, xv = { __name: "steel-coil-table", emits: ["search-inventory"], setup(e, { expose: o, emit: n }) {
  const c = n, u = Ge.STEEL_COIL.V, r = (B, q) => A(B) ? B > 0 : true, E = Ee(() => {
    let B = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], width: [{ required: true, message: "请填写宽度", trigger: "blur" }, { pattern: Vi, message: "宽度必须大于0", trigger: "blur" }], thickness: [{ required: true, message: "请填写厚度", trigger: "blur" }, { pattern: Vi, message: "厚度必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { pattern: Vi, message: "重量必须大于0", trigger: "blur" }], length: [{ validator: r, message: "长度必须大于0", trigger: "blur" }], arrivalTime: [{ required: true, message: "请选择需求时间", trigger: "change" }] };
    return M.level === Bt.CONSTRUCTION_SITE.V && (B = Object.assign(B, { projectId: [{ required: true, message: "请选择需求时间", trigger: "change" }] })), B;
  }), y = ft("matSpecRef"), { baseUnit: b } = ai(u), { cu: V, form: M } = Wi();
  function g({ row: B, rowIndex: q }) {
    var ae, j;
    if ((j = (ae = V == null ? void 0 : V.submitResult) == null ? void 0 : ae.data) != null && j.includes(B.classifyId)) return { backgroundColor: "#ffdede" };
  }
  const S = /* @__PURE__ */ new Map([["arrivalTime", "同上"], ["projectId", -1]]), { tableValidate: h, wrongCellMask: T, cleanUpData: _ } = ui({ rules: E, ditto: S, errorMsg: "请修正【钢卷清单】中标红的信息" }), { projectAllType: f } = Wa(), m = ft("steelDensityCfg");
  function R(B) {
    var ae, j;
    const q = Ct({ uid: Tt(), sn: B.sn, requisitionMode: Ui.PURCHASE.V, specificationLabels: B.specificationLabels, classifySerialNumber: B.classify.serialNumber, serialNumber: B.serialNumber, classifyId: B.classify.id, classifyFullName: B.classify.fullName, classifyName: B.classify.name, classifyParentFullName: B.classify.parentFullName, basicClass: B.classify.basicClass, specification: B.spec, specificationMap: B.specKV, measureUnit: B.classify.measureUnit, accountingUnit: B.classify.accountingUnit, accountingPrecision: B.classify.accountingPrecision, measurePrecision: B.classify.measurePrecision, quantity: void 0, color: void 0, brand: void 0, thickness: void 0, length: void 0, width: void 0, theoryLength: void 0, weighingTotalWeight: void 0, arrivalTime: ((ae = M.steelCoilList) == null ? void 0 : ae.length) > 0 ? "同上" : void 0, projectId: ((j = M.steelCoilList) == null ? void 0 : j.length) > 0 ? -1 : void 0, project: void 0, steelDensity: A(B.steelDensity) ? B.steelDensity : m.value[B.classify.id] });
    return v(q), q;
  }
  function v(B) {
    Ce([() => B.weighingTotalWeight, () => B.width, () => B.thickness, b], () => N(B)), Ce([() => B.theoryLength], () => P(B));
  }
  async function N(B) {
    B.theoryLength = await il({ classifyId: B.classifyId, name: B.classifyFullName, weight: B.weighingTotalWeight, width: B.width, thickness: B.thickness });
  }
  function P(B) {
    A(B.theoryLength) ? B.length = B.theoryLength * 1 : B.length = void 0;
  }
  function L(B, q) {
    c("search-inventory", B, q);
  }
  function O(B, q, ae) {
    var j, le, oe, ye;
    if ((le = (j = V == null ? void 0 : V.submitResult) == null ? void 0 : j.data) != null && le.includes(ae.classifyId)) {
      const ce = (oe = V == null ? void 0 : V.submitResult) == null ? void 0 : oe.data.findIndex((he) => he === ae.classifyId);
      M.list.filter((he) => he.classifyId === ae.classifyId).length === 1 && ((ye = V == null ? void 0 : V.submitResult) == null || ye.data.splice(ce, 1));
    }
    y.value ? y.value.delListItem(B, q) : M.steelCoilList.splice(q, 1);
  }
  function x() {
    if (Ae(M.steelCoilList)) return true;
    const { validResult: B, dealList: q } = h(M.steelCoilList);
    return B && Y(q), M.steelCoilList.forEach((ae) => {
      ae.quantity = ae.length;
    }), B;
  }
  function I() {
    if (Ae(M.steelCoilList)) return true;
    const B = M.steelCoilList.filter((q) => true);
    return Y(B), M.steelCoilList.forEach((q) => {
      q.quantity = q.length;
    }), true;
  }
  function Y(B) {
    _(B), B.forEach((q, ae) => {
      var j;
      M.steelCoilList[ae].projectId = q.projectId, M.steelCoilList[ae].project = (j = f.value) == null ? void 0 : j.find((le) => M.steelCoilList[ae].projectId === le.id), M.steelCoilList[ae].arrivalTime = q.arrivalTime;
    });
  }
  function ee(B) {
    B.projectId = void 0, B.project = void 0;
  }
  return o({ rowInit: R, rowWatch: v, validate: x, TSValidate: I }), (B, q) => {
    const ae = vt, j = Ve("table-cell-tag"), le = jt, oe = Ve("common-input-number"), ye = Mt, ce = Rl, se = Ve("common-button"), he = Ve("common-table"), be = _t("empty-text");
    return w(), U(he, ii({ "cell-class-name": l(T), data: l(M).steelCoilList, "row-style": g, "show-empty-symbol": false, stripe: false, "return-source-data": "", "row-key": "uid" }, B.$attrs), { default: p(() => [s(ae, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), s(ae, { align: "center", fixed: "left", label: "编号", prop: "serialNumber" }, { default: p(({ row: me }) => [s(j, { name: l(Ui).USE_INVENTORY.L, show: me.requisitionMode === l(Ui).USE_INVENTORY.V, color: "#e6a23c" }, null, 8, ["name", "show"]), C("span", null, K(me.serialNumber), 1)]), _: 1 }), s(ae, { align: "center", fixed: "left", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "" }, { default: p(({ row: me }) => [s(le, { content: me.classifyParentFullName, disabled: !me.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[be, me.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(ae, { align: "center", fixed: "left", label: "规格", prop: "specification", "show-overflow-tooltip": "" }, { default: p(({ row: me }) => [s(le, { content: me.specificationLabels, placement: "top" }, { default: p(() => [C("span", null, K(me.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), s(ae, { key: "weighingTotalWeight", label: `总重 (${l(b).weight.unit})`, align: "center", prop: "weighingTotalWeight" }, { default: p(({ row: me }) => [s(oe, { modelValue: me.weighingTotalWeight, "onUpdate:modelValue": (ge) => me.weighingTotalWeight = ge, controls: false, disabled: !!l(M).boolUsed, max: 999999999, min: 0, precision: l(b).weight.precision, "controls-position": "right", placeholder: "重量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision"])]), _: 1 }, 8, ["label"]), s(ae, { label: `厚 (${l(b).thickness.unit})`, align: "center", prop: "thickness" }, { default: p(({ row: me }) => [me.requisitionMode !== l(Ui).USE_INVENTORY.V ? (w(), U(oe, { key: 0, modelValue: me.thickness, "onUpdate:modelValue": (ge) => me.thickness = ge, controls: false, disabled: !!l(M).boolUsed, max: 99999999, min: 0, precision: l(b).thickness.precision, "controls-position": "right", placeholder: "厚", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision"])) : (w(), Q("span", fB, K(me.thickness), 1))]), _: 1 }, 8, ["label"]), s(ae, { label: `宽 (${l(b).width.unit})`, align: "center", prop: "width" }, { default: p(({ row: me }) => [me.requisitionMode !== l(Ui).USE_INVENTORY.V ? (w(), U(oe, { key: 0, modelValue: me.width, "onUpdate:modelValue": (ge) => me.width = ge, controls: false, disabled: !!l(M).boolUsed, max: 99999999, min: 0, precision: l(b).width.precision, "controls-position": "right", placeholder: "宽", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision"])) : (w(), Q("span", gB, K(me.width), 1))]), _: 1 }, 8, ["label"]), s(ae, { label: "长 (m)", align: "center", prop: "length" }, { default: p(({ row: me }) => [me.requisitionMode !== l(Ui).USE_INVENTORY.V ? (w(), U(oe, { key: 0, modelValue: me.length, "onUpdate:modelValue": (ge) => me.length = ge, controls: false, disabled: !!l(M).boolUsed, max: 999999999, min: 0, precision: me.measurePrecision, placeholder: "长", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision"])) : (w(), Q("span", EB, K(me.length), 1))]), _: 1 }), s(ae, { align: "center", label: "颜色", prop: "color" }, { default: p(({ row: me }) => [me.requisitionMode !== l(Ui).USE_INVENTORY.V ? (w(), U(ye, { key: 0, modelValue: me.color, "onUpdate:modelValue": (ge) => me.color = ge, modelModifiers: { trim: true }, disabled: !!l(M).boolUsed, maxlength: "20", placeholder: "颜色", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])) : (w(), Q("span", yB, K(me.color), 1))]), _: 1 }), s(ae, { key: "projectId", align: "center", label: "项目", "min-width": "200", prop: "projectId" }, { default: p(({ row: me, $index: ge }) => [s(ca, { modelValue: me.projectId, "onUpdate:modelValue": (Le) => me.projectId = Le, branchCompanyId: l(M).branchCompanyId, disabled: l(Ae)(l(M).branchCompanyId) || !!l(M).boolUsed, isLumpSum: false, "show-extra": ge !== 0, clearable: "", style: { width: "100%" }, onClear: (Le) => ee(me) }, null, 8, ["modelValue", "onUpdate:modelValue", "branchCompanyId", "disabled", "show-extra", "onClear"])]), _: 1 }), s(ae, { key: "arrivalTime", align: "center", label: "期望到场时间", prop: "arrivalTime" }, { default: p(({ row: me, $index: ge }) => [s(ce, { modelValue: me.arrivalTime, "onUpdate:modelValue": (Le) => me.arrivalTime = Le, disabled: !!l(M).boolUsed, disabledDate: (Le) => l(xn)(Le).valueOf() < l(xn)().subtract(1, "days").valueOf(), placeholder: ge === 0 || l(Ae)(me.arrivalTime) ? "选择日期" : "同上", size: "default", style: { width: "100%" }, type: "date", "value-format": "x" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "disabledDate", "placeholder"])]), _: 1 }), s(ae, { align: "center", fixed: "right", label: "库存", width: "90" }, { default: p(({ row: me, $index: ge }) => [s(se, { size: "default", type: "primary", onClick: (Le) => L(me, ge) }, { default: p(() => q[0] || (q[0] = [Te(" 查询 ")])), _: 2, __: [0] }, 1032, ["onClick"])]), _: 1 }), s(ae, { align: "center", fixed: "right", label: "操作", width: "70" }, { default: p(({ row: me, $index: ge }) => [s(se, { disabled: !!l(M).boolUsed, icon: "el-icon-delete", size: "default", type: "danger", onClick: (Le) => O(me.sn, ge, me) }, null, 8, ["disabled", "onClick"])]), _: 1 })]), _: 1 }, 16, ["cell-class-name", "data"]);
  };
} }, TB = Object.freeze(Object.defineProperty({ __proto__: null, default: xv }, Symbol.toStringTag, { value: "Module" })), _B = { key: 1 }, Uv = { __name: "other-steel-materials-table", emits: ["search-inventory"], setup(e, { expose: o, emit: n }) {
  const c = n, u = ft("useInventoryInfo"), r = ft("matSpecRef"), { cu: E, form: y } = Wi(), b = (x, I) => I.measureUnit ? !!x : true, V = Ee(() => {
    let x = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], quantity: [{ validator: b, message: "请填写数量", trigger: "blur" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }, { pattern: Vi, message: "核算量必须大于0", trigger: "blur" }], arrivalTime: [{ required: true, message: "请选择需求时间", trigger: "change" }] };
    return y.level === Bt.CONSTRUCTION_SITE.V && (x = Object.assign(x, { projectId: [{ required: true, message: "请选择需求时间", trigger: "change" }] })), x;
  }), M = /* @__PURE__ */ new Map([["arrivalTime", "同上"], ["projectId", -1]]), { tableValidate: g, wrongCellMask: S, cleanUpData: h } = ui({ rules: V, ditto: M }), { projectAllType: T } = Wa();
  function _({ row: x, rowIndex: I }) {
    var Y, ee;
    if ((ee = (Y = E == null ? void 0 : E.submitResult) == null ? void 0 : Y.data) != null && ee.includes(x.classifyId)) return { backgroundColor: "#ffdede" };
  }
  function f(x) {
    var Y, ee;
    return Ct({ uid: Tt(), sn: x.sn, requisitionMode: Ui.PURCHASE.V, specificationLabels: x.specificationLabels, classifySerialNumber: x.classify.serialNumber, serialNumber: x.serialNumber, classifyId: x.classify.id, classifyFullPathId: x.classify.fullPathId, classifyFullName: x.classify.fullName, classifyName: x.classify.name, classifyParentFullName: x.classify.parentFullName, basicClass: x.classify.basicClass, specification: x.spec, specificationMap: x.specKV, measureUnit: x.classify.measureUnit, accountingUnit: x.classify.accountingUnit, accountingPrecision: x.classify.accountingPrecision, measurePrecision: x.classify.measurePrecision, mete: void 0, quantity: void 0, arrivalTime: ((Y = y.otherSteelMaterialList) == null ? void 0 : Y.length) > 0 ? "同上" : void 0, projectId: ((ee = y.otherSteelMaterialList) == null ? void 0 : ee.length) > 0 ? -1 : void 0 });
  }
  function m(x) {
    return x.materialInventoryId && y.originInventoryInfo[x.materialInventoryId] ? y.originInventoryInfo[x.materialInventoryId].quantity - y.originInventoryInfo[x.materialInventoryId].frozenQuantity - u.value[x.materialInventoryId] + x.quantity : 999999999;
  }
  function R(x, I) {
    c("search-inventory", x, I);
  }
  function v(x, I, Y) {
    var ee, B, q, ae;
    if ((B = (ee = E == null ? void 0 : E.submitResult) == null ? void 0 : ee.data) != null && B.includes(Y.classifyId)) {
      const j = (q = E == null ? void 0 : E.submitResult) == null ? void 0 : q.data.findIndex((oe) => oe === Y.classifyId);
      y.list.filter((oe) => oe.classifyId === Y.classifyId).length === 1 && ((ae = E == null ? void 0 : E.submitResult) == null || ae.data.splice(j, 1));
    }
    r.value ? r.value.delListItem(x, I) : y.otherSteelMaterialList.splice(I, 1);
  }
  function N() {
    if (Ae(y.otherSteelMaterialList)) return true;
    const { validResult: x, dealList: I } = g(y.otherSteelMaterialList);
    return x && L(I), x;
  }
  function P() {
    if (Ae(y.otherSteelMaterialList)) return true;
    const x = y.otherSteelMaterialList.filter((I) => true);
    return L(x), true;
  }
  function L(x) {
    h(x), x.forEach((I, Y) => {
      var ee;
      y.otherSteelMaterialList[Y].projectId = I.projectId, y.otherSteelMaterialList[Y].project = (ee = T.value) == null ? void 0 : ee.find((B) => y.otherSteelMaterialList[Y].projectId === B.id), y.otherSteelMaterialList[Y].arrivalTime = I.arrivalTime;
    });
  }
  function O(x) {
    x.projectId = void 0, x.project = void 0;
  }
  return o({ rowInit: f, validate: N, TSValidate: P }), (x, I) => {
    const Y = vt, ee = Ve("table-cell-tag"), B = jt, q = Ve("common-input-number"), ae = Mt, j = Rl, le = Ve("common-button"), oe = Ve("common-table"), ye = _t("empty-text");
    return w(), U(oe, ii({ "cell-class-name": l(S), data: l(y).otherSteelMaterialList, "row-style": _, "show-empty-symbol": false, stripe: false, "return-source-data": "", "row-key": "uid" }, x.$attrs), { default: p(() => [s(Y, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), s(Y, { align: "center", fixed: "left", label: "编号", prop: "serialNumber", "show-overflow-tooltip": "" }, { default: p(({ row: ce }) => [s(ee, { name: l(Ui).USE_INVENTORY.L, show: ce.requisitionMode === l(Ui).USE_INVENTORY.V, color: "#e6a23c" }, null, 8, ["name", "show"]), C("span", null, K(ce.serialNumber), 1)]), _: 1 }), s(Y, { align: "center", fixed: "left", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "" }, { default: p(({ row: ce }) => [s(B, { content: ce.classifyParentFullName, disabled: !ce.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[ye, ce.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(Y, { align: "center", fixed: "left", label: "规格", prop: "specification", "show-overflow-tooltip": "" }, { default: p(({ row: ce }) => [s(B, { content: ce.specificationLabels, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[ye, ce.specification]])]), _: 2 }, 1032, ["content"])]), _: 1 }), s(Y, { align: "center", label: "计量单位", prop: "measureUnit" }, { default: p(({ row: ce }) => [qe((w(), Q("span", null, [Te(K(ce.measureUnit), 1)])), [[ye]])]), _: 1 }), s(Y, { align: "center", label: "数量", prop: "quantity" }, { default: p(({ row: ce }) => [ce.measureUnit ? (w(), U(q, { key: 0, modelValue: ce.quantity, "onUpdate:modelValue": (se) => ce.quantity = se, controls: false, disabled: !!l(y).boolUsed, max: m(ce), min: 0, precision: ce.measurePrecision, step: 1, placeholder: "数量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "max", "precision"])) : qe((w(), Q("span", _B, null, 512)), [[ye]])]), _: 1 }), s(Y, { align: "center", label: "核算单位", prop: "accountingUnit" }, { default: p(({ row: ce }) => [qe((w(), Q("span", null, [Te(K(ce.accountingUnit), 1)])), [[ye]])]), _: 1 }), s(Y, { align: "center", label: "核算量", prop: "mete" }, { default: p(({ row: ce }) => [s(q, { modelValue: ce.mete, "onUpdate:modelValue": (se) => ce.mete = se, controls: false, disabled: !!l(y).boolUsed, max: 999999999, min: 1e-6, precision: ce.accountingPrecision, step: 1, placeholder: "核算量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision"])]), _: 1 }), s(Y, { align: "center", label: "颜色", prop: "color" }, { default: p(({ row: ce }) => [s(ae, { modelValue: ce.color, "onUpdate:modelValue": (se) => ce.color = se, modelModifiers: { trim: true }, disabled: !!l(y).boolUsed, maxlength: "20", placeholder: "颜色", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), _: 1 }), s(Y, { align: "center", label: "项目", "min-width": "200", prop: "projectId" }, { default: p(({ row: ce, $index: se }) => [s(ca, { modelValue: ce.projectId, "onUpdate:modelValue": (he) => ce.projectId = he, branchCompanyId: l(y).branchCompanyId, disabled: l(Ae)(l(y).branchCompanyId) || !!l(y).boolUsed, isLumpSum: false, "show-extra": se !== 0, clearable: "", style: { width: "100%" }, onClear: (he) => O(ce) }, null, 8, ["modelValue", "onUpdate:modelValue", "branchCompanyId", "disabled", "show-extra", "onClear"])]), _: 1 }), s(Y, { align: "center", label: "期望到场时间", prop: "arrivalTime" }, { default: p(({ row: ce, $index: se }) => [s(j, { modelValue: ce.arrivalTime, "onUpdate:modelValue": (he) => ce.arrivalTime = he, disabled: !!l(y).boolUsed, disabledDate: (he) => l($a)(he).valueOf() < l($a)().subtract(1, "days").valueOf(), placeholder: se === 0 || l(Ae)(ce.arrivalTime) ? "选择日期" : "同上", size: "default", style: { width: "100%" }, type: "date", "value-format": "x" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "disabledDate", "placeholder"])]), _: 1 }), s(Y, { align: "center", fixed: "right", label: "库存", width: "90" }, { default: p(({ row: ce, $index: se }) => [s(le, { size: "default", type: "primary", onClick: (he) => R(ce, se) }, { default: p(() => I[0] || (I[0] = [Te(" 查询 ")])), _: 2, __: [0] }, 1032, ["onClick"])]), _: 1 }), l(y).boolUsed ? H("", true) : (w(), U(Y, { key: 0, align: "center", fixed: "right", label: "操作", width: "70" }, { default: p(({ row: ce, $index: se }) => [s(le, { disabled: !!l(y).boolUsed, icon: "el-icon-delete", size: "default", type: "danger", onClick: (he) => v(ce.sn, se, ce) }, null, 8, ["disabled", "onClick"])]), _: 1 }))]), _: 1 }, 16, ["cell-class-name", "data"]);
  };
} }, bB = Object.freeze(Object.defineProperty({ __proto__: null, default: Uv }, Symbol.toStringTag, { value: "Module" })), Io = (e) => {
  const o = Ht(), n = Ee(() => o.state.config.loaded.workshopNameV2);
  if (n.value || o.dispatch("config/fetchWorkshopNameV2"), e) {
    const c = Ce(n, (u) => {
      u && setTimeout(() => {
        e(), c();
      }, 0);
    }, { immediate: true });
  }
  return { workshopNameV2: Ee(() => o.state.config.workshopNameV2), workshopNameV2KV: Ee(() => o.state.config.workshopNameV2KV), loaded: n };
}, Ul = { __name: "workshop-select-v2", props: { modelValue: { type: [Array, Number, String], default: void 0 }, size: { type: String, default: "default" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, showOptionAll: { type: Boolean, default: false }, placeholder: { type: String, default: "请选择仓库" }, type: { type: [Number, String], default: void 0 }, showExtra: { type: Boolean, default: false } }, emits: ["change", "update:modelValue", "changeData"], setup(e, { emit: o }) {
  const n = o, c = e, u = Z(), { loaded: r, workshopNameV2: E } = Io(), y = Ee(() => {
    let V = E.value;
    return c.type && (V = c.type === lu.NORMAL.V ? V.filter((M) => !M.workshopId) : V.filter((M) => M.workshopId)), V;
  });
  Ce(() => c.modelValue, (V) => {
    u.value = V;
  }, { immediate: true });
  function b(V) {
    let M = V;
    Ae(M) && (M = void 0);
    const g = !el(M, c.modelValue), S = Ae(M) && Ae(c.modelValue);
    g && !S && (n("update:modelValue", M), n("change", M));
    const h = y.value.find((T) => T.id === M);
    n("changeData", h);
  }
  return (V, M) => {
    const g = jt, S = Ve("common-select-v2");
    return w(), U(S, ii({ modelValue: u.value, "onUpdate:modelValue": M[0] || (M[0] = (h) => u.value = h), allLabelText: "全部", clearable: e.clearable, disabled: e.disabled, loading: !l(r), multiple: e.multiple, options: y.value, placeholder: e.placeholder, showExtra: e.showExtra, showOptionAll: e.showOptionAll, size: e.size, filterable: "" }, V.$attrs, { onChange: b }), { view: p(({ data: h }) => [s(g, { class: "item", effect: "dark", content: h.name, placement: "left" }, { default: p(() => [C("span", null, K(h.name), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }, 16, ["modelValue", "clearable", "disabled", "loading", "multiple", "options", "placeholder", "showExtra", "showOptionAll", "size"]);
  };
} }, Sr = (e) => {
  const o = Ht(), n = Ee(() => o.state.config.loaded.warehouseV2);
  if (n.value || o.dispatch("config/fetchWarehouseV2"), e) {
    const c = Ce(n, (u) => {
      u && setTimeout(() => {
        e(), c();
      }, 0);
    }, { immediate: true });
  }
  return { warehouseV2: Ee(() => o.state.config.warehouseV2), loaded: n };
};
const VB = { __name: "warehouse-select-v2", props: { modelValue: { type: [Array, Number, String] }, workshopId: { type: [Array, Number] }, showAll: { type: Boolean, default: false }, showForbidden: { type: Boolean, default: false }, basicClass: { type: Number }, viewsDetail: { type: Boolean, default: false }, size: { type: String, default: "default" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, default: { type: Boolean, default: false }, onlyOneDefault: { type: Boolean, default: false }, placeholder: { type: String, default: "选择存储位置" } }, emits: ["change", "update:modelValue", "infoChange", "changeData"], setup(e, { emit: o }) {
  const n = o, c = e, u = Z(), { loaded: r, warehouseV2: E } = Sr(), y = Ee(() => {
    let S = E.value;
    return c.showForbidden || (S = S.filter((h) => h.enabled)), c.workshopId ? Array.isArray(c.workshopId) ? S = S.filter((h) => c.workshopId.includes(h.workshopId)) : S = S.filter((h) => c.workshopId === h.workshopId) : S = c.showAll ? S : [], c.basicClass && (S = S.filter((h) => h.materialType & c.basicClass)), S;
  });
  Ce(y, (S) => {
    M();
  }), Ce(() => c.modelValue, (S) => {
    u.value = S, g();
  }, { immediate: true });
  function b(S) {
    return Ra.getBits(Pe.ENUM, S.materialType, "L").join(" | ");
  }
  function V(S) {
    let h = S;
    Ae(h) && (h = void 0);
    const T = !el(h, c.modelValue), _ = Ae(h) && Ae(c.modelValue);
    if (T && !_) {
      const m = y.value.find((R) => R.id === h) || {};
      n("update:modelValue", h), n("infoChange", m), n("change", h);
    }
    const f = y.value.find((m) => m.id === h) || {};
    n("changeData", f);
  }
  function M() {
    g();
  }
  function g() {
    if (!(Ae(y.value) || u.value)) {
      if (c.onlyOneDefault && y.value.length === 1) {
        u.value = y.value[0].value, V(u.value);
        return;
      }
      if (c.default) {
        u.value = y.value[0].value, V(u.value);
        return;
      }
      V(u.value);
    }
  }
  return (S, h) => {
    const T = jt, _ = Ve("common-select-v2");
    return w(), U(_, { modelValue: u.value, "onUpdate:modelValue": h[0] || (h[0] = (f) => u.value = f), clearable: e.clearable, "collapse-tags": e.collapseTags, disabled: e.disabled, loading: !l(r), multiple: e.multiple, options: y.value, placeholder: e.placeholder, size: e.size, filterable: "", onChange: V }, { view: p(({ data: f }) => [s(T, { class: "item", effect: "dark", content: `${f.name}【存储类型：${b(f)}】`, placement: "left" }, { default: p(() => [C("span", null, K(f.name), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }, 8, ["modelValue", "clearable", "collapse-tags", "disabled", "loading", "multiple", "options", "placeholder", "size"]);
  };
} }, xs = ut(VB, [["__scopeId", "data-v-2d95fa10"]]);
const wB = { class: "head-container", style: { display: "flex" } }, SB = { __name: "inventory-drawer", props: { visible: { type: Boolean, default: false }, params: { type: Object, default: () => {
} } }, emits: ["update:visible", "use-inventory"], setup(e, { emit: o }) {
  const n = Z(), c = o, u = e, { visible: r, handleClose: E } = Ta({ emit: c, props: u, field: "visible", showHook: N }), { maxHeight: y } = Kt({ extraBox: [".el-drawer__header", ".head-container"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, paginate: true, extraHeight: 50 }, n), b = Ee(() => g.value.basicClass), V = { projectWarehouseType: Do.PUBLIC.V, workshopId: void 0, warehouseId: void 0, projectId: void 0, basicClass: void 0 }, M = Z([["project", "parse-project"]]), g = Z({}), S = Z(false), h = Z([]), T = ft("useInventoryInfo");
  ai();
  const { tablePageSize: _ } = ka("tablePageSize"), f = Ct({ pageNumber: 1, pageSize: _.value }), m = Z(0);
  function R(x) {
    f.pageNumber = 1, f.pageSize = x, L();
  }
  function v(x) {
    f.pageNumber = x, L();
  }
  function N() {
    var x;
    g.value = V, g.value.basicClass = (x = u.params) == null ? void 0 : x.basicClass, L();
  }
  function P(x) {
    m.value = x;
  }
  async function L() {
    try {
      S.value = true;
      const { classifyId: x, specification: I, thickness: Y, width: ee, length: B } = u.params, q = { specification: I, classifyId: x, thickness: Y, width: ee, length: B, ...g.value, ...f }, { content: ae, totalElements: j } = await T5(q);
      P(j), await Qt(ae), await Ut(ae, { toSmallest: false, toNum: true }), h.value = ae.map((le) => {
        var ye;
        let oe = le.frozenQuantity || 0;
        return (ye = T.value) != null && ye[le.id] && (oe += T.value[le.id]), le.canUseQuantity = le.quantity - oe, le;
      });
    } catch (x) {
      console.log("获取可申购库存失败", x);
    } finally {
      S.value = false;
    }
  }
  const O = Ee(() => {
    var x;
    return ((x = g.value) == null ? void 0 : x.projectWarehouseType) === Do.PROJECT.V;
  });
  return (x, I) => {
    const Y = Ve("common-radio-button"), ee = Ve("table-cell-tag"), B = vt, q = Ve("common-table"), ae = Fn, j = Ve("common-drawer"), le = oi;
    return w(), U(j, { ref_key: "drawerRef", ref: n, modelValue: l(r), "onUpdate:modelValue": I[4] || (I[4] = (oe) => Gt(r) ? r.value = oe : null), "before-close": l(E), direction: "rtl", size: "90%", title: "库存一览" }, { titleRight: p(() => I[5] || (I[5] = [])), content: p(() => [C("div", wB, [s(Y, { modelValue: g.value.projectWarehouseType, "onUpdate:modelValue": I[0] || (I[0] = (oe) => g.value.projectWarehouseType = oe), options: l(Do).ENUM, class: "filter-item", size: "default", type: "enum", onChange: L }, null, 8, ["modelValue", "options"]), s(Ul, { modelValue: g.value.workshopId, "onUpdate:modelValue": I[1] || (I[1] = (oe) => g.value.workshopId = oe), class: "filter-item", clearable: "", filterable: "", size: "default", onChange: L }, null, 8, ["modelValue"]), s(xs, { modelValue: g.value.warehouseId, "onUpdate:modelValue": I[2] || (I[2] = (oe) => g.value.warehouseId = oe), "workshop-id": g.value.workshopId, class: "filter-item", clearable: "", filterable: "", "show-all": "", size: "default", onChange: L }, null, 8, ["modelValue", "workshop-id"]), s(ca, { modelValue: g.value.projectId, "onUpdate:modelValue": I[3] || (I[3] = (oe) => g.value.projectId = oe), class: "filter-item", isAll: "", clearable: "", filterable: "", size: "default", onChange: L }, null, 8, ["modelValue"])]), qe((w(), U(q, { data: h.value, "data-format": M.value, "max-height": l(y), style: { width: "100%" } }, { default: p(() => [s(fa, { "basic-class": b.value, specMerge: "" }, { snTag: p(({ row: oe }) => {
      var ye;
      return [!((ye = oe == null ? void 0 : oe.project) != null && ye.id) && g.value.warehouseType === l(Do).PROJECT.V ? (w(), U(ee, { key: 0, offset: 15, name: "公共库" })) : H("", true)];
    }), _: 1 }, 8, ["basic-class"]), s(za, { "basic-class": b.value }, null, 8, ["basic-class"]), s(Ba, { "basic-class": b.value }, null, 8, ["basic-class"]), g.value.warehouseType === l(Do).PROJECT.V ? (w(), U(B, { key: 0, align: "left", label: "项目", "min-width": "120px", prop: "project", "show-overflow-tooltip": "" })) : H("", true), s(xl, { "show-area": O.value, "show-monomer": O.value, "show-project": O.value, "show-workshop": "" }, null, 8, ["show-area", "show-monomer", "show-project"])]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[le, S.value]]), s(ae, { "current-page": f.pageNumber, "page-size": f.pageSize, total: m.value, layout: "total, prev, pager, next, sizes", style: { "margin-top": "8px" }, onSizeChange: R, onCurrentChange: v }, null, 8, ["current-page", "page-size", "total"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Tu = ut(SB, [["__scopeId", "data-v-d05f6208"]]), vB = Object.freeze(Object.defineProperty({ __proto__: null, default: Tu }, Symbol.toStringTag, { value: "Module" }));
const RB = { __name: "index", props: { template: { type: Object }, openLoading: { type: Boolean, default: false }, accept: { type: String, default: ".xls,.xlsx" }, successMessage: { type: String, default: "上传成功" }, size: { type: String, default: "default" }, icon: { type: String, default: "el-icon-upload" }, btnName: { type: String, default: "" }, btnType: { type: String, default: "primary" }, btnSize: { type: String, default: "default" }, tip: { type: String, default: "" }, disabled: { type: Boolean, default: false }, limit: { type: Number, default: void 0 }, sizeLimit: { type: Number, default: void 0 } }, emits: ["data", "success"], setup(e, { emit: o }) {
  const n = o, c = e, u = Z(), r = Z(false);
  function E(V) {
    return O9(V, { accept: c.accept, sizeLimit: c.sizeLimit });
  }
  async function y(V, M) {
    let g = null;
    try {
      c.openLoading && (g = Dn.service({ lock: true, text: "正在导入数据，请稍后", fullscreen: true, background: "rgba(255, 255, 255, 0.5)" })), r.value = true, await Promise.resolve(), u.value.clearFiles();
      let S = await k9(V.raw);
      typeof c.template == "object" && (S = await D9(S, c.template)), A(S) && (n("data", S), n("success", S));
    } catch (S) {
      ot.error({ message: S.message, duration: 5e3 });
    } finally {
      r.value = false, g && g.close();
    }
  }
  function b(V, M) {
    ot.warning(`当前限制选择 ${c.limit} 个文件，本次选择了 ${V.length} 个文件，共选择了 ${V.length + M.length} 个文件`);
  }
  return (V, M) => {
    const g = Ve("common-button");
    return w(), U(l(DV), { ref_key: "uploadRef", ref: u, class: "upload-excel-resolve", action: "", "before-upload": E, "on-change": y, "on-exceed": b, disabled: c.disabled, limit: c.limit, accept: c.accept, "auto-upload": false, "show-file-list": false }, { default: p(() => [s(g, { loading: c.resolveLoading, disabled: c.disabled, icon: c.icon, size: c.btnSize, type: c.btnType }, { default: p(() => [Te(K(c.btnName), 1)]), _: 1 }, 8, ["loading", "disabled", "icon", "size", "type"])]), _: 1 }, 8, ["disabled", "limit", "accept"]);
  };
} }, Ro = ut(RB, [["__scopeId", "data-v-e0366a4d"]]);
const MB = { class: "basic_subscription_information_right" }, AB = { key: 0 }, NB = { __name: "index", props: { leftLabel: { type: String, default: "物料种类" }, rightLabel: { type: [Number, String], default: void 0 }, unit: { type: [Number, String], default: "种" }, showUnit: { type: Boolean, default: false }, bgc: { type: String, default: "#f0940a" } }, setup(e) {
  return (o, n) => (w(), Q("div", { style: ri(`border: ${e.bgc} solid 1px;`), class: "basic_subscription_information" }, [C("div", { style: ri(`background-color:${e.bgc};`), class: "basic_subscription_information_left" }, K(e.leftLabel), 5), C("div", MB, [Te(K(e.rightLabel) + " ", 1), e.showUnit ? (w(), Q("span", AB, K(e.unit), 1)) : H("", true)])], 4));
} }, _u = ut(NB, [["__scopeId", "data-v-96c3efe7"]]), LB = Object.freeze(Object.defineProperty({ __proto__: null, default: _u }, Symbol.toStringTag, { value: "Module" }));
const IB = { class: "steel-requisitions-application-container" }, CB = { class: "filter-container" }, PB = { class: "filter-left-box" }, OB = { class: "filter-right-box" }, kB = { class: "filter-item" }, DB = { __name: "index", props: { detail: { type: Object }, isEdit: { type: Boolean, default: false }, isTsData: { type: Boolean, default: false } }, emits: ["success"], setup(e, { expose: o, emit: n }) {
  const c = n, u = e, { baseUnit: r } = ai(), E = { steelPlateList: { K: "steelPlateList", L: "钢板", V: Ge.STEEL_PLATE.V, TABLE: kv }, sectionSteelList: { K: "sectionSteelList", L: "型材", V: Ge.SECTION_STEEL.V, TABLE: Dv }, steelCoilList: { K: "steelCoilList", L: "钢卷", V: Ge.STEEL_COIL.V, TABLE: xv }, otherSteelMaterialList: { K: "otherSteelMaterialList", L: "其它钢材", V: Pe.OTHER_STEEL_MATERIALS.V, TABLE: Uv } }, y = { list: [], steelPlateList: [], sectionSteelList: [], steelCoilList: [], otherSteelMaterialList: [], originInventoryInfo: {} }, b = Z(), V = Z(), M = Z(), g = Z(), S = Z(false), h = Z(false), T = Z({}), _ = Z(), f = Z(), m = Z([]), R = Z({});
  yi("useInventoryInfo", R);
  const v = Ct({ steelPlateList: null, sectionSteelList: null, steelCoilList: null, otherSteelMaterialList: null });
  yi("matSpecRef", V);
  const N = (Se) => {
    const X = { steelPlateList: null, sectionSteelList: null, steelCoilList: null, otherSteelMaterialList: null }, $ = { steelPlateList: null, sectionSteelList: null, steelCoilList: null, otherSteelMaterialList: null }, k = ["steelPlateList", "sectionSteelList", "steelCoilList", "otherSteelMaterialList"];
    let J = false;
    k.forEach((z) => {
      A(Se[z]) && (J || (J = true, f.value = z), Se[z] = Se[z].map((F) => Ct(F)), X[z] = Ce(v, (F) => {
        F[z] && (Se[z].forEach((G) => F[z].rowWatch(G)), $[z] = Ce(V, () => {
          V.value && (V.value.initSelected(Se[z].map((G) => ({ sn: G.sn, classifyId: G.classifyId }))), pt(() => {
            $[z]();
          }));
        }, { immediate: true }), pt(() => {
          X[z]();
        }));
      }, { immediate: true, deep: true }));
    });
  }, { cu: P, form: L, FORM: O } = Pa({ title: "钢材申购", defaultForm: y, useDraftCallback: N, clearDraftCallback: ge, api: u.isEdit ? nn.edit : nn.add }, M, u.detail), x = Ee(() => {
    var Se;
    return (Se = L.list) == null ? void 0 : Se.filter((X) => {
      var $, k;
      return (k = ($ = P == null ? void 0 : P.submitResult) == null ? void 0 : $.data) == null ? void 0 : k.includes(X.classifyId);
    });
  });
  Dt(() => {
    var Se, X, $, k, J, z, F, G;
    if ((Se = m.value) != null && Se.length) {
      const ie = {};
      for (let ue = 0; ue < m.value.length; ue++) {
        const ne = m.value[ue];
        if (ne.requisitionMode === Ui.USE_INVENTORY.V) {
          const te = (X = L.originInventoryInfo[ne.materialInventoryId]) == null ? void 0 : X.basicClass, de = te & Ge.STEEL_COIL.V && ne.basicClass & Ge.STEEL_COIL.V ? St(ne.length, (k = ($ = r.value[ne.basicClass]) == null ? void 0 : $.length) == null ? void 0 : k.unit, (z = (J = r.value[te]) == null ? void 0 : J.measure) == null ? void 0 : z.unit, (G = (F = r.value[te]) == null ? void 0 : F.measure) == null ? void 0 : G.precision) : ne.quantity;
          ne.useQuantity = de, ie[ne.materialInventoryId] ? ie[ne.materialInventoryId] += de : ie[ne.materialInventoryId] = de;
        }
      }
      R.value = ie;
    }
  });
  const I = Ee(() => {
    switch (f.value) {
      case E.steelPlateList.K:
        return gm;
      case E.sectionSteelList.K:
        return Av;
      case E.steelCoilList.K:
        return Nv;
      case E.otherSteelMaterialList.K:
        return Lv;
      default:
        return gm;
    }
  });
  Ce(() => u.detail, (Se = {}) => {
    L.materialType = Se.materialType, L.branchCompanyId = Se.branchCompanyId, L.level = Se.level, L.serialNumber = Se.serialNumber;
  }, { deep: true, immediate: true });
  const { maxHeight: Y } = Kt({ mainBox: ".material-table-spec-select", extraBox: ".el-drawer__header", wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, minHeight: 300 }, () => g.value.loaded), { maxHeight: ee, maxHeightStyle: B } = Kt({ mainBox: ".requisitions-application-record-form", extraBox: [".el-drawer__header", ".filter-container", ".requisitions-application-header", ".requisitions-application-select", ".requisitions-application-footer"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, navbar: false, minHeight: 300, extraHeight: u.isTsData ? 0 : 200 }), q = Ee(() => {
    var F;
    let Se = [], X = [], $ = [], k = [], J = [], z = [];
    return A(L.steelPlateList) && ($ = JSON.parse(JSON.stringify(L.steelPlateList))), A(L.sectionSteelList) && (k = JSON.parse(JSON.stringify(L.sectionSteelList))), A(L.steelCoilList) && (J = JSON.parse(JSON.stringify(L.steelCoilList))), A(L.otherSteelMaterialList) && (z = JSON.parse(JSON.stringify(L.otherSteelMaterialList))), L[f.value] && (Se = [...$, ...k, ...J, ...z], X = (F = Array.from(new Set(Se == null ? void 0 : Se.map((G) => G.classifyId)))) == null ? void 0 : F.map((G) => Se == null ? void 0 : Se.find((ie) => ie.classifyId === G))), X.length;
  }), ae = Ee(() => {
    var Se;
    return ((Se = E == null ? void 0 : E[f.value]) == null ? void 0 : Se.TABLE) || E.steelPlateList.TABLE;
  }), j = Ee(() => {
    let Se = 0;
    return A(L.steelPlateList) && L.steelPlateList.forEach((X) => {
      Se += X.weighingTotalWeight ? X.weighingTotalWeight : 0;
    }), A(L.sectionSteelList) && L.sectionSteelList.forEach((X) => {
      Se += X.weighingTotalWeight ? X.weighingTotalWeight : 0;
    }), A(L.steelCoilList) && L.steelCoilList.forEach((X) => {
      Se += X.weighingTotalWeight ? X.weighingTotalWeight : 0;
    }), ji(Se, 2);
  });
  Ce(f, (Se) => {
    m.value = L[Se], Se && pt(() => {
      v[Se] || (v[Se] = b.value);
    });
  }, { immediate: true }), Ce(m, (Se) => {
    L[f.value] = Se;
  }, { deep: true });
  function le(Se, X) {
    T.value = Se, _.value = X, h.value = true;
  }
  function oe(Se, X) {
    var J, z, F;
    const $ = X.id;
    L.originInventoryInfo || (L.originInventoryInfo = {}), L.originInventoryInfo[$] = { quantity: X.quantity, frozenQuantity: X.frozenQuantity, basicClass: X.basicClass };
    const k = (J = E == null ? void 0 : E[f.value]) == null ? void 0 : J.V;
    k & Ge.STEEL_PLATE.V && (X.basicClass & Ge.STEEL_COIL.V ? (L[f.value][_.value].length = St(Se, (F = (z = r.value[X.basicClass]) == null ? void 0 : z.measure) == null ? void 0 : F.unit, r.value[k].length.unit, r.value[k].length.precision), L[f.value][_.value].quantity = 1, L[f.value][_.value].canUseQuantity = 1) : (L[f.value][_.value].length = X.length, L[f.value][_.value].quantity = Se, L[f.value][_.value].canUseQuantity = X.quantity), L[f.value][_.value].width = X.width), k & Ge.SECTION_STEEL.V && (L[f.value][_.value].quantity = Se, L[f.value][_.value].length = X.length, L[f.value][_.value].canUseQuantity = X.quantity), k & Ge.STEEL_COIL.V && (L[f.value][_.value].quantity = Se, L[f.value][_.value].canUseQuantity = X.quantity), L[f.value][_.value].color = X.color, L[f.value][_.value].brand = X.brand, L[f.value][_.value].requisitionMode = Ui.USE_INVENTORY.V, L[f.value][_.value].materialInventoryId = $;
  }
  ge();
  const ye = ft("steelDensityCfg");
  O.HOOK.beforeToEdit = async (Se, X) => {
    var $;
    if (await Bx(X), zi.close(), X.materialType & ct.STEEL.V && A(X.list)) {
      const k = [];
      let J = [];
      const z = [];
      if (($ = X.list) == null || $.forEach((F) => {
        (F.basicClass === Pe.STEEL_PLATE.V || F.basicClass === Pe.STEEL_COIL.V) && F.steelDensity !== ye.value[F.classifyId] && k.push({ classifyName: F.classifyName, classifyId: F.classifyId });
      }), J = ce(k, "classifyId"), A(J)) {
        J.forEach((G) => {
          z.push(`当前【${G.classifyName}】物料密度有变，最新密度为【${ye.value[G.classifyId]}】`);
        });
        const F = z.join(`，
`);
        X.densityData = J.map((G) => G.classifyId), zi.confirm(`${F}，
是否重新计算总重？`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消" }).then(() => {
          X.densityData = J.map((G) => G.classifyId), pt(() => {
            X.steelPlateList.forEach((G) => {
              X.densityData.includes(G.classifyId) && (G.weighingTotalWeight = G.theoryTotalWeight);
            }), X.steelCoilList.forEach((G) => {
              X.densityData.includes(G.classifyId) && (G.length = G.theoryLength);
            });
          });
        }).catch(() => {
          X.densityData = [];
        });
      }
    }
    N(X);
  };
  function ce(Se, X) {
    return Se.filter(($, k, J) => k === J.findIndex((z) => X ? z[X] === $[X] : JSON.stringify(z) === JSON.stringify($)));
  }
  O.HOOK.afterSubmit = () => {
    c("success"), ge();
  };
  function se() {
    if (Ae(L.branchCompanyId)) return ot.warning("请选择申购单位"), false;
    if (Ae(L.steelPlateList) && Ae(L.sectionSteelList) && Ae(L.steelCoilList) && Ae(L.otherSteelMaterialList)) return ot.warning("请填写数据"), false;
    const Se = he();
    return Se && (L.list = [...L.steelPlateList, ...L.sectionSteelList, ...L.steelCoilList], L.list.forEach((X) => {
      X.mete = X.weighingTotalWeight, X.weight = X.weighingTotalWeight;
    }), A(L.otherSteelMaterialList) && (L.list = [...L.list, ...L.otherSteelMaterialList]), A(x.value)) ? (ot.error("请先删除标红数据并重新添加"), false) : Se;
  }
  function he() {
    return Object.keys(v).every((Se) => v[Se] ? v[Se].validate() : true);
  }
  function be() {
    return Object.keys(v).every((Se) => v[Se] ? v[Se].TSValidate() : true);
  }
  function me(Se) {
    return b.value.rowInit(Se);
  }
  function ge() {
    pt(() => {
      v.steelPlateList = null, v.sectionSteelList = null, v.steelCoilList = null, v.otherSteelMaterialList = null, f.value = E.steelPlateList.K, V.value && V.value.clear();
    });
  }
  function Le() {
    var Se;
    if (A(x.value) && A((Se = P == null ? void 0 : P.submitResult) == null ? void 0 : Se.data)) {
      ot.error("请删除全部标红数据");
      return;
    }
    S.value = true;
  }
  function Ie(Se) {
    var X;
    try {
      (X = P == null ? void 0 : P.submitResult) != null && X.data && (P.submitResult.data = null), P.props.import(Se);
    } catch ($) {
      ot.error({ message: $.message, duration: 5e3 });
    }
  }
  return P.props.import = (Se) => {
    const X = f.value, $ = L[X].length;
    L[X].push.apply(L[X], Se);
    const k = L[X].length;
    if (X !== E.otherSteelMaterialList.K) for (let z = $; z < k; z++) v[X].rowWatch(L[X][z]);
    const J = Ce(V, () => {
      V.value && (V.value.initSelected(Se.map((z) => ({ sn: z.sn, classifyId: z.classifyId }))), pt(() => {
        J();
      }));
    }, { immediate: true });
  }, o({ form: L, TSValidateTable: be }), (Se, X) => {
    var G;
    const $ = Is, k = Ve("common-button"), J = jt, z = Li, F = Ve("common-drawer");
    return w(), Q("div", IB, [s(wr, { "basic-class": l(ua), "current-basic-class": (G = E == null ? void 0 : E[f.value]) == null ? void 0 : G.V, isTsData: e.isTsData, "show-total-amount": true, "total-value": j.value, validate: se, "total-name": "总量合计", unit: "kg" }, { default: p(() => {
      var ie, ue;
      return [C("div", CB, [C("div", PB, [s(l(Ls), { modelValue: f.value, "onUpdate:modelValue": X[0] || (X[0] = (ne) => f.value = ne), class: "filter-item", size: "default" }, { default: p(() => [(w(), Q(Qe, null, ki(E, (ne) => s($, { key: ne.K, label: ne.K }, { default: p(() => [Te(K(ne.L) + K(l(L)[ne.K] && l(L)[ne.K].length ? `(${l(L)[ne.K].length})` : ""), 1)]), _: 2 }, 1032, ["label"])), 64))]), _: 1 }, 8, ["modelValue"])]), C("div", OB, [C("div", kB, [s(_u, { "right-label": q.value, "show-unit": "" }, null, 8, ["right-label"])]), s(k, { class: "filter-item", type: "success", onClick: Le }, { default: p(() => X[4] || (X[4] = [Te(" 添加物料")])), _: 1, __: [4] }), s(J, { content: "请删除全部标红数据", disabled: !(l(A)(x.value) && l(A)((ue = (ie = l(P)) == null ? void 0 : ie.submitResult) == null ? void 0 : ue.data)), class: "item", effect: "dark", placement: "top" }, { default: p(() => [s(Ro, { template: I.value, "btn-name": "清单导入", "btn-size": "default", "btn-type": "warning", class: "filter-item", icon: "el-icon-upload", "open-loading": "", onSuccess: Ie }, null, 8, ["template"])]), _: 1 }, 8, ["disabled"]), f.value ? (w(), U(ia, { key: 0, fn: f.value !== E.otherSteelMaterialList.K ? l(sS) : l(uu), params: { basicClass: E[f.value].V, receiptType: l(It).REQUISITIONS.V }, class: "filter-item", size: "default", type: "info" }, { default: p(() => [Te(K(E[f.value].L) + "清单模板下载 ", 1)]), _: 1 }, 8, ["fn", "params"])) : H("", true)])]), s(z, { ref_key: "formRef", ref: M, model: l(L) }, { default: p(() => [(w(), U(Ri(ae.value), { ref_key: "steelRef", ref: b, "max-height": l(ee), style: ri(l(B)), onSearchInventory: le }, null, 40, ["max-height", "style"]))]), _: 1 }, 8, ["model"])];
    }), _: 1 }, 8, ["basic-class", "current-basic-class", "isTsData", "total-value"]), s(F, { ref_key: "drawerRef", ref: g, modelValue: S.value, "onUpdate:modelValue": X[2] || (X[2] = (ie) => S.value = ie), "show-close": true, size: 900, "custom-class": "material-table-spec-select", title: "物料选择" }, { content: p(() => {
      var ie;
      return [s(to, { ref_key: "matSpecRef", ref: V, modelValue: m.value, "onUpdate:modelValue": X[1] || (X[1] = (ue) => m.value = ue), "basic-class": (ie = E == null ? void 0 : E[f.value]) == null ? void 0 : ie.V, "max-height": l(Y), "row-init-fn": me, "table-width": 350, visible: S.value, "auto-selected": "", "expand-query": "" }, null, 8, ["modelValue", "basic-class", "max-height", "visible"])];
    }), _: 1 }, 8, ["modelValue"]), s(l(Tu), { visible: h.value, "onUpdate:visible": X[3] || (X[3] = (ie) => h.value = ie), params: T.value, onUseInventory: oe }, null, 8, ["visible", "params"])]);
  };
} }, Yv = ut(DB, [["__scopeId", "data-v-ff211d71"]]), xB = Object.freeze(Object.defineProperty({ __proto__: null, default: Yv }, Symbol.toStringTag, { value: "Module" }));
function UB(e, o) {
  const n = [{ title: "行号", key: "rowIndex", wch: 10 }, { title: "错误信息", key: "error", wch: 80 }], c = e.map((u) => ({ rowIndex: u.rowIndex, error: u.error }));
  Di({ type: "error", title: "导入失败,请查看错误清单", duration: 8e3 }), pl({ headers: n, data: c, filename: "辅材申购清单-错误清单", sheetName: "错误清单" });
}
const Kv = { title: "辅材申购清单", dlgWidth: "1500px", startRow: 2, endIgnoreRow: 1, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_2" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_3" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_4" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_5" }, { label: "颜色", field: "color", excelField: "__EMPTY_6" }, { label: "所属项目（简称）", field: "shortName", excelField: "__EMPTY_7" }, { label: "需求时间", field: "arrivalTime", excelField: "__EMPTY_8" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }] }, format: async (e) => {
  var S;
  if (!gi(e, Kv.rules)) return;
  _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree");
  const n = _e.state.config.rawMatClsList.filter((h) => h.basicClass === Ge.MATERIAL.V), c = _e.state.config.rawMatClsKV, u = At(e), r = [];
  let E = [];
  const y = [], b = [], V = [];
  u.forEach((h, T) => {
    let _ = false;
    const f = pi(h.classifyName.split("/"));
    if (f.length === 1) {
      const m = n.filter((R) => R.name === h.classifyName) || [];
      if (A(m)) if (m.length === 1) _ = true, h.classifyId = m[0].id, r.push(m[0].id);
      else {
        const R = [];
        for (const N of m) if (N.isLeaf) for (let P = 0; P < N.fullPathId.length; P++) N.id !== N.fullPathId[P] && R.push(N.fullPathId[P]);
        const v = m.find((N) => Ae(N.parent) && !R.includes(N.id));
        if (A(v)) _ = true, h.classifyId = v.id, r.push(v.id);
        else {
          const N = m.filter((P) => P.isLeaf) || [];
          if (N.length === 1) {
            let P = true;
            m.forEach((L) => {
              N[0].fullPathId.includes(L.id) || (P = false);
            }), P && (_ = true, h.classifyId = N[0].id, r.push(N[0].id));
          } else for (const P of m) A(P.parent) && !R.includes(P.id) && y.push(P);
        }
      }
      y.length > 1 && V.push({ rowIndex: T + 1, error: `科目名称"${h.classifyName}"在科目配置中存在同名的情况，需要带上父级科目名称如"一级科目/二级科目/末级科目"` });
    } else for (const m of n) if (m.fullPathName.length >= f.length && mi(m.fullPathName.slice(-f.length), f)) {
      _ = true, h.classifyId = m.id, r.push(m.id);
      break;
    }
    if (_ || (E.push(h.classifyName), b.some((m) => m.classifyName === h.classifyName) || b.push({ rowIndex: T + 1, classifyName: h.classifyName })), h.shortName) {
      const m = _e.state.project.projectAllType.find((R) => R.shortName === h.shortName);
      m ? h.projectId = m.id : V.push({ rowIndex: T + 1, error: `名称为“${h.shortName}”的项目不存在”` });
    } else h.projectId = -1;
    h.arrivalTime ? h.arrivalTime = yr(h.arrivalTime) : h.arrivalTime = "同上";
  }), E = Array.from(new Set(E)), E.length > 0 && (V.push({ rowIndex: b[0].rowIndex, error: `${b.map((h) => `"${h.classifyName}"`).join("、")}${b.length > 1 ? "等" : ""}物料种类不存在` }), b.shift());
  const M = _e.state.config.classifySpec, g = r.filter((h) => M[h] === void 0);
  g.length > 0 && (g.forEach((h) => {
    M[h] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", g));
  for (const h of u) {
    if (((S = c == null ? void 0 : c[h.classifyId]) == null ? void 0 : S.isLeaf) === false) {
      V.push({ rowIndex: u.indexOf(h) + 1, error: `${h.classifyName}不是末级科目` });
      continue;
    }
    const T = M[h.classifyId];
    if ((T == null ? void 0 : T.hasUnitConfig) === false) {
      V.push({ rowIndex: u.indexOf(h) + 1, error: `${h.classifyName}未配置核算单位` });
      continue;
    }
    let _;
    const f = h.specification ?? "";
    if (T && Array.isArray(T.specList)) {
      for (const m of T.specList) if (f === m.spec) {
        if (_ = m, h.measureUnit) {
          if (!_.classify.measureUnit) throw new Error(`${h.classifyName}不存在计量单位`);
          if (!await ti(_.classify.measureUnit, h.measureUnit)) throw new Error(`${h.classifyName}填写的计量单位错误，单位应为：“${_.classify.measureUnit}”`);
        }
        if (h.accountingUnit && !await ti(_.classify.accountingUnit, h.accountingUnit)) throw new Error(`${h.classifyName}填写的核算单位错误，单位应为：“${_.classify.accountingUnit}”`);
        break;
      }
    }
    if (_) h.uid = Tt(), h.sn = _.sn, h.specificationLabels = _.specificationLabels, h.serialNumber = _.serialNumber, h.classifySerialNumber = _.classify.serialNumber, h.classifyId = _.classify.id, h.classifyFullPathId = _.classify.fullPathId, h.classifyFullName = _.classify.fullName, h.classifyName = _.classify.name, h.classifyParentFullName = _.classify.parentFullName, h.basicClass = _.classify.basicClass, h.specification = _.spec, h.specificationMap = _.specKV, h.measureUnit = _.classify.measureUnit, h.accountingUnit = _.classify.accountingUnit, h.accountingPrecision = _.classify.accountingPrecision, h.measurePrecision = _.classify.measurePrecision, h.quantity && (h.quantity = Be(h.quantity, h.measurePrecision)), h.mete && (h.mete = Be(h.mete, h.accountingPrecision)), h.measureUnit || (h.quantity = void 0);
    else {
      const m = `${h.classifyName}下不存在规格为"${f}"的材料，请联系管理员/仓库人员添加`;
      V.some((R) => R.error === m) || V.push({ rowIndex: u.indexOf(h) + 1, error: m });
      continue;
    }
  }
  if (V.length > 0) UB(V);
  else return u;
} }, YB = { key: 1 }, dd = { __name: "aux-mat-table", emits: ["search-inventory"], setup(e, { expose: o, emit: n }) {
  const c = n, u = ft("useInventoryInfo"), r = ft("matSpecRef"), { cu: E, form: y } = Wi(), b = (x, I) => I.measureUnit ? !!x : true, V = Ee(() => {
    let x = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], quantity: [{ validator: b, message: "请填写数量", trigger: "blur" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }, { pattern: Vi, message: "核算量必须大于0", trigger: "blur" }], arrivalTime: [{ required: true, message: "请选择需求时间", trigger: "change" }] };
    return y.level === Bt.CONSTRUCTION_SITE.V && (x = Object.assign(x, { projectId: [{ required: true, message: "请选择需求时间", trigger: "change" }] })), x;
  }), M = /* @__PURE__ */ new Map([["arrivalTime", "同上"], ["projectId", -1]]), { tableValidate: g, wrongCellMask: S, cleanUpData: h } = ui({ rules: V, ditto: M }), { projectAllType: T } = Wa();
  function _({ row: x, rowIndex: I }) {
    var Y, ee;
    if ((ee = (Y = E == null ? void 0 : E.submitResult) == null ? void 0 : Y.data) != null && ee.includes(x.classifyId)) return { backgroundColor: "#ffdede" };
  }
  function f(x) {
    var Y, ee;
    return Ct({ uid: Tt(), sn: x.sn, requisitionMode: Ui.PURCHASE.V, specificationLabels: x.specificationLabels, classifySerialNumber: x.classify.serialNumber, serialNumber: x.serialNumber, classifyId: x.classify.id, classifyFullPathId: x.classify.fullPathId, classifyFullName: x.classify.fullName, classifyName: x.classify.name, classifyParentFullName: x.classify.parentFullName, basicClass: x.classify.basicClass, specification: x.spec, specificationMap: x.specKV, measureUnit: x.classify.measureUnit, accountingUnit: x.classify.accountingUnit, accountingPrecision: x.classify.accountingPrecision, measurePrecision: x.classify.measurePrecision, mete: void 0, quantity: void 0, arrivalTime: ((Y = y.list) == null ? void 0 : Y.length) > 0 ? "同上" : void 0, projectId: ((ee = y.list) == null ? void 0 : ee.length) > 0 ? -1 : void 0, project: void 0 });
  }
  function m(x) {
    return x.materialInventoryId && y.originInventoryInfo[x.materialInventoryId] ? y.originInventoryInfo[x.materialInventoryId].quantity - y.originInventoryInfo[x.materialInventoryId].frozenQuantity - u.value[x.materialInventoryId] + x.quantity : 999999999;
  }
  function R(x, I) {
    c("search-inventory", x, I);
  }
  function v(x, I, Y) {
    var ee, B, q, ae;
    if ((B = (ee = E == null ? void 0 : E.submitResult) == null ? void 0 : ee.data) != null && B.includes(Y.classifyId)) {
      const j = (q = E == null ? void 0 : E.submitResult) == null ? void 0 : q.data.findIndex((oe) => oe === Y.classifyId);
      y.list.filter((oe) => oe.classifyId === Y.classifyId).length === 1 && ((ae = E == null ? void 0 : E.submitResult) == null || ae.data.splice(j, 1));
    }
    r.value ? r.value.delListItem(x, I) : y.list.splice(I, 1);
  }
  function N() {
    if (Ae(y.list)) return true;
    const { validResult: x, dealList: I } = g(y.list);
    return x && L(I), x;
  }
  function P() {
    if (Ae(y.list)) return true;
    const x = y.list.filter((I) => true);
    return L(x), true;
  }
  function L(x) {
    h(x), x.forEach((I, Y) => {
      var ee;
      y.list[Y].projectId = I.projectId, y.list[Y].project = (ee = T.value) == null ? void 0 : ee.find((B) => y.list[Y].projectId === B.id), y.list[Y].arrivalTime = I.arrivalTime;
    });
  }
  function O(x) {
    x.projectId = void 0, x.project = void 0;
  }
  return o({ rowInit: f, validate: N, TSValidate: P }), (x, I) => {
    const Y = vt, ee = Ve("table-cell-tag"), B = jt, q = Ve("common-input-number"), ae = Mt, j = Rl, le = Ve("common-button"), oe = Ve("common-table"), ye = _t("empty-text");
    return w(), U(oe, ii({ "cell-class-name": l(S), data: l(y).list, "row-style": _, "show-empty-symbol": false, stripe: false, "return-source-data": "", "row-key": "uid" }, x.$attrs), { default: p(() => [s(Y, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), s(Y, { align: "center", fixed: "left", label: "编号", prop: "serialNumber", "show-overflow-tooltip": "" }, { default: p(({ row: ce }) => [s(ee, { name: l(Ui).USE_INVENTORY.L, show: ce.requisitionMode === l(Ui).USE_INVENTORY.V, color: "#e6a23c" }, null, 8, ["name", "show"]), C("span", null, K(ce.serialNumber), 1)]), _: 1 }), s(Y, { align: "center", fixed: "left", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "" }, { default: p(({ row: ce }) => [s(B, { content: ce.classifyParentFullName, disabled: !ce.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[ye, ce.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(Y, { align: "center", fixed: "left", label: "规格", prop: "specification", "show-overflow-tooltip": "" }, { default: p(({ row: ce }) => [s(B, { content: ce.specificationLabels, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[ye, ce.specification]])]), _: 2 }, 1032, ["content"])]), _: 1 }), s(Y, { align: "center", label: "计量单位", prop: "measureUnit" }, { default: p(({ row: ce }) => [qe((w(), Q("span", null, [Te(K(ce.measureUnit), 1)])), [[ye]])]), _: 1 }), s(Y, { align: "center", label: "数量", prop: "quantity" }, { default: p(({ row: ce }) => [ce.measureUnit ? (w(), U(q, { key: 0, modelValue: ce.quantity, "onUpdate:modelValue": (se) => ce.quantity = se, controls: false, disabled: !!l(y).boolUsed, max: m(ce), min: 0, precision: ce.measurePrecision, step: 1, placeholder: "数量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "max", "precision"])) : qe((w(), Q("span", YB, null, 512)), [[ye]])]), _: 1 }), s(Y, { align: "center", label: "核算单位", prop: "accountingUnit" }, { default: p(({ row: ce }) => [qe((w(), Q("span", null, [Te(K(ce.accountingUnit), 1)])), [[ye]])]), _: 1 }), s(Y, { align: "center", label: "核算量", prop: "mete" }, { default: p(({ row: ce }) => [s(q, { modelValue: ce.mete, "onUpdate:modelValue": (se) => ce.mete = se, controls: false, disabled: !!l(y).boolUsed, max: 999999999, min: 1e-6, precision: ce.accountingPrecision, step: 1, placeholder: "核算量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision"])]), _: 1 }), s(Y, { align: "center", label: "颜色", prop: "color" }, { default: p(({ row: ce }) => [s(ae, { modelValue: ce.color, "onUpdate:modelValue": (se) => ce.color = se, modelModifiers: { trim: true }, disabled: !!l(y).boolUsed, maxlength: "20", placeholder: "颜色", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), _: 1 }), s(Y, { align: "center", label: "项目", "min-width": "200", prop: "projectId" }, { default: p(({ row: ce, $index: se }) => [s(ca, { modelValue: ce.projectId, "onUpdate:modelValue": (he) => ce.projectId = he, branchCompanyId: l(y).branchCompanyId, disabled: l(Ae)(l(y).branchCompanyId) || !!l(y).boolUsed, isLumpSum: false, "show-extra": se !== 0, clearable: "", style: { width: "100%" }, onClear: (he) => O(ce) }, null, 8, ["modelValue", "onUpdate:modelValue", "branchCompanyId", "disabled", "show-extra", "onClear"])]), _: 1 }), s(Y, { align: "center", label: "期望到场时间", prop: "arrivalTime" }, { default: p(({ row: ce, $index: se }) => [s(j, { modelValue: ce.arrivalTime, "onUpdate:modelValue": (he) => ce.arrivalTime = he, disabled: !!l(y).boolUsed, disabledDate: (he) => l($a)(he).valueOf() < l($a)().subtract(1, "days").valueOf(), placeholder: se === 0 || l(Ae)(ce.arrivalTime) ? "选择日期" : "同上", size: "default", style: { width: "100%" }, type: "date", "value-format": "x" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "disabledDate", "placeholder"])]), _: 1 }), s(Y, { align: "center", fixed: "right", label: "库存", width: "90" }, { default: p(({ row: ce, $index: se }) => [s(le, { size: "default", type: "primary", onClick: (he) => R(ce, se) }, { default: p(() => I[0] || (I[0] = [Te(" 查询 ")])), _: 2, __: [0] }, 1032, ["onClick"])]), _: 1 }), l(y).boolUsed ? H("", true) : (w(), U(Y, { key: 0, align: "center", fixed: "right", label: "操作", width: "70" }, { default: p(({ row: ce, $index: se }) => [s(le, { disabled: !!l(y).boolUsed, icon: "el-icon-delete", size: "default", type: "danger", onClick: (he) => v(ce.sn, se, ce) }, null, 8, ["disabled", "onClick"])]), _: 1 }))]), _: 1 }, 16, ["cell-class-name", "data"]);
  };
} }, KB = Object.freeze(Object.defineProperty({ __proto__: null, default: dd }, Symbol.toStringTag, { value: "Module" }));
const WB = { class: "aux-mat-requisitions-application-container" }, jB = { class: "filter-container" }, FB = { class: "filter-right-box" }, zB = { class: "filter-item" }, BB = { __name: "index", props: { detail: { type: Object }, isEdit: { type: Boolean, default: false }, isTsData: { type: Boolean, default: false } }, emits: ["success"], setup(e, { expose: o, emit: n }) {
  const c = n, u = e, r = { list: [], originInventoryInfo: {} }, E = Z(), y = Z(), b = Z(), V = Z(), M = Z(false), g = Z({}), S = Z(), h = Z(false), T = Ge.MATERIAL.V, _ = Z({});
  yi("useInventoryInfo", _), yi("matSpecRef", y);
  const { cu: f, form: m, FORM: R } = Pa({ title: "辅材申购", defaultForm: r, clearDraftCallback: B, api: u.isEdit ? nn.edit : nn.add }, b, u.detail);
  Ce(() => u.detail, (j = {}) => {
    m.materialType = j.materialType, m.branchCompanyId = j.branchCompanyId, m.level = j.level, m.serialNumber = j.serialNumber;
  }, { deep: true, immediate: true });
  const { maxHeight: v } = Kt({ mainBox: ".material-table-spec-select", extraBox: ".el-drawer__header", wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, minHeight: 300 }, () => V.value.loaded), { maxHeight: N } = Kt({ mainBox: ".requisitions-application-record-form", extraBox: [".el-drawer__header", ".filter-container", ".requisitions-application-header", ".requisitions-application-select", ".requisitions-application-footer"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, navbar: false, minHeight: 300, extraHeight: u.isTsData ? 0 : 200 }), P = Ee(() => {
    var oe;
    let j = [], le = [];
    return A(m.list) && (j = JSON.parse(JSON.stringify(m.list)), le = (oe = Array.from(new Set(j == null ? void 0 : j.map((ye) => ye.classifyId)))) == null ? void 0 : oe.map((ye) => j == null ? void 0 : j.find((ce) => ce.classifyId === ye))), le.length;
  }), L = Ee(() => {
    var j;
    return (j = m.list) == null ? void 0 : j.filter((le) => {
      var oe, ye;
      return (ye = (oe = f == null ? void 0 : f.submitResult) == null ? void 0 : oe.data) == null ? void 0 : ye.includes(le.classifyId);
    });
  });
  B(), Dt(() => {
    var j;
    if ((j = m.list) != null && j.length) {
      const le = {};
      for (let oe = 0; oe < m.list.length; oe++) {
        const ye = m.list[oe];
        ye.requisitionMode === Ui.USE_INVENTORY.V && (le[ye.materialInventoryId] ? le[ye.materialInventoryId] += ye.quantity : le[ye.materialInventoryId] = ye.quantity);
      }
      _.value = le;
    }
  }), R.HOOK.afterSubmit = () => {
    c("success"), B();
  };
  function O(j, le) {
    g.value = j, S.value = le, M.value = true;
  }
  function x(j, le) {
    const oe = le.id;
    m.originInventoryInfo || (m.originInventoryInfo = {}), m.originInventoryInfo[oe] = { quantity: le.quantity, frozenQuantity: le.frozenQuantity }, m.list[S.value].quantity = j, m.list[S.value].canUseQuantity = le.quantity, m.list[S.value].color = le.color, m.list[S.value].brand = le.brand, m.list[S.value].unitNet = le.unitNet, m.list[S.value].mete = le.quantity * le.unitNet, m.list[S.value].requisitionMode = Ui.USE_INVENTORY.V, m.list[S.value].materialInventoryId = oe;
  }
  function I() {
    return Ae(m.branchCompanyId) ? (ot.warning("请选择申购单位"), false) : A(L.value) ? (ot.error("请先删除标红数据并重新添加"), false) : E.value ? E.value.validate() : true;
  }
  function Y() {
    return E.value ? E.value.TSValidate() : true;
  }
  function ee(j) {
    return E.value.rowInit(j);
  }
  function B() {
    y.value && y.value.clear();
  }
  function q() {
    var j;
    if (A(L.value) && A((j = f == null ? void 0 : f.submitResult) == null ? void 0 : j.data)) {
      ot.error("请删除全部标红数据");
      return;
    }
    h.value = true;
  }
  function ae(j) {
    var le;
    try {
      (le = f == null ? void 0 : f.submitResult) != null && le.data && (f.submitResult.data = null), f.props.import(j);
    } catch (oe) {
      ot.error({ message: oe.message, duration: 5e3 });
    }
  }
  return f.props.import = (j) => {
    m.list.push.apply(m.list, j);
    const le = Ce(y, () => {
      y.value && (y.value.initSelected(j.map((oe) => ({ sn: oe.sn, classifyId: oe.classifyId }))), pt(() => {
        le();
      }));
    }, { immediate: true });
  }, o({ form: m, TSValidateTable: Y }), (j, le) => {
    const oe = Ve("common-button"), ye = jt, ce = Li, se = Ve("common-drawer");
    return w(), Q("div", WB, [s(wr, { "basic-class": l(T), "is-ts-data": u.isTsData, "show-total": false, validate: I }, { default: p(() => {
      var he, be;
      return [C("div", jB, [C("div", FB, [C("div", zB, [s(_u, { "right-label": P.value, "show-unit": "" }, null, 8, ["right-label"])]), s(oe, { class: "filter-item", type: "success", onClick: q }, { default: p(() => le[3] || (le[3] = [Te(" 添加物料 ")])), _: 1, __: [3] }), s(ye, { content: "请删除全部标红数据", disabled: !(l(A)(L.value) && l(A)((be = (he = l(f)) == null ? void 0 : he.submitResult) == null ? void 0 : be.data)), class: "item", effect: "dark", placement: "top" }, { default: p(() => [s(Ro, { template: l(Kv), "btn-name": "清单导入", "btn-size": "default", "btn-type": "warning", class: "filter-item", icon: "el-icon-upload", "open-loading": "", onSuccess: ae }, null, 8, ["template"])]), _: 1 }, 8, ["disabled"]), s(ia, { fn: l(sS), params: { basicClass: l(T), receiptType: l(It).REQUISITIONS.V }, class: "filter-item", size: "default", type: "info" }, { default: p(() => le[4] || (le[4] = [Te(" 辅材清单模板下载 ")])), _: 1, __: [4] }, 8, ["fn", "params"])])]), s(ce, { ref_key: "formRef", ref: b, model: l(m) }, { default: p(() => [s(dd, { ref_key: "tableRef", ref: E, "max-height": l(N), onSearchInventory: O }, null, 8, ["max-height"])]), _: 1 }, 8, ["model"])];
    }), _: 1 }, 8, ["basic-class", "is-ts-data"]), s(se, { ref_key: "drawerRef", ref: V, modelValue: h.value, "onUpdate:modelValue": le[1] || (le[1] = (he) => h.value = he), "show-close": true, size: 900, "custom-class": "material-table-spec-select", title: "物料选择" }, { content: p(() => [s(to, { ref_key: "matSpecRef", ref: y, modelValue: l(m).list, "onUpdate:modelValue": le[0] || (le[0] = (he) => l(m).list = he), "basic-class": l(T), "max-height": l(v) - 100, "row-init-fn": ee, "table-width": 430, visible: h.value, "auto-selected": "", "expand-query": "" }, null, 8, ["modelValue", "basic-class", "max-height", "visible"])]), _: 1 }, 8, ["modelValue"]), s(l(Tu), { visible: M.value, "onUpdate:visible": le[2] || (le[2] = (he) => M.value = he), params: g.value, onUseInventory: x }, null, 8, ["visible", "params"])]);
  };
} }, Wv = ut(BB, [["__scopeId", "data-v-35c8d138"]]), HB = Object.freeze(Object.defineProperty({ __proto__: null, default: Wv }, Symbol.toStringTag, { value: "Module" }));
function Q_({ fetchHook: e }) {
  const { tablePageSize: o } = ka("tablePageSize"), n = Ct({ pageNumber: 1, pageSize: o.value }), c = Z(0);
  function u(y) {
    n.pageNumber = 1, n.pageSize = y, typeof e == "function" && e();
  }
  function r(y) {
    n.pageNumber = y, typeof e == "function" && e();
  }
  function E(y) {
    c.value = y;
  }
  return { handleSizeChange: u, handleCurrentChange: r, total: c, setTotalPage: E, queryPage: n };
}
const jv = { __name: "enclosure-table", props: { selectListHistory: { type: Array, default: () => [] } }, setup(e, { expose: o }) {
  const n = Z(), c = Z([]), u = Z(false), r = Z([]), { form: E } = Wi(), y = ft("customQuery"), { enclosureDictList: b } = Pv(), { handleSizeChange: V, handleCurrentChange: M, total: g, setTotalPage: S, queryPage: h } = Q_({ fetchHook: _ });
  function T(N) {
    var P;
    return ((P = E.list) == null ? void 0 : P.findIndex((L) => L.id === N.id)) === -1;
  }
  async function _() {
    if (r.value = [], Ae(y.value.branchCompanyId)) {
      r.value = [], S(0);
      return;
    }
    if (Ae(y.value.projectId)) {
      r.value = [], S(0);
      return;
    }
    try {
      await f();
    } catch (N) {
      console.log(N, "获取构件类型");
    }
  }
  async function f() {
    if (Ae(y.value.branchCompanyId)) {
      r.value = [], S(0);
      return;
    }
    if (Ae(y.value.projectId)) {
      r.value = [], S(0);
      return;
    }
    try {
      u.value = true;
      const { content: N, totalElements: P } = await b5({ ...y.value, ...h });
      r.value = N.map((L) => (L.totalLength = St(Be(L.quantity * L.length, Ft.LENGTH_DP), Ft.LENGTH, "m"), L.totalArea = St(Be(L.quantity * L.surfaceArea, Ft.AREA_DP), Ft.AREA, "m²"), L.totalWeight = St(Be(L.quantity * L.weight, Ft.WEIGHT_DP)), L.measureUnit = "张", L.accountingUnit = "千克", L)), u.value = false, S(P), await pt(() => {
        A(E.list) && E.list.forEach((L) => {
          const O = r.value.find((x) => x.id === L.id);
          A(O) && n.value.toggleRowSelection(O, true);
        });
      });
    } catch (N) {
      console.log(N, "获取成品清单");
    }
  }
  function m(N) {
    n.value.toggleRowSelection(r.value.find((P) => P.id === N.id), false);
  }
  function R() {
    r.value.forEach((N) => {
      n.value.toggleRowSelection(N, false);
    });
  }
  function v(N) {
    c.value = N;
  }
  return El(() => {
    _();
  }), o({ refresh: _, refreshList: f, selectList: c, deleteRow: m, deleteAll: R }), (N, P) => {
    const L = vt, O = Ve("common-table"), x = Fn, I = oi;
    return w(), Q(Qe, null, [qe((w(), U(O, ii({ ref_key: "tableRef", ref: n, data: r.value, style: { width: "100%" } }, N.$attrs, { onSelectionChange: v }), { default: p(() => [s(L, { selectable: T, align: "center", type: "selection", width: "55" }), s(L, { align: "center", label: "序号", type: "index", width: "60" }), s(L, { align: "center", label: "类型", "min-width": "120px", prop: "category", "show-overflow-tooltip": "" }, { default: p(({ row: Y }) => {
      var ee;
      return [Te(K((ee = l(b).find((B) => B.id === Y.dictionaryId)) == null ? void 0 : ee.label), 1)];
    }), _: 1 }), s(L, { align: "center", label: "名称", "min-width": "100px", prop: "name", "show-overflow-tooltip": "" }), s(L, { align: "center", label: "编号", "min-width": "120px", prop: "serialNumber", "show-overflow-tooltip": "" }), s(L, { align: "center", label: "规格", "min-width": "140px", prop: "specification", "show-overflow-tooltip": "" }), s(L, { align: "center", label: "厚度（mm）", prop: "thickness", "show-overflow-tooltip": "" }), s(L, { align: "center", label: "单长（mm）", "min-width": "120px", prop: "length", "show-overflow-tooltip": "" }), s(L, { align: "center", label: "计量单位", "min-width": "100px", prop: "measureUnit", "show-overflow-tooltip": "" }), s(L, { align: "center", label: "数量", "min-width": "100px", prop: "quantity", "show-overflow-tooltip": "" }), s(L, { align: "center", label: "总长（m）", "min-width": "120px", prop: "totalLength", "show-overflow-tooltip": "" }, { default: p(({ row: { sourceRow: Y } }) => [C("span", null, K(l(Be)(Y.totalLength, 2)), 1)]), _: 1 }), s(L, { align: "center", label: "面积（m²）", "min-width": "120px", prop: "totalArea", "show-overflow-tooltip": "" }), s(L, { align: "center", label: "备注", prop: "remark", "show-overflow-tooltip": "" })]), _: 1 }, 16, ["data"])), [[I, u.value]]), s(x, { "current-page": l(h).pageNumber, "page-size": l(h).pageSize, total: l(g), layout: "total, prev, pager, next, sizes", style: { "margin-top": "8px" }, onSizeChange: l(V), onCurrentChange: l(M) }, null, 8, ["current-page", "page-size", "total", "onSizeChange", "onCurrentChange"])], 64);
  };
} }, qB = Object.freeze(Object.defineProperty({ __proto__: null, default: jv }, Symbol.toStringTag, { value: "Module" })), Fv = { __name: "structure-table", props: { selectListHistory: { type: Array, default: () => [] } }, setup(e, { expose: o }) {
  const n = Z(), c = Z([]), u = Z(false), r = Z([]), { form: E } = Wi(), y = ft("customQuery"), { handleSizeChange: b, handleCurrentChange: V, total: M, setTotalPage: g, queryPage: S } = Q_({ fetchHook: T });
  function h(v) {
    var N;
    return ((N = E.list) == null ? void 0 : N.findIndex((P) => P.productId === v.productId)) === -1;
  }
  async function T() {
    if (r.value = [], Ae(y.value.branchCompanyId)) {
      r.value = [], g(0);
      return;
    }
    if (Ae(y.value.projectId)) {
      r.value = [], g(0);
      return;
    }
    console.log(y.value, "231231");
    try {
      await _();
    } catch (v) {
      console.log(v, "获取构件类型");
    }
  }
  async function _() {
    if (Ae(y.value.branchCompanyId)) {
      r.value = [], g(0);
      return;
    }
    if (Ae(y.value.projectId)) {
      r.value = [], g(0);
      return;
    }
    try {
      u.value = true;
      const { content: v, totalElements: N } = await _5({ ...y.value, ...S });
      r.value = v.map((P) => (P.totalLength = St(Be(P.quantity * P.length, Ft.LENGTH_DP), Ft.LENGTH, "m"), P.totalWeight = Be(P.quantity * P.netWeight, 2), P.measureUnit = "件", P.accountingUnit = "千克", P)), u.value = false, g(N), await pt(() => {
        A(E.list) && E.list.forEach((P) => {
          const L = r.value.find((O) => O.productId === P.productId);
          A(L) && n.value.toggleRowSelection(L, true);
        });
      });
    } catch (v) {
      console.log(v, "获取成品清单");
    }
  }
  function f(v) {
    n.value.toggleRowSelection(r.value.find((N) => N.productId === v.productId), false);
  }
  function m() {
    r.value.forEach((v) => {
      n.value.toggleRowSelection(v, false);
    });
  }
  function R(v) {
    c.value = v;
  }
  return El(() => {
    T();
  }), o({ refresh: T, refreshList: _, selectList: c, deleteRow: f, deleteAll: m }), (v, N) => {
    const P = vt, L = Ve("common-table"), O = Fn, x = oi;
    return w(), Q(Qe, null, [qe((w(), U(L, ii({ ref_key: "tableRef", ref: n, data: r.value, style: { width: "100%" } }, v.$attrs, { onSelectionChange: R }), { default: p(() => [s(P, { selectable: h, align: "center", type: "selection", width: "55" }), s(P, { align: "center", label: "序号", type: "index", width: "60" }), s(P, { align: "center", label: "单体", "min-width": "120px", prop: "monomer.name", "show-overflow-tooltip": "" }), s(P, { align: "center", label: "区域", "min-width": "120px", prop: "area.name", "show-overflow-tooltip": "" }), s(P, { align: "center", label: "名称", "min-width": "100px", prop: "name", "show-overflow-tooltip": "" }), s(P, { align: "center", label: "编号", "min-width": "100px", prop: "serialNumber", "show-overflow-tooltip": "" }), s(P, { align: "center", label: "规格", "min-width": "140px", prop: "specification", "show-overflow-tooltip": "" }), s(P, { align: "center", label: "长度（mm）", prop: "length", "show-overflow-tooltip": "" }), s(P, { align: "center", label: "材质", prop: "material", "show-overflow-tooltip": "" }), s(P, { align: "center", label: "数量", "min-width": "100px", "show-overflow-tooltip": "" }, { default: p(({ row: { sourceRow: I } }) => [Te(K(I.quantity), 1)]), _: 1 }), s(P, { align: "center", label: "单重（kg）", "min-width": "120px", "show-overflow-tooltip": "" }, { default: p(({ row: { sourceRow: I } }) => [C("span", null, K(l(Be)(I.netWeight, 2)), 1)]), _: 1 }), s(P, { align: "center", label: "总重（kg）", "min-width": "120px", "show-overflow-tooltip": "" }, { default: p(({ row: { sourceRow: I } }) => [C("span", null, K(l(Be)(I.quantity * I.netWeight, 2)), 1)]), _: 1 })]), _: 1 }, 16, ["data"])), [[x, u.value]]), s(O, { "current-page": l(S).pageNumber, "page-size": l(S).pageSize, total: l(M), layout: "total, prev, pager, next, sizes", style: { "margin-top": "8px" }, onSizeChange: l(b), onCurrentChange: l(V) }, null, 8, ["current-page", "page-size", "total", "onSizeChange", "onCurrentChange"])], 64);
  };
} }, GB = Object.freeze(Object.defineProperty({ __proto__: null, default: Fv }, Symbol.toStringTag, { value: "Module" }));
const QB = { class: "monomer-box", style: { display: "inline-block" } }, ZB = { __name: "index", props: { projectId: { type: [Number, String] }, modelValue: { type: [Number, String, Array] }, size: { type: String, default: "default" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, showAll: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, default: { type: Boolean, default: true }, defaultValue: { type: [Number, String, Array], default: void 0 }, placeholder: { type: String, default: "请选择单体" }, productType: { type: [Number, String], default: void 0 }, mainProductType: { type: [Number, String], default: void 0 }, filterArea: { type: Boolean, default: true }, showTips: { type: Boolean, default: false }, planProductCategoryEnum: { type: [String, Number], default: void 0 } }, emits: ["change", "update:modelValue", "getAreaInfo", "getCurrentInfo", "planAreaBatchInfo", "getBatchList"], setup(e, { expose: o, emit: n }) {
  const c = n, u = Z(false), r = Z(), E = Z([]), y = Z([]), b = Z([]), V = e;
  Ce(() => V.projectId, (_) => {
    g();
  }, { deep: true, immediate: true }), Ce(() => V.mainProductType, (_) => {
    _ && g();
  }), Ce(() => V.modelValue, (_) => {
    r.value = _;
  }, { immediate: true });
  function M(_) {
    const f = { ..._ };
    return delete f.class, f;
  }
  async function g() {
    if (E.value = [], y.value = [], b.value = [], !V.projectId) {
      r.value = void 0, T(r.value), c("getBatchList", b.value);
      return;
    }
    let _ = [];
    u.value = true;
    try {
      const { content: f = [] } = await Cw(V.projectId, { planProductCategoryEnum: V == null ? void 0 : V.planProductCategoryEnum }) || {};
      y.value = f || [], f.length > 0 && (b.value = f.flatMap((m) => (m.areaSimpleList || []).flatMap((R) => (R.planAreaBatchDTOS || []).map((v) => ({ ...v, monomerId: m.id })))), c("getBatchList", b.value)), _ = f.map((m) => ({ value: m.id, label: m.name }));
    } catch (f) {
      console.log("获取单体列表", f);
    } finally {
      E.value = _, V.default && A(_) ? (r.value = _[0].value, T(r.value)) : A(V.defaultValue) ? (r.value = V.defaultValue, T(r.value)) : r.value = void 0, u.value = false;
    }
  }
  function S(_) {
    return y.value.find((f) => f.id === _);
  }
  function h(_) {
    var f;
    return (f = y.value.find((m) => m.id === _)) == null ? void 0 : f.productTypeList.reduce((m, R) => m | R.type, 0);
  }
  function T(_) {
    var f, m;
    if (!Array.isArray(_)) {
      let R = {};
      _ ? R = y.value.find((P) => P.id === _) : (_ = void 0, R = {});
      let v = [], N = [];
      V.filterArea && V.productType ? v = ((f = R == null ? void 0 : R.areaSimpleList) == null ? void 0 : f.length) && R.areaSimpleList.filter((P) => P.productType & V.productType) || [] : v = (R == null ? void 0 : R.areaSimpleList) || [], N = ((m = v == null ? void 0 : v.map((P) => P.planAreaBatchDTOS)) == null ? void 0 : m.flat()) || [], c("getAreaInfo", v, _), c("planAreaBatchInfo", N, _), c("getCurrentInfo", R);
    }
    c("update:modelValue", _), c("change", _);
  }
  return o({ getOption: S, getProductType: h, fetchData: g }), (_, f) => {
    const m = zo, R = Bo;
    return w(), Q("div", QB, [s(R, ii({ modelValue: r.value, "onUpdate:modelValue": f[0] || (f[0] = (v) => r.value = v), clearable: e.clearable, "collapse-tags": e.collapseTags, disabled: e.disabled, loading: u.value, multiple: e.multiple, "no-data-text": e.projectId ? "无数据" : "未选择项目", placeholder: e.placeholder, size: e.size, filterable: "" }, M(_.$attrs), { onChange: T }), { default: p(() => [e.showAll ? (w(), U(m, { key: 0, value: void 0, label: "全部单体" })) : H("", true), (w(true), Q(Qe, null, ki(E.value, (v) => (w(), U(m, { key: v.value, label: v.label, value: v.value }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 16, ["modelValue", "clearable", "collapse-tags", "disabled", "loading", "multiple", "no-data-text", "placeholder", "size"])]);
  };
} }, JB = ut(ZB, [["__scopeId", "data-v-94a1214c"]]);
const XB = { style: { display: "inline-block" } }, $B = { __name: "monomer-select-area-select", props: { monomerId: { type: [Number, String, void 0] }, areaId: { type: [Number, String, Array, void 0] }, projectId: { type: [Number, String, void 0] }, itemizedType: { type: [Number, String, void 0] }, productType: { type: [Number, String, void 0] }, category: { type: [Number, String, void 0] }, needConvert: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, areaClearable: { type: Boolean, default: false }, monomerDefault: { type: Boolean, default: false }, areaDefault: { type: Boolean, default: false }, monomerDisabled: { type: Boolean, default: false }, areaDisabled: { type: Boolean, default: false }, filterArea: { type: Boolean, default: true }, areaMultiple: { type: Boolean, default: false } }, emits: ["change", "update:monomerId", "update:areaId", "monomerChange", "areaChange"], setup(e, { expose: o, emit: n }) {
  const c = n, u = e, r = Ee(() => u.productType), E = Z(), y = Z(), b = Z(), V = Z([]), M = Z([]), g = Z([]), S = Z([]), h = Z([]), T = Z([]);
  Ce(() => u.monomerId, (N) => {
    y.value = N;
  }, { immediate: true }), Ce(() => u.areaId, (N) => {
    b.value = N;
  }, { immediate: true }), Ce(() => b, (N) => {
    var P;
    N && (V.value.length > 0 ? u.areaMultiple ? M.value = V.value.filter((L) => {
      var O;
      return (O = b.value) == null ? void 0 : O.includes(L.id);
    }).map((L) => L.planAreaBatchDTOS).flat() : M.value = (P = V.value.filter((L) => b.value === L.id)[0]) == null ? void 0 : P.planAreaBatchDTOS : M.value = []);
  }, { immediate: true, deep: true });
  function _(N) {
    var P, L;
    N ? (g.value = (P = T.value) == null ? void 0 : P.filter((O) => (O == null ? void 0 : O.areaId) === N), h.value = (L = S.value) == null ? void 0 : L.filter((O) => (O == null ? void 0 : O.areaId) === N)) : (g.value = T.value, h.value = S.value), c("update:areaId", b.value), c("areaChange"), c("change", { monomerId: y.value, areaId: b.value });
  }
  function f(N, P) {
    var L;
    V.value = N.filter((O) => {
      let x = true;
      return u.filterArea && r.value && !(O.productCategory & r.value) && (x = false), u.itemizedType && O.itemizedType !== u.itemizedType && (x = false), x;
    }) || [], P ? h.value = (L = S.value) == null ? void 0 : L.filter((O) => (O == null ? void 0 : O.monomerId) === P) : h.value = S.value, c("update:monomerId", P), c("monomerChange"), c("change", { monomerId: y.value });
  }
  function m(N, P) {
    T.value = JSON.parse(JSON.stringify(N)), g.value = N;
  }
  function R(N) {
    S.value = JSON.parse(JSON.stringify(N)), h.value = N;
  }
  function v() {
    var N;
    return ((N = E.value) == null ? void 0 : N.getProductType(y.value)) || {};
  }
  return o({ getProductType: v, planAreaBatch: M }), (N, P) => {
    const L = Ve("common-select");
    return w(), Q("div", XB, [s(l(JB), { ref_key: "monomerRef", ref: E, modelValue: y.value, "onUpdate:modelValue": P[0] || (P[0] = (O) => y.value = O), clearable: e.clearable, default: e.monomerDefault, disabled: e.monomerDisabled, filterArea: false, class: "filter-item", productType: r.value, "project-id": e.projectId, onGetAreaInfo: f, onPlanAreaBatchInfo: m, onGetBatchList: R }, null, 8, ["modelValue", "clearable", "default", "disabled", "productType", "project-id"]), xt(N.$slots, "middle", {}, void 0, true), s(L, { modelValue: b.value, "onUpdate:modelValue": P[1] || (P[1] = (O) => b.value = O), clearable: e.areaClearable, dataStructure: { key: "id", label: "name", value: "id" }, default: e.areaDefault, disabled: e.areaDisabled, multiple: e.areaMultiple, noDataText: y.value ? "暂无数据" : "未选择单体", options: V.value, class: "filter-item", placeholder: "请选择区域", size: "default", style: { width: "200px" }, onChange: _ }, null, 8, ["modelValue", "clearable", "default", "disabled", "multiple", "noDataText", "options"]), xt(N.$slots, "right", { planAreaBatch: M.value, planAreaBatchInfo: g.value, batchList: h.value, areaList: V.value }, void 0, true)]);
  };
} }, md = ut($B, [["__scopeId", "data-v-56c58c3d"]]);
const eH = { class: "manuf-requisitions-application-container" }, tH = { class: "filter-container" }, iH = { class: "filter-left-box" }, aH = { class: "head-container", style: { "margin-bottom": "0px" } }, lH = { class: "filter-right-box" }, oH = { __name: "index", props: { detail: { type: Object }, isEdit: { type: Boolean, default: false }, formHistory: { type: Object } }, emits: ["success"], setup(e, { expose: o, emit: n }) {
  const c = n, u = e, r = { list: [] }, E = Z(), y = Z(), b = Z(), V = Z({}), M = Z(false), g = Z([]), S = Ee(() => {
    let ee = false;
    return A(u.formHistory) && (h.finishedProductType === u.formHistory.finishedProductType ? ee = true : ee = false), ee;
  });
  yi("customQuery", Ee(() => V.value));
  const { form: h, FORM: T } = Pa({ title: "制成品申购", defaultForm: r, api: u.isEdit ? nn.edit : nn.add }, b, u.detail);
  Ce(() => u.detail, (ee = {}) => {
    h.purchaseListObj = {}, h.finishedProductType = ee.finishedProductType, h.materialType = ee.materialType, h.branchCompanyId = ee.branchCompanyId, h.serialNumber = ee.serialNumber, V.value.branchCompanyId = ee.branchCompanyId;
  }, { deep: true, immediate: true }), Ce(() => h.branchCompanyId, (ee) => {
    V.value.projectId = void 0;
  });
  const { maxHeight: _ } = Kt({ mainBox: ".requisitions-application-record-form", extraBox: [".el-drawer__header", ".filter-container", ".requisitions-application-header", ".requisitions-application-select", ".requisitions-application-footer"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, paginate: true, navbar: false, minHeight: 300, extraHeight: 200 }), f = Ee(() => {
    switch (h.finishedProductType) {
      case Fa.STRUC_MANUFACTURED.V:
        return Fv;
      case Fa.ENCL_MANUFACTURED.V:
        return jv;
      default:
        return;
    }
  }), m = Ee(() => A(h.list) ? Object.keys(h.list).length : 0);
  function R() {
    var ee, B, q, ae;
    if (y.value) {
      const j = y.value.selectList;
      if (!(j != null && j.length)) {
        ot.warning("请选择数据");
        return;
      }
      if (g.value = [...g.value, ...At(j)], h.finishedProductType === Fa.STRUC_MANUFACTURED.V) {
        const le = [];
        if (A(g.value)) for (let oe = 0; oe < g.value.length; oe++) le.indexOf((ee = g.value[oe]) == null ? void 0 : ee.productId) === -1 ? le.push((B = g.value[oe]) == null ? void 0 : B.productId) : (g.value.splice(oe, 1), oe--);
      } else if (A(g.value)) {
        const le = [];
        for (let oe = 0; oe < g.value.length; oe++) le.indexOf((q = g.value[oe]) == null ? void 0 : q.id) === -1 ? le.push((ae = g.value[oe]) == null ? void 0 : ae.id) : (g.value.splice(oe, 1), oe--);
      }
      A(g.value) && g.value.forEach((le) => {
        h.finishedProductType === Fa.STRUC_MANUFACTURED.V ? (le.basicClass = on.STRUC_MANUFACTURED.V, le.weight = le.netWeight) : le.basicClass = on.ENCL_MANUFACTURED.V;
      }), h.list = At(g.value), h.type = Dc.MANUFACTURED.V;
    }
  }
  function v({ id: ee, quantity: B }, q, ae) {
    h.finishedProductType === Fa.STRUC_MANUFACTURED.V ? (h.list.splice(h.list.findIndex((j) => j.productId === q.productId), 1), g.value.splice(g.value.findIndex((j) => j.productId === q.productId), 1)) : (h.list.splice(h.list.findIndex((j) => j.id === q.id), 1), g.value.splice(g.value.findIndex((j) => j.id === q.id), 1)), y.value.deleteRow(q);
  }
  function N() {
    h.list = [], g.value = [], y.value.deleteAll();
  }
  function P() {
    var ee;
    (ee = y.value) == null || ee.refreshList();
  }
  function L() {
    var ee;
    (ee = y.value) == null || ee.refresh();
  }
  function O() {
    V.value.projectId = void 0, V.value.monomerId = void 0, V.value.areaId = void 0, V.value.serialNumber = void 0, L();
  }
  async function x() {
    let ee = true;
    ee = Y(), M.value = ee;
  }
  Ce(() => h.finishedProductType, (ee, B) => {
    ee && B && (h.list = [], g.value = []);
  }, { immediate: true }), T.HOOK.beforeToEdit = async (ee, B) => {
    var q, ae, j;
    A(B.list) && (V.value.projectId = (ae = (q = B.list[0]) == null ? void 0 : q.project) == null ? void 0 : ae.id, B.list.forEach((le) => {
      le.name = le.manufacturedName, le.serialNumber = le.manufacturedSn, B.finishedProductType === Fa.STRUC_MANUFACTURED.V && (le.productId = le.artifactEnclosureId, le.netWeight = le.weight), B.finishedProductType === Fa.ENCL_MANUFACTURED.V && (le.id = le.artifactEnclosureId, le.category = le.manufacturedType);
    }), g.value = At((j = u.formHistory) == null ? void 0 : j.list));
  };
  function I() {
    var ee;
    h.finishedProductType === u.formHistory.finishedProductType ? (S.value = true, h.list = At((ee = u.formHistory) == null ? void 0 : ee.list), g.value = [...h.list]) : S.value = false;
  }
  Ce(() => V.value.projectId, (ee, B) => {
    A(B) && (g.value = [], h.list = [], P());
  }), T.HOOK.afterSubmit = () => {
    c("success");
  };
  function Y() {
    return Ae(h.branchCompanyId) ? (ot.warning("请选择申购单位"), false) : Ae(h.list) ? (ot.warning("请选择数据"), false) : true;
  }
  return o({ refreshList: P }), (ee, B) => {
    const q = Mt, ae = Ve("common-button"), j = pa, le = zn, oe = Li;
    return w(), Q("div", eH, [s(wr, { ref_key: "commonWrapperRef", ref: E, "show-footer": false }, { default: p(() => [C("div", tH, [C("div", iH, [C("div", aH, [s(ca, { modelValue: V.value.projectId, "onUpdate:modelValue": B[0] || (B[0] = (ye) => V.value.projectId = ye), "branch-company-id": l(h).branchCompanyId, class: "filter-item", clearable: "", filterable: "", placeholder: "可选择项目搜索", onChange: P }, null, 8, ["modelValue", "branch-company-id"]), l(A)(V.value.projectId) && l(h).finishedProductType === l(Fa).STRUC_MANUFACTURED.V ? (w(), U(md, { key: 0, areaId: V.value.areaId, "onUpdate:areaId": B[1] || (B[1] = (ye) => V.value.areaId = ye), monomerId: V.value.monomerId, "onUpdate:monomerId": B[2] || (B[2] = (ye) => V.value.monomerId = ye), areaType: l(su).OUTSOURCE.V, "project-id": V.value.projectId, areaClearable: "", class: "filter-item", clearable: "", onChange: P }, null, 8, ["areaId", "monomerId", "areaType", "project-id"])) : H("", true), s(q, { modelValue: V.value.serialNumber, "onUpdate:modelValue": B[3] || (B[3] = (ye) => V.value.serialNumber = ye), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "输入编号搜索", size: "default", style: { width: "200px" }, onKeyup: $i(P, ["enter"]) }, null, 8, ["modelValue"]), s(ae, { class: "filter-item", icon: "el-icon-search", size: "default", type: "success", onClick: Pi(P, ["stop"]) }, { default: p(() => B[5] || (B[5] = [Te(" 搜索 ")])), _: 1, __: [5] }), s(ae, { class: "filter-item", icon: "el-icon-refresh-left", size: "default", type: "warning", onClick: Pi(O, ["stop"]) }, { default: p(() => B[6] || (B[6] = [Te(" 重置 ")])), _: 1, __: [6] })])]), C("div", lH, [e.isEdit && S.value ? (w(), U(j, { key: 0, title: "确定要回到编辑前状态吗?", onConfirm: I }, { reference: p(() => [s(ae, { class: "filter-item", size: "default", type: "danger" }, { default: p(() => B[7] || (B[7] = [Te(" 回到编辑前状态 ")])), _: 1, __: [7] })]), _: 1 })) : H("", true), s(ae, { class: "filter-item", icon: "el-icon-plus", size: "default", type: "warning", onClick: R }, { default: p(() => B[8] || (B[8] = [Te(" 选择加入 ")])), _: 1, __: [8] }), s(le, { hidden: m.value < 1, max: 99, value: m.value, style: { "margin-right": "10px" } }, { default: p(() => [s(ae, { class: "filter-item", icon: "el-icon-shopping-cart", size: "default", type: "success", onClick: x }, { default: p(() => B[9] || (B[9] = [Te(" 申购车 ")])), _: 1, __: [9] })]), _: 1 }, 8, ["hidden", "value"])])]), s(oe, { ref_key: "formRef", ref: b, model: l(h) }, { default: p(() => [(w(), U(Ri(f.value), { ref_key: "tableRef", ref: y, "max-height": l(_), selectListHistory: g.value }, null, 8, ["max-height", "selectListHistory"]))]), _: 1 }, 8, ["model"])]), _: 1 }, 512), s(G_, { modelValue: M.value, "onUpdate:modelValue": B[4] || (B[4] = (ye) => M.value = ye), "is-manufactured": "", onManufDel: v, onManufDelAll: N }, null, 8, ["modelValue"])]);
  };
} }, zv = ut(oH, [["__scopeId", "data-v-0414e560"]]), nH = Object.freeze(Object.defineProperty({ __proto__: null, default: zv }, Symbol.toStringTag, { value: "Module" }));
function sH(e, o) {
  const n = [{ title: "行号", key: "rowIndex", wch: 10 }, { title: "错误信息", key: "error", wch: 80 }], c = e.map((u) => ({ rowIndex: u.rowIndex, error: u.error }));
  Di({ type: "error", title: "导入失败,请查看错误清单", duration: 8e3 }), pl({ headers: n, data: c, filename: "申购清单-错误清单", sheetName: "错误清单" });
}
const Z_ = { title: "办公用品申购清单", dlgWidth: "1500px", startRow: 2, endIgnoreRow: 1, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_2" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_3" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_4" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_5" }, { label: "颜色", field: "color", excelField: "__EMPTY_6" }, { label: "所属项目（简称）", field: "shortName", excelField: "__EMPTY_7" }, { label: "需求时间", field: "arrivalTime", excelField: "__EMPTY_8" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }] }, format: async (e) => {
  var S;
  if (!gi(e, Z_.rules)) return;
  _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree");
  const n = _e.state.config.rawMatClsList.filter((h) => h.basicClass === Ge.OTHER.V), c = _e.state.config.rawMatClsKV, u = At(e), r = [];
  let E = [];
  const y = [], b = [], V = [];
  u.forEach((h, T) => {
    let _ = false;
    const f = pi(h.classifyName.split("/"));
    if (f.length === 1) {
      const m = n.filter((R) => R.name === h.classifyName) || [];
      if (A(m)) if (m.length === 1) _ = true, h.classifyId = m[0].id, r.push(m[0].id);
      else {
        const R = [];
        for (const N of m) if (N.isLeaf) for (let P = 0; P < N.fullPathId.length; P++) N.id !== N.fullPathId[P] && R.push(N.fullPathId[P]);
        const v = m.find((N) => Ae(N.parent) && !R.includes(N.id));
        if (A(v)) _ = true, h.classifyId = v.id, r.push(v.id);
        else {
          const N = m.filter((P) => P.isLeaf) || [];
          if (N.length === 1) {
            let P = true;
            m.forEach((L) => {
              N[0].fullPathId.includes(L.id) || (P = false);
            }), P && (_ = true, h.classifyId = N[0].id, r.push(N[0].id));
          } else for (const P of m) A(P.parent) && !R.includes(P.id) && y.push(P);
        }
      }
      y.length > 1 && V.push({ rowIndex: T + 1, error: `科目名称"${h.classifyName}"在科目配置中存在同名的情况，需要带上父级科目名称如"一级科目/二级科目/末级科目"` });
    } else for (const m of n) if (m.fullPathName.length >= f.length && mi(m.fullPathName.slice(-f.length), f)) {
      _ = true, h.classifyId = m.id, r.push(m.id);
      break;
    }
    if (_ || (E.push(h.classifyName), b.some((m) => m.classifyName === h.classifyName) || b.push({ rowIndex: T + 1, classifyName: h.classifyName })), h.shortName) {
      const m = _e.state.project.projectAllType.find((R) => R.shortName === h.shortName);
      m ? h.projectId = m.id : V.push({ rowIndex: T + 1, error: `名称为“${h.shortName}”的项目不存在”` });
    } else h.projectId = -1;
    h.arrivalTime ? h.arrivalTime = yr(h.arrivalTime) : h.arrivalTime = "同上";
  }), E = Array.from(new Set(E)), E.length > 0 && (V.push({ rowIndex: b[0].rowIndex, error: `${b.map((h) => `"${h.classifyName}"`).join("、")}${b.length > 1 ? "等" : ""}物料种类不存在` }), b.shift());
  const M = _e.state.config.classifySpec, g = r.filter((h) => M[h] === void 0);
  g.length > 0 && (g.forEach((h) => {
    M[h] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", g));
  for (const h of u) {
    if (((S = c == null ? void 0 : c[h.classifyId]) == null ? void 0 : S.isLeaf) === false) {
      V.push({ rowIndex: u.indexOf(h) + 1, error: `${h.classifyName}不是末级科目` });
      continue;
    }
    const T = M[h.classifyId];
    if ((T == null ? void 0 : T.hasUnitConfig) === false) {
      V.push({ rowIndex: u.indexOf(h) + 1, error: `${h.classifyName}未配置核算单位` });
      continue;
    }
    let _;
    const f = h.specification ?? "";
    if (T && Array.isArray(T.specList)) {
      for (const m of T.specList) if (f === m.spec) {
        if (_ = m, h.measureUnit) {
          if (!_.classify.measureUnit) throw new Error(`${h.classifyName}不存在计量单位`);
          if (!await ti(_.classify.measureUnit, h.measureUnit)) throw new Error(`${h.classifyName}填写的计量单位错误，单位应为：“${_.classify.measureUnit}”`);
        }
        if (h.accountingUnit && !await ti(_.classify.accountingUnit, h.accountingUnit)) throw new Error(`${h.classifyName}填写的核算单位错误，单位应为：“${_.classify.accountingUnit}”`);
        break;
      }
    }
    if (_) h.uid = Tt(), h.sn = _.sn, h.specificationLabels = _.specificationLabels, h.serialNumber = _.serialNumber, h.classifySerialNumber = _.classify.serialNumber, h.classifyId = _.classify.id, h.classifyFullPathId = _.classify.fullPathId, h.classifyFullName = _.classify.fullName, h.classifyName = _.classify.name, h.classifyParentFullName = _.classify.parentFullName, h.basicClass = _.classify.basicClass, h.specification = _.spec, h.specificationMap = _.specKV, h.measureUnit = _.classify.measureUnit, h.accountingUnit = _.classify.accountingUnit, h.accountingPrecision = _.classify.accountingPrecision, h.measurePrecision = _.classify.measurePrecision, h.quantity && (h.quantity = Be(h.quantity, h.measurePrecision)), h.mete && (h.mete = Be(h.mete, h.accountingPrecision)), h.measureUnit || (h.quantity = void 0);
    else {
      const m = `${h.classifyName}下不存在规格为"${f}"的材料，请联系管理员/仓库人员添加`;
      V.some((R) => R.error === m) || V.push({ rowIndex: u.indexOf(h) + 1, error: m });
      continue;
    }
  }
  if (V.length > 0) sH(V);
  else return u;
} };
