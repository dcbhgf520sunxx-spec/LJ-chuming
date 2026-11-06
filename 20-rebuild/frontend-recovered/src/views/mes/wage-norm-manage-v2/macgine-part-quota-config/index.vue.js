import { ref as L } from "vue";
import { provide as k } from "vue";
import { resolveComponent as H } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as h } from "vue";
import { createElementVNode as l } from "vue";
import { createVNode as _ } from "vue";
import { unref as e } from "vue";
import { withDirectives as ae } from "vue";
import { createBlock as r } from "vue";
import { withCtx as s } from "vue";
import { toDisplayString as d } from "vue";
import { createCommentVNode as p } from "vue";
import { Fragment as se } from "vue";
import { renderList as re } from "vue";
import { withModifiers as T } from "vue";
import { ElMessageBox as le } from "element-plus";
import { ElMessage as ce } from "element-plus";
import { ElTableColumn as ue } from "element-plus";
import { ElTag as de } from "element-plus";
import { ElTooltip as pe } from "element-plus";
import { vLoading as me } from "element-plus";
import { a as fe } from "../../../../modules/common-f216149e.js";
import { l as C, _ as he, x as _e, s7 as v, o as ge, qb as ye, i as P, e8 as be, s3 as Q, e0 as we, e1 as Le, bV as W, G as q, P as Ce } from "../../../../shared/runtime.js";
import { g as ke } from "../../../../modules/macgine-part-quota-config-e44baebd.js";
import { P as ve } from "../../../../modules/base-6bc46ddf.js";
import Pe from "./module/form.vue.js";
import xe from "./module/header.vue.js";
function Ee(m) {
  return C({ module: "mes", url: "quota-config/machine-part/page", method: "get", params: m });
}
function Oe(m) {
  return C({ module: "mes", url: "quota-config/machine-part", method: "post", data: m });
}
function Te(m) {
  return C({ module: "mes", url: "quota-config/machine-part", method: "put", data: m });
}
function Y(m) {
  return C({ module: "mes", url: "quota-config/machine-part", method: "delete", params: m });
}
function qe(m) {
  return C({ url: "/api/config/structure-steel/classification", method: "get", params: m });
}
const Be = { get: Ee, add: Oe, edit: Te, del: Y };
const Ie = { class: "app-container" }, Ve = { class: "head-container" }, ze = { style: { padding: "0 10px", cursor: "pointer" } }, Me = { key: 1 }, Ne = { style: { padding: "0 10px", cursor: "pointer" } }, Se = { key: 1 }, De = { key: 0 }, Ue = { key: 1 }, Ae = { key: 0, class: "detailList" }, Re = { key: 1 }, $e = { __name: "index", setup(m) {
  const G = { add: true, edit: false, del: false, download: false }, B = L(), { crud: c, columns: f, CRUD: K } = _e({ title: "零件定额", permission: { ...v }, optShow: { ...G }, crudApi: { ...Be }, hasPagination: true }, B), I = L([]), V = L([]), z = L([]), { maxHeight: X } = ge({ paginate: true }), x = Object.values(ye.V).map((n) => ({ conditionEnum: n.V, name: n.L })), b = L(false);
  async function J() {
    try {
      const n = await ve();
      b.value = n || false;
    } catch (n) {
      console.log("工价统计截止日", n);
    }
  }
  K.HOOK.handleRefresh = (n, u) => {
    u.data.content = u.data.content.map((a) => (a.conditionList = x.map((w) => {
      var g;
      return ((g = a.conditionList) == null ? void 0 : g.find((O) => O.conditionEnum === w.conditionEnum)) || { conditionEnum: w.conditionEnum, numberOne: void 0, comparisonOperatorOne: void 0, comparisonOperatorTwo: void 0, numberTwo: void 0 };
    }), a)), J();
  };
  async function Z(n) {
    try {
      await le.confirm(`确认将 ${n.serialNumber} 删除？`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await Y({ id: n.id }), ce.success("删除成功！"), c.refresh();
    } catch (u) {
      console.log(u);
    }
  }
  async function ee() {
    try {
      const { content: n } = await fe();
      I.value = n || [];
    } catch (n) {
      console.log(n);
    }
  }
  async function te(n) {
    try {
      const { content: u } = await qe({ mesProductEnum: 1 });
      z.value = u || [];
    } catch (u) {
      console.log(u);
    }
  }
  te();
  async function ne() {
    try {
      const { content: n } = await ke();
      V.value = n || [], console.log(n);
    } catch (n) {
      console.log(n);
    }
  }
  ne();
  function oe(n) {
    const copy = JSON.parse(JSON.stringify({
      branchCompanyIdList: n.branchCompanyIdList || [],
      workshopIdList: n.workshopIdList || [],
      productClassificationEnum: n.productClassificationEnum,
      machinePartClassIdList: n.machinePartClassIdList || [],
      processId: n.process?.id,
      measureUnit: n.measureUnit,
      quotaType: n.quotaType,
      organizationInsidePrice: n.organizationInsidePrice,
      organizationOutsidePrice: n.organizationOutsidePrice,
      conditionList: (n.conditionList || []).map(({ conditionEnum, numberOne, comparisonOperatorOne, comparisonOperatorTwo, numberTwo }) => ({ conditionEnum, numberOne, comparisonOperatorOne, comparisonOperatorTwo, numberTwo }))
    }));
    c.resetForm(copy), c.toAdd();
  }
  return ee(), k("branchList", I), k("processOptions", V), k("classificationOptions", z), k("boolConfig", b), (n, u) => {
    const a = ue, w = de, E = pe, g = H("common-button"), O = H("common-table"), ie = me;
    return o(), h("div", Ie, [l("div", Ve, [_(e(xe))]), ae((o(), r(O, { ref_key: "tableRef", ref: B, data: e(c).data, "empty-text": e(c).emptyText, "max-height": e(X), showEmptySymbol: false, style: { width: "100%" } }, { default: s(() => [_(a, { type: "index", label: "序号", align: "center", width: "55", fixed: "left" }), e(f).visible("branchCompanyList") ? (o(), r(a, { key: "branchCompanyList", prop: "branchCompanyList", "show-overflow-tooltip": true, label: "适用机构", align: "center", fixed: "left" }, { default: s((t) => [e(P)(t.row.branchCompanyList) ? (o(), r(E, { key: 0, content: t.row.branchCompanyList.map((i) => i.name).join(`
`), placement: "top", trigger: "click" }, { default: s(() => [_(w, { round: "" }, { default: s(() => {
      var i;
      return [l("span", ze, d((i = t.row.branchCompanyList) == null ? void 0 : i.length), 1)];
    }), _: 2 }, 1024)]), _: 2 }, 1032, ["content"])) : (o(), h("span", Me, "-"))]), _: 1 })) : p("", true), e(f).visible("workshopList") ? (o(), r(a, { key: "workshopList", prop: "workshopList", "show-overflow-tooltip": true, label: "适用车间", align: "center", fixed: "left" }, { default: s((t) => [e(P)(t.row.workshopList) ? (o(), r(E, { key: 0, content: t.row.workshopList.map((i) => i.name).join(`
`), placement: "top", trigger: "click" }, { default: s(() => [_(w, { round: "" }, { default: s(() => {
      var i;
      return [l("span", Ne, d((i = t.row.workshopList) == null ? void 0 : i.length), 1)];
    }), _: 2 }, 1024)]), _: 2 }, 1032, ["content"])) : (o(), h("span", Se, "-"))]), _: 1 })) : p("", true), e(f).visible("productClassificationEnum") ? (o(), r(a, { key: "productClassificationEnum", prop: "productClassificationEnum", "show-overflow-tooltip": true, label: "零件分类", align: "center", fixed: "left" }, { default: s((t) => [l("span", null, d(e(be).VL[t.row.productClassificationEnum] || "-"), 1)]), _: 1 })) : p("", true), e(f).visible("machinePartClassList") ? (o(), r(a, { key: "machinePartClassList", prop: "machinePartClassList", "show-overflow-tooltip": true, label: "零件种类", align: "center", fixed: "left" }, { default: s((t) => [e(P)(t.row.machinePartClassList) ? (o(), h("span", De, d(t.row.machinePartClassList.map((i) => i.name).join("、")), 1)) : (o(), h("span", Ue, "-"))]), _: 1 })) : p("", true), e(f).visible("process") ? (o(), r(a, { key: "process", prop: "process", label: "工序", align: "center", fixed: "left" }, { default: s((t) => {
      var i;
      return [l("span", null, d(((i = t.row.process) == null ? void 0 : i.name) || "-"), 1)];
    }), _: 1 })) : p("", true), e(f).visible("quotaType") ? (o(), r(a, { key: "quotaType", prop: "quotaType", label: "定额类型", align: "center", fixed: "left" }, { default: s((t) => [l("span", null, d(e(Q).VL[t.row.quotaType] || "-"), 1)]), _: 1 })) : p("", true), (o(true), h(se, null, re(e(x), (t, i) => (o(), r(a, { key: i, prop: t.name, label: t.name, align: "center", "min-width": "150" }, { default: s((y) => {
      var M, N, S, D, U, A, R, $, j, F;
      return [y.row.quotaType === e(Q).VARIABLE.V && e(P)((N = (M = y.row.conditionList) == null ? void 0 : M[i]) == null ? void 0 : N.numberOne) ? (o(), h("div", Ae, [l("span", null, d((D = (S = y.row.conditionList) == null ? void 0 : S[i]) == null ? void 0 : D.numberOne), 1), l("span", null, d(e(we).VL[(A = (U = y.row.conditionList) == null ? void 0 : U[i]) == null ? void 0 : A.comparisonOperatorOne]), 1), u[0] || (u[0] = l("span", null, "X", -1)), l("span", null, d(e(Le).VL[($ = (R = y.row.conditionList) == null ? void 0 : R[i]) == null ? void 0 : $.comparisonOperatorTwo]), 1), l("span", null, d((F = (j = y.row.conditionList) == null ? void 0 : j[i]) == null ? void 0 : F.numberTwo), 1)])) : (o(), h("span", Re, "-"))];
    }), _: 2 }, 1032, ["prop", "label"]))), 128)), e(f).visible("measureUnit") ? (o(), r(a, { key: "measureUnit", prop: "measureUnit", label: "计量单位", align: "center", fixed: "right" }, { default: s((t) => [l("span", null, d(t.row.measureUnit || "-"), 1)]), _: 1 })) : p("", true), e(f).visible("serialNumber") ? (o(), r(a, { key: "serialNumber", prop: "serialNumber", label: "定额编号", align: "center", fixed: "right" }, { default: s((t) => [l("span", null, d(t.row.serialNumber || "-"), 1)]), _: 1 })) : p("", true), _(a, { label: "定额单价", align: "center", fixed: "right" }, { default: s(() => [e(f).visible("organizationInsidePrice") ? (o(), r(a, { key: "organizationInsidePrice", prop: "organizationInsidePrice", label: "编制内（元）", align: "center", "min-width": "100" }, { default: s((t) => [l("span", null, d(e(W)(t.row.organizationInsidePrice) ?? "-"), 1)]), _: 1 })) : p("", true), e(f).visible("organizationOutsidePrice") ? (o(), r(a, { key: "organizationOutsidePrice", prop: "organizationOutsidePrice", label: "编制外（元）", align: "center", "min-width": "100" }, { default: s((t) => [l("span", null, d(e(W)(t.row.organizationOutsidePrice) ?? "-"), 1)]), _: 1 })) : p("", true)]), _: 1 }), _(a, { label: "操作", prop: "operation", align: "center", fixed: "right", "min-width": "180" }, { default: s((t) => [e(q)(e(v).add) ? (o(), r(g, { key: 0, icon: "el-icon-DocumentCopy", size: "default", type: "success", disabled: !b.value, onClick: T((i) => oe(t.row), ["stop"]) }, null, 8, ["disabled", "onClick"])) : p("", true), e(q)(e(v).edit) ? (o(), r(g, { key: 1, icon: "el-icon-edit", size: "default", type: "primary", disabled: !b.value, onClick: T((i) => e(c).toEdit(t.row), ["stop"]) }, null, 8, ["disabled", "onClick"])) : p("", true), e(q)(e(v).del) ? (o(), r(g, { key: 2, icon: "el-icon-delete", size: "default", type: "danger", disabled: !b.value, onClick: T((i) => Z(t.row), ["stop"]) }, null, 8, ["disabled", "onClick"])) : p("", true)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[ie, e(c).loading]]), _(e(Pe)), _(e(Ce))]);
  };
} }, Xe = he($e, [["__scopeId", "data-v-f4086514"]]);
export {
  Xe as default
};
