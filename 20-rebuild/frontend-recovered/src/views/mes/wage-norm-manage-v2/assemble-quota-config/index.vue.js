import { ref as C } from "vue";
import { provide as P } from "vue";
import { resolveComponent as F } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as b } from "vue";
import { createElementVNode as c } from "vue";
import { createVNode as _ } from "vue";
import { unref as e } from "vue";
import { withDirectives as ne } from "vue";
import { createBlock as r } from "vue";
import { withCtx as s } from "vue";
import { toDisplayString as d } from "vue";
import { createCommentVNode as u } from "vue";
import { Fragment as ae } from "vue";
import { renderList as ie } from "vue";
import { withModifiers as T } from "vue";
import { ElMessageBox as se } from "element-plus";
import { ElMessage as re } from "element-plus";
import { ElTableColumn as le } from "element-plus";
import { ElTag as ce } from "element-plus";
import { ElTooltip as de } from "element-plus";
import { vLoading as ue } from "element-plus";
import { a as me } from "../../../../modules/common-f216149e.js";
import { l as L, _ as pe, x as fe, s4 as k, o as be, qa as _e, i as v, s3 as H, e0 as ge, e1 as he, bV as Q, G as I, P as ye } from "../../../../shared/runtime.js";
import { P as we } from "../../../../modules/base-6bc46ddf.js";
import Le from "./module/form.vue.js";
import Ce from "./module/header.vue.js";
import "../../../../modules/process-select-b35dffc0.js";
import "../../../../modules/raf-ac2cc4f2.js";
import "../../../../modules/use-process-af1f8c99.js";
function ke(m) {
  return L({ module: "mes", url: "quota-config/assemble/page", method: "get", params: m });
}
function ve(m) {
  return L({ module: "mes", url: "quota-config/assemble", method: "post", data: m });
}
function xe(m) {
  return L({ module: "mes", url: "quota-config/assemble", method: "put", data: m });
}
function W(m) {
  return L({ module: "mes", url: "quota-config/assemble", method: "delete", params: m });
}
function Ee(m) {
  return L({ module: "mes", url: "productProcess/assemble-type-process-select", method: "get", params: m });
}
const Oe = { get: ke, add: ve, edit: xe, del: W };
const Pe = { class: "app-container" }, Te = { class: "head-container" }, Ie = { style: { padding: "0 10px", cursor: "pointer" } }, qe = { key: 1 }, Be = { style: { padding: "0 10px", cursor: "pointer" } }, ze = { key: 1 }, Ve = { key: 0 }, Ne = { key: 1 }, Se = { key: 0, class: "detailList" }, Ae = { key: 1 }, De = { __name: "index", setup(m) {
  const Y = { add: true, edit: false, del: false, download: false }, q = C(), { crud: l, columns: f, CRUD: G } = fe({ title: "部件定额", permission: { ...k }, optShow: { ...Y }, crudApi: { ...Oe }, hasPagination: true }, q), B = C([]), z = C([]), { maxHeight: K } = be({ paginate: true }), x = Object.values(_e.V).map((o) => ({ conditionEnum: o.V, name: o.L })), y = C(false);
  async function X() {
    try {
      const o = await we();
      y.value = o || false;
    } catch (o) {
      console.log("工价统计截止日", o);
    }
  }
  G.HOOK.handleRefresh = (o, p) => {
    p.data.content = p.data.content.map((i) => (i.conditionList = x.map((w) => {
      var g;
      return ((g = i.conditionList) == null ? void 0 : g.find((O) => O.conditionEnum === w.conditionEnum)) || { conditionEnum: w.conditionEnum, numberOne: void 0, comparisonOperatorOne: void 0, comparisonOperatorTwo: void 0, numberTwo: void 0 };
    }), i)), X();
  };
  async function J(o) {
    try {
      await se.confirm(`确认将 ${o.serialNumber} 删除？`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await W({ id: o.id }), re.success("删除成功！"), l.refresh();
    } catch (p) {
      console.log(p);
    }
  }
  async function Z() {
    try {
      const { content: o } = await me();
      B.value = o || [];
    } catch (o) {
      console.log(o);
    }
  }
  const ee = async () => {
    try {
      const { content: o } = await Ee({ mesProductEnum: 1 });
      z.value = o || [];
    } catch (o) {
      console.log(o);
    }
  };
  function te(o) {
    const copy = JSON.parse(JSON.stringify({
      branchCompanyIdList: o.branchCompanyIdList || [],
      workshopIdList: o.workshopIdList || [],
      assembleClassIdList: o.assembleClassIdList || [],
      processId: o.process?.id,
      measureUnit: o.measureUnit,
      quotaType: o.quotaType,
      organizationInsidePrice: o.organizationInsidePrice,
      organizationOutsidePrice: o.organizationOutsidePrice,
      conditionList: (o.conditionList || []).map(({ conditionEnum, numberOne, comparisonOperatorOne, comparisonOperatorTwo, numberTwo }) => ({ conditionEnum, numberOne, comparisonOperatorOne, comparisonOperatorTwo, numberTwo }))
    }));
    l.resetForm(copy), l.toAdd();
  }
  return ee(), Z(), P("branchList", B), P("assembleClassIdList", z), P("boolConfig", y), (o, p) => {
    const i = le, w = ce, E = de, g = F("common-button"), O = F("common-table"), oe = ue;
    return a(), b("div", Pe, [c("div", Te, [_(e(Ce))]), ne((a(), r(O, { ref_key: "tableRef", ref: q, data: e(l).data, "empty-text": e(l).emptyText, "max-height": e(K), showEmptySymbol: false, style: { width: "100%" } }, { default: s(() => [_(i, { type: "index", label: "序号", align: "center", width: "55", fixed: "left" }), e(f).visible("branchCompanyList") ? (a(), r(i, { key: "branchCompanyList", prop: "branchCompanyList", "show-overflow-tooltip": true, label: "适用机构", align: "center", fixed: "left" }, { default: s((t) => [e(v)(t.row.branchCompanyList) ? (a(), r(E, { key: 0, content: t.row.branchCompanyList.map((n) => n.name).join(`
`), placement: "top", trigger: "click" }, { default: s(() => [_(w, { round: "" }, { default: s(() => {
      var n;
      return [c("span", Ie, d((n = t.row.branchCompanyList) == null ? void 0 : n.length), 1)];
    }), _: 2 }, 1024)]), _: 2 }, 1032, ["content"])) : (a(), b("span", qe, "-"))]), _: 1 })) : u("", true), e(f).visible("workshopList") ? (a(), r(i, { key: "workshopList", prop: "workshopList", "show-overflow-tooltip": true, label: "适用车间", align: "center", fixed: "left" }, { default: s((t) => [e(v)(t.row.workshopList) ? (a(), r(E, { key: 0, content: t.row.workshopList.map((n) => n.name).join(`
`), placement: "top", trigger: "click" }, { default: s(() => [_(w, { round: "" }, { default: s(() => {
      var n;
      return [c("span", Be, d((n = t.row.workshopList) == null ? void 0 : n.length), 1)];
    }), _: 2 }, 1024)]), _: 2 }, 1032, ["content"])) : (a(), b("span", ze, "-"))]), _: 1 })) : u("", true), e(f).visible("assembleClassList") ? (a(), r(i, { key: "assembleClassList", prop: "assembleClassList", "show-overflow-tooltip": true, label: "部件类型", align: "center", fixed: "left", "min-width": "100" }, { default: s((t) => [e(v)(t.row.assembleClassList) ? (a(), b("span", Ve, d(t.row.assembleClassList.map((n) => n.name).join("、")), 1)) : (a(), b("span", Ne, "-"))]), _: 1 })) : u("", true), e(f).visible("process") ? (a(), r(i, { key: "process", prop: "process", label: "工序", align: "center", fixed: "left" }, { default: s((t) => {
      var n;
      return [c("span", null, d(((n = t.row.process) == null ? void 0 : n.name) || "-"), 1)];
    }), _: 1 })) : u("", true), e(f).visible("quotaType") ? (a(), r(i, { key: "quotaType", prop: "quotaType", label: "定额类型", align: "center", fixed: "left" }, { default: s((t) => [c("span", null, d(e(H).VL[t.row.quotaType] || "-"), 1)]), _: 1 })) : u("", true), (a(true), b(ae, null, ie(e(x), (t, n) => (a(), r(i, { key: n, prop: t.name, label: t.name, align: "center", "min-width": "150" }, { default: s((h) => {
      var V, N, S, A, D, M, U, R, $, j;
      return [h.row.quotaType === e(H).VARIABLE.V && e(v)((N = (V = h.row.conditionList) == null ? void 0 : V[n]) == null ? void 0 : N.numberOne) ? (a(), b("div", Se, [c("span", null, d((A = (S = h.row.conditionList) == null ? void 0 : S[n]) == null ? void 0 : A.numberOne), 1), c("span", null, d(e(ge).VL[(M = (D = h.row.conditionList) == null ? void 0 : D[n]) == null ? void 0 : M.comparisonOperatorOne]), 1), p[0] || (p[0] = c("span", null, "X", -1)), c("span", null, d(e(he).VL[(R = (U = h.row.conditionList) == null ? void 0 : U[n]) == null ? void 0 : R.comparisonOperatorTwo]), 1), c("span", null, d((j = ($ = h.row.conditionList) == null ? void 0 : $[n]) == null ? void 0 : j.numberTwo), 1)])) : (a(), b("span", Ae, "-"))];
    }), _: 2 }, 1032, ["prop", "label"]))), 128)), e(f).visible("measureUnit") ? (a(), r(i, { key: "measureUnit", prop: "measureUnit", label: "计量单位", align: "center", fixed: "right" }, { default: s((t) => [c("span", null, d(t.row.measureUnit || "-"), 1)]), _: 1 })) : u("", true), e(f).visible("serialNumber") ? (a(), r(i, { key: "serialNumber", prop: "serialNumber", label: "定额编号", align: "center", fixed: "right", "min-width": "100" }, { default: s((t) => [c("span", null, d(t.row.serialNumber || "-"), 1)]), _: 1 })) : u("", true), _(i, { label: "定额单价", align: "center", fixed: "right" }, { default: s(() => [e(f).visible("organizationInsidePrice") ? (a(), r(i, { key: "organizationInsidePrice", prop: "organizationInsidePrice", label: "编制内（元）", align: "center", "min-width": "100" }, { default: s((t) => [c("span", null, d(e(Q)(t.row.organizationInsidePrice) ?? "-"), 1)]), _: 1 })) : u("", true), e(f).visible("organizationOutsidePrice") ? (a(), r(i, { key: "organizationOutsidePrice", prop: "organizationOutsidePrice", label: "编制外（元）", align: "center", "min-width": "100" }, { default: s((t) => [c("span", null, d(e(Q)(t.row.organizationOutsidePrice) ?? "-"), 1)]), _: 1 })) : u("", true)]), _: 1 }), _(i, { label: "操作", prop: "operation", align: "center", fixed: "right", "min-width": "180" }, { default: s((t) => [e(I)(e(k).add) ? (a(), r(g, { key: 0, icon: "el-icon-DocumentCopy", size: "default", type: "success", disabled: !y.value, onClick: T((n) => te(t.row), ["stop"]) }, null, 8, ["disabled", "onClick"])) : u("", true), e(I)(e(k).edit) ? (a(), r(g, { key: 1, icon: "el-icon-edit", size: "default", type: "primary", disabled: !y.value, onClick: T((n) => e(l).toEdit(t.row), ["stop"]) }, null, 8, ["disabled", "onClick"])) : u("", true), e(I)(e(k).del) ? (a(), r(g, { key: 2, icon: "el-icon-delete", size: "default", type: "danger", disabled: !y.value, onClick: T((n) => J(t.row), ["stop"]) }, null, 8, ["disabled", "onClick"])) : u("", true)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[oe, e(l).loading]]), _(e(Le)), _(e(ye))]);
  };
} }, Ge = pe(De, [["__scopeId", "data-v-bc92bb80"]]);
export {
  Ge as default
};
