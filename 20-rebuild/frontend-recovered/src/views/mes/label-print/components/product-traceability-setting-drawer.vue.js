import { ref as r } from "vue";
import { computed as h } from "vue";
import { watch as Ia } from "vue";
import { resolveComponent as be } from "vue";
import { resolveDirective as xa } from "vue";
import { openBlock as s } from "vue";
import { createBlock as m } from "vue";
import { withCtx as u } from "vue";
import { withDirectives as I } from "vue";
import { createTextVNode as g } from "vue";
import { createCommentVNode as b } from "vue";
import { unref as $ } from "vue";
import { createVNode as p } from "vue";
import { createElementVNode as d } from "vue";
import { createElementBlock as c } from "vue";
import { Fragment as he } from "vue";
import { toDisplayString as N } from "vue";
import { renderList as Re } from "vue";
import { withModifiers as Ue } from "vue";
import { nextTick as Pa } from "vue";
import { ElMessage as M } from "element-plus";
import { ElInput as Ba } from "element-plus";
import { ElInputNumber as $a } from "element-plus";
import { ElTableColumn as Sa } from "element-plus";
import { ElOption as za } from "element-plus";
import { ElSelect as Ea } from "element-plus";
import { ElTabPane as Ra } from "element-plus";
import { ElSwitch as Ua } from "element-plus";
import { ElTabs as Ma } from "element-plus";
import { vLoading as Ta } from "element-plus";
import { l as P, _ as Fa, fg as qa, o as Aa, V as x, aw as Me, O as Te } from "../../../../shared/runtime.js";
function Oa(v) {
  return P({ url: "/api/system/product-traceability-config/list", method: "get", params: v, cancelKey: false });
}
function Ka(v) {
  return P({ url: "/api/system/product-traceability-config/save-batch", method: "post", data: v, cancelKey: false });
}
function Ha() {
  return P({ url: "/api/system/product-traceability-config/getDefault", method: "get", cancelKey: false });
}
function Ja(v) {
  return P({ url: "/api/system/product-traceability-config/save-default", method: "post", data: v, cancelKey: false });
}
function Qa() {
  return P({ url: "/api/trace/config/traceability", method: "get", cancelKey: false });
}
function Wa(v) {
  return P({ url: "/api/trace/config/traceability", method: "post", data: v, cancelKey: false });
}
function wa(v) {
  return P({ url: "/api/trace/config/traceability", method: "put", data: v, cancelKey: false });
}
function Ga(v) {
  return P({ url: "/api/trace/config/traceability", method: "delete", data: v, cancelKey: false });
}
const Xa = "/static/svg/preview-bg-0822e6cd.svg";
const Ya = { class: "setting-layout" }, Za = { class: "setting-list" }, et = { class: "default-config-header" }, at = { class: "default-config-actions" }, tt = { class: "default-config-body" }, lt = { class: "default-config-item" }, nt = { class: "default-config-label" }, st = { key: 0, class: "required-mark" }, it = { key: 1, class: "default-config-value" }, ot = { class: "default-config-item" }, ut = { key: 1, class: "default-config-value" }, dt = { class: "default-config-item" }, rt = { class: "default-config-label" }, ct = { key: 0, class: "required-mark" }, mt = { key: 1, class: "default-config-value" }, ft = { key: 0, class: "table-toolbar" }, pt = { key: 0, class: "required-mark" }, vt = { key: 1 }, yt = { key: 0, class: "required-mark" }, gt = { key: 1 }, bt = { key: 1 }, ht = { key: 0, class: "required-mark" }, Nt = { key: 1 }, _t = { class: "setting-preview" }, kt = { class: "phone-preview" }, Ct = ["src"], Vt = { class: "preview-company" }, Lt = { class: "preview-system" }, Dt = { class: "preview-base" }, jt = { class: "content-custom-panel" }, It = { key: 0, class: "table-toolbar content-table-toolbar" }, xt = { key: 0, class: "required-mark" }, Pt = { key: 1 }, Bt = { key: 0, class: "required-mark" }, $t = { key: 1 }, St = { key: 1 }, zt = { key: 1 }, Et = { __name: "product-traceability-setting-drawer", props: { visible: { type: Boolean, default: false }, editPermission: { type: Array, default: () => [] } }, emits: ["update:visible"], setup(v, { emit: Fe }) {
  const qe = Fe, H = v, D = r("nameCustom"), f = r([]), T = r([]), J = r("[]"), _ = r([]), R = r([]), Q = r("[]"), S = r([]), W = r(), Ne = r(), U = r(/* @__PURE__ */ new Set()), w = r(false), G = r(false), F = r(false), q = r(false), X = r(false), z = r(false), Y = r(5), _e = r(false), k = r(false), C = r(false), j = r(false), Z = { companyName: "杭州初鸣建筑科技有限公司", systemName: "初鸣智造", productionBaseName: "杭州初鸣建筑科技有限公司" }, y = r(de()), ee = r(de()), ae = r(JSON.stringify(ce(y.value))), { projectTree: Ae } = qa(), te = h({ get: () => H.visible, set: (e) => qe("update:visible", e) }), Oe = h(() => Ae.value.map((e) => ({ ...e, serialNumberName: `${e.serialNumber ? `${e.serialNumber} ` : ""}${e.name || ""}` }))), A = h(() => {
    const e = new Map(Oe.value.map((a) => [a.id, a]));
    return f.value.forEach((a) => {
      var l;
      (l = a.projectList) == null || l.forEach((n) => {
        e.has(n.id) || e.set(n.id, { ...n, serialNumberName: `${n.serialNumber ? `${n.serialNumber} ` : ""}${n.name || n.shortName || ""}` });
      });
    }), _.value.forEach((a) => {
      var l;
      (l = a.displayProjects) == null || l.forEach((n) => {
        e.has(n.id) || e.set(n.id, { ...n, serialNumberName: `${n.serialNumber ? `${n.serialNumber} ` : ""}${n.name || n.shortName || ""}` });
      });
    }), Array.from(e.values());
  }), le = h(() => fe(f.value) !== J.value), ne = h(() => ve(_.value) !== Q.value || S.value.length > 0), ke = h(() => me(y.value) !== ae.value), B = h(() => {
    var e;
    return ((e = H.editPermission) == null ? void 0 : e.length) > 0;
  }), se = h(() => D.value === "contentCustom" ? C.value : k.value), Ke = h(() => D.value === "contentCustom" ? ne.value : le.value), ie = h(() => D.value === "contentCustom" ? q.value : F.value), He = h(() => D.value === "contentCustom" ? R.value.length > 0 || ne.value : T.value.length > 0 || le.value), oe = h(() => f.value.find((e) => e.uid === W.value) || {}), ue = h(() => ({ companyName: y.value.companyName || Z.companyName, systemName: y.value.systemName || Z.systemName, productionBaseName: y.value.productionBaseName || Z.productionBaseName })), Je = h(() => ({ projectIdList: [{ required: true, message: "请选择项目", trigger: "change" }, { validator: (e, a) => Array.isArray(e) && e.length > 0 && !U.value.has(a.uid), message: "项目不可重复", trigger: "change" }], systemName: [{ required: true, max: 30, message: "请输入系统名称", trigger: "blur" }], companyName: [{ required: true, max: 40, message: "请输入公司名称", trigger: "blur" }] })), Ce = /* @__PURE__ */ new Map([]), { tableValidate: Qe, cleanUpData: We, wrongCellMask: we } = Me({ rules: Je, ditto: Ce }), Ge = h(() => ({ fieldName: [{ required: true, max: 30, message: "请输入字段名称", trigger: "blur" }], fieldValue: [{ required: true, max: 100, message: "请输入字段值", trigger: "blur" }] })), { tableValidate: Xe, cleanUpData: Ye, wrongCellMask: Ze } = Me({ rules: Ge, ditto: Ce }), { maxHeight: Ve } = Aa({ mainBox: ".product-traceability-setting-drawer", extraBox: [".el-drawer__header", ".setting-tabs > .el-tabs__header", ".default-config-panel", ".table-toolbar"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, navbar: false, extraHeight: 40, minHeight: 360 }, _e);
  Ia(() => H.visible, (e) => {
    e && (_e.value = true, D.value = "nameCustom", je(), Ie(), xe());
  });
  function de(e = {}) {
    return { id: e.id, boolDefault: e.boolDefault ?? true, systemName: e.systemName || "", productionBaseName: e.productionBaseName || "", companyName: e.companyName || "" };
  }
  function re(e = {}) {
    var l, n;
    const a = (l = e.projectIdList) != null && l.length ? e.projectIdList : (n = e.projectList) != null && n.length ? e.projectList.map((L) => L.id) : e.projectId ? [e.projectId] : [];
    return { uid: e.id || `${Date.now()}_${Math.random()}`, id: e.id, projectIdList: a, projectList: e.projectList || [], systemName: e.systemName || "", productionBaseName: e.productionBaseName || "", companyName: e.companyName || "" };
  }
  function Le(e = {}) {
    var l, n;
    const a = (l = e.displayProjectIds) != null && l.length ? e.displayProjectIds : (n = e.displayProjects) != null && n.length ? e.displayProjects.map((L) => L.id) : [];
    return { uid: e.id || `${Date.now()}_${Math.random()}`, id: e.id, sort: e.sort || 1, fieldName: e.fieldName || "", fieldValue: e.fieldValue || "", displayProjectIds: a, displayProjects: e.displayProjects || [], enableFlag: e.enableFlag ?? 1 };
  }
  function ce(e) {
    return { id: e.id, boolDefault: true, systemName: e.systemName ? e.systemName.trim() : "", productionBaseName: e.productionBaseName ? e.productionBaseName.trim() : "", companyName: e.companyName ? e.companyName.trim() : "" };
  }
  function me(e) {
    return JSON.stringify(ce(e));
  }
  function ea(e) {
    return { id: e.id, projectIdList: Array.isArray(e.projectIdList) ? e.projectIdList.filter((a) => a != null) : [], systemName: e.systemName ? e.systemName.trim() : "", productionBaseName: e.productionBaseName ? e.productionBaseName.trim() : "", companyName: e.companyName ? e.companyName.trim() : "" };
  }
  function De(e) {
    return e.map(ea);
  }
  function fe(e) {
    return JSON.stringify(De(e));
  }
  function aa(e, a = 0) {
    return { id: e.id, sort: a + 1, fieldName: e.fieldName ? e.fieldName.trim() : "", fieldValue: e.fieldValue ? e.fieldValue.trim() : "", displayProjectIds: Array.isArray(e.displayProjectIds) ? e.displayProjectIds.filter((l) => l != null) : [], enableFlag: e.enableFlag ?? 1 };
  }
  function pe(e) {
    return e.map(aa);
  }
  function ve(e) {
    return JSON.stringify(pe(e));
  }
  function ta(e) {
    return Array.isArray(e) ? e : (e == null ? void 0 : e.content) || (e == null ? void 0 : e.list) || (e == null ? void 0 : e.records) || [];
  }
  async function je() {
    try {
      X.value = true;
      const e = await Ha();
      ee.value = de(e || {}), y.value = x(ee.value), ae.value = me(y.value), j.value = false;
    } catch (e) {
      console.log("获取溯源查询系统默认配置失败", e);
    } finally {
      X.value = false;
    }
  }
  async function Ie() {
    try {
      w.value = true, U.value = /* @__PURE__ */ new Set();
      const e = await Oa({ pageNumber: 1, pageSize: 9999 }), a = (e == null ? void 0 : e.content) || [];
      T.value = a.map(re), f.value = x(T.value), J.value = fe(f.value), V(), k.value = f.value.length === 0 && B.value;
    } catch (e) {
      console.log("获取溯源查询系统配置失败", e);
    } finally {
      w.value = false;
    }
  }
  async function xe() {
    try {
      G.value = true, S.value = [];
      const e = await Qa(), a = ta(e);
      R.value = a.map(Le), _.value = x(R.value), Q.value = ve(_.value), C.value = false;
    } catch (e) {
      console.log("获取溯源配置明细失败", e);
    } finally {
      G.value = false;
    }
  }
  function la() {
    B.value && (D.value === "contentCustom" ? C.value = true : k.value = true);
  }
  function na() {
    if (D.value === "contentCustom") {
      _.value = x(R.value), S.value = [], Q.value = ve(_.value), C.value = false;
      return;
    }
    U.value = /* @__PURE__ */ new Set(), f.value = x(T.value), J.value = fe(f.value), V(f.value[0]), k.value = f.value.length === 0 && B.value;
  }
  function sa() {
    B.value && (j.value = true);
  }
  function ia() {
    y.value = x(ee.value), ae.value = me(y.value), j.value = false;
  }
  function oa() {
    V();
  }
  function ua(e) {
    return f.value.filter((a) => a.uid !== e.uid).reduce((a, l) => a.concat(l.projectIdList || []), []);
  }
  function V(e) {
    Ne.value = e, W.value = e == null ? void 0 : e.uid;
  }
  function da({ row: e }) {
    return e === Ne.value ? "traceability-current-row" : "";
  }
  function O(e) {
    V(e), e != null && e.verify && (e.verify = {}), e.projectList = Pe(e);
  }
  function ra() {
    const e = re();
    f.value.push(e), V(e), ye();
  }
  function ca() {
    const e = Le({ sort: _.value.length + 1 });
    _.value.push(e), ye();
  }
  function ma() {
    const e = Array.from({ length: Y.value }, () => re());
    f.value.push(...e), V(e[0]), ye();
  }
  function ye() {
    Pa(() => {
      const e = document.querySelector(".product-traceability-setting-drawer .el-table__body-wrapper");
      e && (e.scrollTop = e.scrollHeight);
    });
  }
  function fa(e, a) {
    f.value.splice(a, 1), W.value === e.uid && V(f.value[a] || f.value[a - 1] || f.value[0]), U.value = /* @__PURE__ */ new Set();
  }
  async function pa(e, a) {
    e.id && S.value.push(e.id), _.value.splice(a, 1);
  }
  function K(e) {
    e != null && e.verify && (e.verify = {}), e.displayProjects = Be(e);
  }
  function va() {
    const e = /* @__PURE__ */ new Set(), a = /* @__PURE__ */ new Map();
    f.value.forEach((l) => {
      var n;
      (n = l.projectIdList) == null || n.forEach((L) => {
        const o = a.get(L) || [];
        o.push(l.uid), a.set(L, o);
      });
    }), a.forEach((l) => {
      l.length > 1 && l.forEach((n) => e.add(n));
    }), U.value = e;
  }
  const ya = Te(() => {
    D.value === "contentCustom" ? Na() : ha();
  }, 300), ga = Te(() => {
    ba();
  }, 300);
  async function ba() {
    if (!B.value || z.value || !ke.value) return;
    const e = ce(y.value);
    if (!e.systemName) {
      M.warning("请输入系统名称");
      return;
    }
    if (!e.companyName) {
      M.warning("请输入公司名称");
      return;
    }
    try {
      z.value = true, await Ja(e), M.success("默认配置保存成功"), await je();
    } catch (a) {
      console.log("保存溯源查询系统默认配置失败", a);
    } finally {
      z.value = false;
    }
  }
  async function ha() {
    if (F.value || !le.value) return;
    va();
    let e = [];
    if (f.value.length) {
      const a = Qe(f.value);
      if (e = a.dealList, f.value = e, !a.validResult) return;
    }
    try {
      F.value = true, await Ka(De(We(x(e)))), M.success("保存成功"), await Ie();
    } catch (a) {
      console.log("保存溯源查询系统配置失败", a);
    } finally {
      F.value = false;
    }
  }
  async function Na() {
    if (q.value || !ne.value) return;
    let e = [];
    if (_.value.length) {
      const o = Xe(_.value);
      if (e = o.dealList, _.value = e, !o.validResult) return;
    }
    const a = pe(Ye(x(e))), l = new Map(pe(R.value).filter((o) => o.id).map((o) => [o.id, JSON.stringify(o)])), n = a.filter((o) => !o.id), L = a.filter((o) => o.id && JSON.stringify(o) !== l.get(o.id));
    try {
      q.value = true, S.value.length && await Ga(S.value), n.length && await Wa(n), L.length && await Promise.all(L.map((o) => wa(o))), M.success("保存成功"), await xe();
    } catch (o) {
      console.log("保存溯源配置明细失败", o);
    } finally {
      q.value = false;
    }
  }
  function Pe(e) {
    return (e.projectIdList || []).map((a) => {
      const l = A.value.find((n) => n.id === a);
      return l ? { id: l.id, name: l.name, shortName: l.shortName, serialNumber: l.serialNumber } : { id: a };
    });
  }
  function Be(e) {
    return (e.displayProjectIds || []).map((a) => {
      const l = A.value.find((n) => n.id === a);
      return l ? { id: l.id, name: l.name, shortName: l.shortName, serialNumber: l.serialNumber } : { id: a };
    });
  }
  function _a(e) {
    var l;
    return ((l = e.projectList) != null && l.length ? e.projectList : Pe(e)).map((n) => `${n.serialNumber ? `${n.serialNumber} ` : ""}${n.name || n.shortName || ""}`).join("，") || "-";
  }
  function ka(e) {
    var l;
    return ((l = e.displayProjects) != null && l.length ? e.displayProjects : Be(e)).map((n) => `${n.serialNumber ? `${n.serialNumber} ` : ""}${n.name || n.shortName || ""}`).join("，") || "默认全部项目";
  }
  function Ca() {
    te.value = false;
  }
  return (e, a) => {
    const l = be("common-button"), n = Ba, L = $a, o = Sa, $e = za, Se = Ea, ze = be("common-table"), Ee = Ra, Va = Ua, La = Ma, Da = be("common-drawer"), E = xa("permission"), ge = Ta;
    return s(), m(Da, { modelValue: te.value, "onUpdate:modelValue": a[5] || (a[5] = (t) => te.value = t), "before-close": Ca, "close-on-click-modal": false, "show-close": true, "custom-class": "product-traceability-setting-drawer", direction: "rtl", size: "88%", title: "溯源查询系统设置" }, { titleRight: u(() => [!se.value && B.value ? I((s(), m(l, { key: 0, size: "default", type: "primary", onClick: la }, { default: u(() => a[6] || (a[6] = [g("编辑")])), _: 1, __: [6] })), [[E, v.editPermission]]) : b("", true), se.value && He.value ? (s(), m(l, { key: 1, disabled: ie.value, size: "default", type: "warning", onClick: na }, { default: u(() => a[7] || (a[7] = [g(" 取消编辑 ")])), _: 1, __: [7] }, 8, ["disabled"])) : b("", true), se.value ? I((s(), m(l, { key: 2, disabled: !Ke.value || ie.value, loading: ie.value, size: "default", type: "primary", onClick: $(ya) }, { default: u(() => a[8] || (a[8] = [g(" 保存 ")])), _: 1, __: [8] }, 8, ["disabled", "loading", "onClick"])), [[E, v.editPermission]]) : b("", true)]), content: u(() => [p(La, { modelValue: D.value, "onUpdate:modelValue": a[4] || (a[4] = (t) => D.value = t), class: "setting-tabs" }, { default: u(() => [p(Ee, { label: "名称自定义", name: "nameCustom" }, { default: u(() => [d("div", Ya, [d("div", Za, [I((s(), c("div", { class: "default-config-panel", onClick: oa }, [d("div", et, [a[12] || (a[12] = d("div", null, [d("div", { class: "default-config-title" }, "系统默认配置"), d("div", { class: "default-config-desc" }, "未命中项目专属配置时使用")], -1)), d("div", at, [!j.value && B.value ? I((s(), m(l, { key: 0, size: "default", type: "primary", onClick: sa }, { default: u(() => a[9] || (a[9] = [g(" 编辑默认配置 ")])), _: 1, __: [9] })), [[E, v.editPermission]]) : b("", true), j.value ? (s(), c(he, { key: 1 }, [p(l, { disabled: z.value, size: "default", onClick: ia }, { default: u(() => a[10] || (a[10] = [g("取消")])), _: 1, __: [10] }, 8, ["disabled"]), I((s(), m(l, { disabled: !ke.value || z.value, loading: z.value, size: "default", type: "primary", onClick: $(ga) }, { default: u(() => a[11] || (a[11] = [g(" 保存默认配置 ")])), _: 1, __: [11] }, 8, ["disabled", "loading", "onClick"])), [[E, v.editPermission]])], 64)) : b("", true)])]), d("div", tt, [d("div", lt, [d("span", nt, [j.value ? (s(), c("span", st, "*")) : b("", true), a[13] || (a[13] = g("系统名称"))]), j.value ? (s(), m(n, { key: 0, modelValue: y.value.systemName, "onUpdate:modelValue": a[0] || (a[0] = (t) => y.value.systemName = t), modelModifiers: { trim: true }, clearable: "", maxlength: "30", placeholder: "请输入系统名称", size: "default" }, null, 8, ["modelValue"])) : (s(), c("span", it, N(y.value.systemName || "-"), 1))]), d("div", ot, [a[14] || (a[14] = d("span", { class: "default-config-label" }, "生产基地名称", -1)), j.value ? (s(), m(n, { key: 0, modelValue: y.value.productionBaseName, "onUpdate:modelValue": a[1] || (a[1] = (t) => y.value.productionBaseName = t), modelModifiers: { trim: true }, clearable: "", maxlength: "30", placeholder: "请输入生产基地名称", size: "default" }, null, 8, ["modelValue"])) : (s(), c("span", ut, N(y.value.productionBaseName || "-"), 1))]), d("div", dt, [d("span", rt, [j.value ? (s(), c("span", ct, "*")) : b("", true), a[15] || (a[15] = g("公司名称"))]), j.value ? (s(), m(n, { key: 0, modelValue: y.value.companyName, "onUpdate:modelValue": a[2] || (a[2] = (t) => y.value.companyName = t), modelModifiers: { trim: true }, clearable: "", maxlength: "40", placeholder: "请输入公司名称", size: "default" }, null, 8, ["modelValue"])) : (s(), c("span", mt, N(y.value.companyName || "-"), 1))])])])), [[ge, X.value]]), k.value ? I((s(), c("div", ft, [d("div", null, [p(l, { icon: "el-icon-plus", size: "default", type: "success", onClick: ra }, { default: u(() => a[16] || (a[16] = [g("新增")])), _: 1, __: [16] }), p(l, { icon: "el-icon-plus", size: "default", type: "primary", onClick: ma }, { default: u(() => a[17] || (a[17] = [g("批量新增")])), _: 1, __: [17] }), p(L, { modelValue: Y.value, "onUpdate:modelValue": a[3] || (a[3] = (t) => Y.value = t), max: 20, min: 2, step: 1, "controls-position": "right", size: "default", style: { width: "96px", "margin-left": "10px" } }, null, 8, ["modelValue"])]), a[18] || (a[18] = d("span", { class: "table-tip" }, "项目不可重复，保存时提交当前表格完整列表", -1))])), [[E, v.editPermission]]) : b("", true), I((s(), m(ze, { "cell-class-name": $(we), data: f.value, "max-height": $(Ve), stripe: false, "show-empty-symbol": false, border: "", "empty-text": "暂无配置", "return-source-data": "", "row-class-name": da, "row-key": "uid", onRowClick: V }, { default: u(() => [p(o, { align: "center", label: "序号", type: "index", width: "60" }), p(o, { "class-name": "traceability-project-cell", key: "projectIdList", label: "项目", "min-width": "260", prop: "projectIdList" }, { header: u(() => [k.value ? (s(), c("span", pt, "*")) : b("", true), a[19] || (a[19] = g("项目"))]), default: u(({ row: t }) => [k.value ? (s(), m(Se, { key: 0, modelValue: t.projectIdList, "onUpdate:modelValue": (i) => t.projectIdList = i, class: "traceability-project-select", clearable: "", filterable: "", multiple: "", placeholder: "请选择项目", size: "default", style: { width: "100%" }, onChange: (i) => O(t), onFocus: (i) => V(t) }, { default: u(() => [(s(true), c(he, null, Re(A.value, (i) => (s(), m($e, { key: i.id, disabled: ua(t).includes(i.id), label: i.serialNumberName, value: i.id }, null, 8, ["disabled", "label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "onChange", "onFocus"])) : (s(), c("span", vt, N(_a(t)), 1))]), _: 1 }), p(o, { key: "systemName", label: "系统名称", "min-width": "170", prop: "systemName" }, { header: u(() => [k.value ? (s(), c("span", yt, "*")) : b("", true), a[20] || (a[20] = g("系统名称"))]), default: u(({ row: t }) => [k.value ? (s(), m(n, { key: 0, modelValue: t.systemName, "onUpdate:modelValue": (i) => t.systemName = i, modelModifiers: { trim: true }, clearable: "", maxlength: "30", placeholder: "请输入系统名称", size: "default", onFocus: (i) => V(t), onInput: (i) => O(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "onFocus", "onInput"])) : (s(), c("span", gt, N(t.systemName || "-"), 1))]), _: 1 }), p(o, { key: "productionBaseName", label: "生产基地名称", "min-width": "170", prop: "productionBaseName" }, { default: u(({ row: t }) => [k.value ? (s(), m(n, { key: 0, modelValue: t.productionBaseName, "onUpdate:modelValue": (i) => t.productionBaseName = i, modelModifiers: { trim: true }, clearable: "", maxlength: "30", placeholder: "请输入生产基地名称", size: "default", onFocus: (i) => V(t), onInput: (i) => O(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "onFocus", "onInput"])) : (s(), c("span", bt, N(t.productionBaseName || "-"), 1))]), _: 1 }), p(o, { key: "companyName", label: "公司名称", "min-width": "190", prop: "companyName" }, { header: u(() => [k.value ? (s(), c("span", ht, "*")) : b("", true), a[21] || (a[21] = g("公司名称"))]), default: u(({ row: t }) => [k.value ? (s(), m(n, { key: 0, modelValue: t.companyName, "onUpdate:modelValue": (i) => t.companyName = i, modelModifiers: { trim: true }, clearable: "", maxlength: "40", placeholder: "请输入公司名称", size: "default", onFocus: (i) => V(t), onInput: (i) => O(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "onFocus", "onInput"])) : (s(), c("span", Nt, N(t.companyName || "-"), 1))]), _: 1 }), k.value ? (s(), m(o, { key: 0, align: "center", fixed: "right", label: "操作", width: "80" }, { default: u(({ row: t, $index: i }) => [p(l, { icon: "el-icon-delete", size: "default", style: { padding: "6px" }, type: "danger", onClick: Ue((ja) => fa(t, i), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })) : b("", true)]), _: 1 }, 8, ["cell-class-name", "data", "max-height"])), [[ge, w.value]])]), d("div", _t, [a[23] || (a[23] = d("div", { class: "preview-title" }, "溯源页面效果预览", -1)), d("div", kt, [d("img", { src: $(Xa), alt: "溯源查询系统预览背景" }, null, 8, Ct), d("div", Vt, N(oe.value.companyName || ue.value.companyName), 1), d("div", Lt, [a[22] || (a[22] = d("span", null, "溯源查系统-", -1)), g(N(oe.value.systemName || ue.value.systemName), 1)]), d("div", Dt, N(oe.value.productionBaseName || ue.value.productionBaseName), 1)])])])]), _: 1 }), p(Ee, { label: "内容自定义", name: "contentCustom" }, { default: u(() => [d("div", jt, [C.value ? I((s(), c("div", It, [d("div", null, [p(l, { icon: "el-icon-plus", size: "default", type: "success", onClick: ca }, { default: u(() => a[24] || (a[24] = [g("新增")])), _: 1, __: [24] })]), a[25] || (a[25] = d("span", { class: "table-tip" }, "字段名称、字段值必填；指定展示项目不选则默认全部项目", -1))])), [[E, v.editPermission]]) : b("", true), I((s(), m(ze, { "cell-class-name": $(Ze), data: _.value, "max-height": $(Ve), stripe: false, "show-empty-symbol": false, border: "", "empty-text": "暂无配置", "return-source-data": "", "row-key": "uid" }, { default: u(() => [p(o, { align: "center", label: "序号", type: "index", width: "60" }), p(o, { key: "fieldName", label: "字段名称", "min-width": "160", prop: "fieldName" }, { header: u(() => [C.value ? (s(), c("span", xt, "*")) : b("", true), a[26] || (a[26] = g("字段名称"))]), default: u(({ row: t }) => [C.value ? (s(), m(n, { key: 0, modelValue: t.fieldName, "onUpdate:modelValue": (i) => t.fieldName = i, modelModifiers: { trim: true }, clearable: "", maxlength: "30", placeholder: "请输入字段名称", size: "default", onInput: (i) => K(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "onInput"])) : (s(), c("span", Pt, N(t.fieldName || "-"), 1))]), _: 1 }), p(o, { key: "fieldValue", label: "字段值", "min-width": "170", prop: "fieldValue" }, { header: u(() => [C.value ? (s(), c("span", Bt, "*")) : b("", true), a[27] || (a[27] = g("字段值"))]), default: u(({ row: t }) => [C.value ? (s(), m(n, { key: 0, modelValue: t.fieldValue, "onUpdate:modelValue": (i) => t.fieldValue = i, modelModifiers: { trim: true }, clearable: "", maxlength: "100", placeholder: "请输入字段值", size: "default", onInput: (i) => K(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "onInput"])) : (s(), c("span", $t, N(t.fieldValue || "-"), 1))]), _: 1 }), p(o, { "class-name": "traceability-project-cell", key: "displayProjectIds", label: "指定展示项目", "min-width": "260", prop: "displayProjectIds" }, { default: u(({ row: t }) => [C.value ? (s(), m(Se, { key: 0, modelValue: t.displayProjectIds, "onUpdate:modelValue": (i) => t.displayProjectIds = i, class: "traceability-project-select", clearable: "", filterable: "", multiple: "", placeholder: "请选择项目，不选则默认全部项目", size: "default", style: { width: "100%" }, onChange: (i) => K(t) }, { default: u(() => [(s(true), c(he, null, Re(A.value, (i) => (s(), m($e, { key: i.id, label: i.serialNumberName, value: i.id }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "onChange"])) : (s(), c("span", St, N(ka(t)), 1))]), _: 1 }), p(o, { align: "center", key: "enableFlag", label: "是否启用", "min-width": "110", prop: "enableFlag" }, { default: u(({ row: t }) => [C.value ? (s(), m(Va, { key: 0, modelValue: t.enableFlag, "onUpdate:modelValue": (i) => t.enableFlag = i, "active-value": 1, "inactive-value": 0, onChange: (i) => K(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])) : (s(), c("span", zt, N(t.enableFlag === 1 ? "是" : "否"), 1))]), _: 1 }), C.value ? (s(), m(o, { key: 0, align: "center", fixed: "right", label: "操作", width: "80" }, { default: u(({ row: t, $index: i }) => [p(l, { icon: "el-icon-delete", size: "default", style: { padding: "6px" }, type: "danger", onClick: Ue((ja) => pa(t, i), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })) : b("", true)]), _: 1 }, 8, ["cell-class-name", "data", "max-height"])), [[ge, G.value]])])]), _: 1 })]), _: 1 }, 8, ["modelValue"])]), _: 1 }, 8, ["modelValue"]);
  };
} }, Tt = Fa(Et, [["__scopeId", "data-v-45f412f8"]]);
export {
  Tt as default
};
