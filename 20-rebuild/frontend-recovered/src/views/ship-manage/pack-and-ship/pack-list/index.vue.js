import { reactive as ie } from "vue";
import { ref as m } from "vue";
import { provide as B } from "vue";
import { resolveComponent as G } from "vue";
import { resolveDirective as le } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as b } from "vue";
import { createElementVNode as h } from "vue";
import { createVNode as d } from "vue";
import { unref as e } from "vue";
import { withDirectives as w } from "vue";
import { createBlock as i } from "vue";
import { withCtx as n } from "vue";
import { toDisplayString as y } from "vue";
import { createCommentVNode as l } from "vue";
import { Fragment as _ } from "vue";
import { renderList as M } from "vue";
import { createTextVNode as g } from "vue";
import { withModifiers as ne } from "vue";
import { ElTableColumn as se } from "element-plus";
import { ElTag as ce } from "element-plus";
import { vLoading as pe } from "element-plus";
import { g as ue } from "../../../../modules/pack-list-1d80c5dd.js";
import { _ as de, x as me, m as ye, o as fe, bi as E, z as he, br as be, K as W, bw as ve, p as we, bs as _e, D as ge, bK as R, G as I, P as ke } from "../../../../shared/runtime.js";
import { d as f } from "../../../../modules/ship-manage-3066b2ed.js";
import Te from "./module/header.vue.js";
import xe from "./module/detail.vue.js";
import Ne from "./module/combined-label-dlg.vue.js";
import Ce from "./module/printed-record-drawer.vue.js";
import "../../../../modules/print-record-2e0b6340.js";
import "../../../../modules/index-069ba252.js";
import "../../../../modules/index-90569c81.js";
import "../../../../modules/constant_2-1ad5d80f.js";
import "../../../../modules/label-logo-8a01bd73.js";
import "../../../../modules/index-f09320a8.js";
import "../../../../modules/index-3b2e6e51.js";
import "../../../../modules/use-label-print-e19db37a.js";
import "./module/ship-label-preview.vue.js";
import "../../../../modules/manual-pack-aab80853.js";
import "../../../../modules/one-code-number-list-af2f89eb.js";
import "../../../../modules/manuf-warehouse-select-bae65ecc.js";
import "../../../../modules/PicUpload-8580ccfc.js";
const je = { class: "app-container" }, De = { class: "head-container" }, Ve = { class: "project-name" }, Ee = { __name: "index", setup(Re) {
  const K = { add: false, edit: false, del: false, download: false }, k = ie({}), T = m(), S = m(), { crud: s, columns: c, CRUD: L } = me({ title: "打包记录", permission: { ...f }, crudApi: { get: ue }, optShow: { ...K }, invisibleColumns: [] }, S);
  B("permission", f);
  const { currentProjectType: q } = ye(["currentProjectType"]), { maxHeight: $ } = fe({ paginate: true }), x = m(false), N = m(false), C = m(false), P = m(), j = m({}), U = m({}), z = m(), H = m(true), O = m(true), F = m(true);
  L.HOOK.beforeToQuery = () => {
    s.query.projectType = q.value;
  }, L.HOOK.handleRefresh = (r, p) => {
    p.data.content = p.data.content.map((o) => (o.packerName = o.userName, o.materialTypeNames = E.VL[o.productType], o));
  };
  const Q = (r) => {
    z.value = r;
  }, A = (r) => {
    H.value = r;
  }, J = (r) => {
    O.value = r;
  }, X = (r) => {
    F.value = r;
  };
  function Y(r) {
    U.value = r, C.value = true;
  }
  function Z(r, p) {
    k[r] || (k[r] = p);
  }
  B("detailStore", k);
  async function ee(r) {
    try {
      await T.value.print([r]);
    } catch (p) {
      console.log("打印标签失败", p);
    }
  }
  async function te(r) {
    j.value = await T.value.getLabelInfo(r), console.log(j.value, "currentLabel.value"), N.value = true;
  }
  function oe(r) {
    P.value = r.id, x.value = true;
  }
  return (r, p) => {
    const o = se, D = ce, v = G("common-button"), ae = G("common-table"), V = le("permission"), re = pe;
    return a(), b("div", je, [h("div", De, [d(e(Te), { ref_key: "headerRef", ref: T, currentProjectType: e(q), onChangeUnit: Q, onCheckboxMaterial: A, onCheckboxName: X, onCheckboxWidth: J, onGetDetail: Z }, null, 8, ["currentProjectType"])]), w((a(), i(ae, { ref_key: "tableRef", ref: S, data: e(s).data, "empty-text": e(s).emptyText, "max-height": e($), style: { width: "100%" }, onSelectionChange: e(s).selectionChangeHandler }, { default: n(() => [d(o, { align: "center", type: "selection", width: "55" }), d(o, { align: "center", label: "序号", type: "index", width: "60" }), !e(s).query.projectId && e(c).visible("project") ? (a(), i(o, { key: "project", "show-overflow-tooltip": true, label: "项目", "min-width": "250", prop: "project" }, { default: n((t) => [h("span", Ve, y(e(he)(t.row.project)), 1)]), _: 1 })) : l("", true), e(c).visible("monomerName") ? (a(), i(o, { key: "monomerName", "show-overflow-tooltip": true, label: "单体", "min-width": "150", prop: "monomerName" }, { default: n((t) => [h("span", null, y(t.row.monomerName || "-"), 1)]), _: 1 })) : l("", true), e(c).visible("areaBatchName") ? (a(), i(o, { key: "areaBatchName", "show-overflow-tooltip": true, label: "批次", "min-width": "150", prop: "areaBatchName" }, { default: n((t) => [h("span", null, y(t.row.areaBatchName || "-"), 1)]), _: 1 })) : l("", true), e(c).visible("serialNumber") ? (a(), i(o, { key: "serialNumber", "show-overflow-tooltip": true, align: "center", label: "包单号", "min-width": "130px", prop: "serialNumber" }, { default: n((t) => [d(e(be), { offset: 15, show: t.row.printType, color: "#e64242", name: "已打印" }, null, 8, ["show"]), h("span", null, y(t.row.serialNumber), 1)]), _: 1 })) : l("", true), e(c).visible("warehouse.name") ? (a(), i(o, { key: "warehouse.name", "show-overflow-tooltip": true, label: "存放位置", "min-width": "140", align: "center", prop: "warehouse.name" })) : l("", true), e(c).visible("productType") && e(s).query.projectType === e(W).STEEL.V ? (a(), i(o, { key: "productType", align: "center", label: "产品类型", "min-width": "140px", prop: "productType" }, { default: n((t) => [(a(true), b(_, null, M(e(E).ENUM, (u) => (a(), b(_, { key: u }, [t.row.productType & u.V ? (a(), i(D, { key: 0, type: u.T, effect: "light", style: { "margin-right": "5px" } }, { default: n(() => [g(y(u.L), 1)]), _: 2 }, 1032, ["type"])) : l("", true)], 64))), 128))]), _: 1 })) : l("", true), e(c).visible("productType") && e(s).query.projectType === e(W).BRIDGE.V ? (a(), i(o, { key: "productType", align: "center", label: "产品类型", "min-width": "140px", prop: "productType" }, { default: n((t) => [(a(true), b(_, null, M(e(ve).ENUM, (u) => (a(), b(_, { key: u }, [t.row.productType & u.V ? (a(), i(D, { key: 0, type: u.T, effect: "light", style: { "margin-right": "5px" } }, { default: n(() => [g(y(u.L), 1)]), _: 2 }, 1032, ["type"])) : l("", true)], 64))), 128))]), _: 1 })) : l("", true), e(c).visible("packerName") ? (a(), i(o, { key: "packerName", "show-overflow-tooltip": true, align: "center", label: "包单创建人", "min-width": "120", prop: "packerName" })) : l("", true), e(c).visible("createTime") ? (a(), i(o, { key: "createTime", label: "日期", prop: "createTime", align: "center", width: "160px" }, { default: n((t) => [h("span", null, y(e(we)(t.row.createTime)), 1)]), _: 1 })) : l("", true), e(c).visible("quantity") ? (a(), i(o, { key: "quantity", "show-overflow-tooltip": true, align: "center", label: "数量", "min-width": "60", prop: "quantity" })) : l("", true), e(c).visible("totalGrossWeight") && e(s).query.productType === e(E).STRUCTURE.V ? (a(), i(o, { key: "totalGrossWeight", "show-overflow-tooltip": true, align: "right", label: "结构毛重(kg)", "min-width": "120", prop: "totalGrossWeight" }, { default: n((t) => [g(y(e(_e)(t.row.totalGrossWeight, e(ge).COM_WT__KG)), 1)]), _: 1 })) : l("", true), e(c).visible("status") ? (a(), i(o, { key: "status", align: "center", label: "状态", "min-width": "100", prop: "status" }, { default: n((t) => [d(D, { type: e(R)[e(R).VK[t.row.status]].T, effect: "plain" }, { default: n(() => [g(y(e(R).VL[t.row.status]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : l("", true), e(c).visible("remark") ? (a(), i(o, { key: "remark", "show-overflow-tooltip": true, label: "备注", "min-width": "140", prop: "remark" })) : l("", true), e(I)([...e(f).print, ...e(f).printRecords]) ? (a(), i(o, { key: 13, align: "center", fixed: "right", label: "标签", width: "170px" }, { default: n((t) => [w(d(v, { icon: "el-icon-printer", size: "default", type: "success", onClick: (u) => ee(t.row) }, null, 8, ["onClick"]), [[V, e(f).print]]), w(d(v, { icon: "el-icon-document", size: "default", type: "primary", onClick: (u) => te(t.row) }, null, 8, ["onClick"]), [[V, e(f).print]]), w(d(v, { icon: "el-icon-clock", size: "default", type: "info", onClick: (u) => oe(t.row) }, null, 8, ["onClick"]), [[V, e(f).printRecords]])]), _: 1 })) : l("", true), e(I)([...e(f).detail]) ? (a(), i(o, { key: 14, align: "center", fixed: "right", label: "操作", width: "80px" }, { default: n((t) => [d(v, { icon: "el-icon-view", size: "default", type: "primary", onClick: ne((u) => Y(t.row), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })) : l("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSelectionChange"])), [[re, e(s).loading]]), d(e(ke)), d(e(Ne), { visible: N.value, "onUpdate:visible": p[0] || (p[0] = (t) => N.value = t), "label-data": j.value }, null, 8, ["visible", "label-data"]), d(e(xe), { visible: C.value, "onUpdate:visible": p[1] || (p[1] = (t) => C.value = t), "detail-info": U.value, projectType: e(s).query.projectType, onDelSuccess: e(s).toQuery, onEditSuccess: e(s).toQuery }, null, 8, ["visible", "detail-info", "projectType", "onDelSuccess", "onEditSuccess"]), d(e(Ce), { visible: x.value, "onUpdate:visible": p[2] || (p[2] = (t) => x.value = t), "package-id": P.value, productType: e(s).query.productType, projectType: e(s).query.projectType }, null, 8, ["visible", "package-id", "productType", "projectType"])]);
  };
} }, Ze = de(Ee, [["__scopeId", "data-v-5cc85b8d"]]);
export {
  Ze as default
};
