import { useRouter as ae } from "vue-router";
import { reactive as ie } from "vue";
import { ref as g } from "vue";
import { provide as re } from "vue";
import { resolveComponent as q } from "vue";
import { resolveDirective as oe } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as L } from "vue";
import { createElementVNode as x } from "vue";
import { createVNode as l } from "vue";
import { unref as t } from "vue";
import { withDirectives as w } from "vue";
import { createBlock as u } from "vue";
import { withCtx as c } from "vue";
import { toDisplayString as h } from "vue";
import { createCommentVNode as p } from "vue";
import { Fragment as U } from "vue";
import { renderList as ne } from "vue";
import { createTextVNode as C } from "vue";
import { withModifiers as le } from "vue";
import { ElNotification as se } from "element-plus";
import { ElTableColumn as ce } from "element-plus";
import { ElTag as ue } from "element-plus";
import { ElPopconfirm as pe } from "element-plus";
import { vLoading as me } from "element-plus";
import { c as F, _ as de, d as M } from "./module/header.vue.js";
import { _ as fe, x as be, oh as d, o as ge, bi as W, z as ye, br as he, p as _e, bs as we, D as ke, bK as N, G as E, P as Le, O as xe, c as j, V as T } from "../../../../shared/runtime.js";
import Ce from "../components/common-detail/index.vue.js";
import Ne from "./module/label-dlg.vue.js";
import Te from "./module/printed-record-drawer.vue.js";
import "../../../../modules/print-record-2e0b6340.js";
import "../../../../modules/index-069ba252.js";
import "../../../../modules/index-90569c81.js";
import "../../../../modules/constant_2-1ad5d80f.js";
import "../../../../modules/label-logo-8a01bd73.js";
import "../../../../modules/index-f09320a8.js";
import "../../../../modules/index-3b2e6e51.js";
import "../../../../modules/use-label-print-e19db37a.js";
import "../components/common-detail/module/structure.vue.js";
import "../components/common-detail/module/part.vue.js";
import "../components/common-detail/module/auxiliary-material.vue.js";
const Pe = { class: "app-container" }, Re = { class: "head-container" }, Ve = { class: "project-name" }, De = { __name: "index", setup(Qe) {
  const K = ae(), I = { add: false, edit: false, del: false, download: false }, P = ie({}), R = g(), v = g(), { crud: y, columns: b, CRUD: O } = be({ title: "打包记录", permission: { ...d }, crudApi: { ...F }, optShow: { ...I }, invisibleColumns: [] }, v), { maxHeight: B } = ge({ paginate: true }), V = g(false), D = g(false), Q = g(false), z = g(), $ = g({}), S = g({});
  O.HOOK.handleRefresh = (r, o) => {
    o.data.content = o.data.content.map((i) => (i.packerName = i.userName, i.materialTypeNames = W.VL[i.productType], i));
  };
  function H(r) {
    console.log(r, "row"), S.value = r, Q.value = true;
  }
  function G(r, o) {
    P[r] || (P[r] = o);
  }
  re("detailStore", P);
  async function A(r) {
    try {
      await R.value.print([r]);
    } catch (o) {
      console.log("打印标签失败", o);
    }
  }
  async function J(r) {
    $.value = await R.value.getLabelInfo(r), console.log($.value, "value"), D.value = true;
  }
  function X(r) {
    z.value = r.id, V.value = true;
  }
  function Y({ artifactList: r, partList: o, enclosureList: i, auxiliaryMaterialList: _ }) {
    const m = {};
    return m.artifactList = r && r.map((e) => (e.weight = e.netWeight || e.grossWeight, e.totalWeight = j(e.weight * e.packageQuantity, "kg", "t"), e.productQuantity = e.packageQuantity, e.originNumberList = e.numberList ? T(e.numberList) : [], e.numberList = e.numberList ? e.numberList.filter((s) => s.boolPackage).map((s) => s.number) : [], e)), m.partList = o && o.map((e) => (e.weight = e.netWeight || e.grossWeight, e.totalWeight = j(e.weight * e.packageQuantity, "kg", "t"), e.productQuantity = e.packageQuantity, e.originNumberList = e.numberList ? T(e.numberList) : [], e.numberList = e.numberList ? e.numberList.filter((s) => s.boolPackage).map((s) => s.number) : [], e)), m.enclosureList = i && i.map((e) => (e.processingPrice = e.processingPrice || e.processingPrice === 0 ? e.processingPrice : void 0, e.totalLength = j(e.length * e.packageQuantity, "mm", "m"), e.productQuantity = e.packageQuantity, e.originNumberList = e.numberList ? T(e.numberList) : [], e.numberList = e.numberList ? e.numberList.filter((s) => s.boolPackage).map((s) => s.number) : [], e)), m.auxiliaryMaterialList = _ && _.map((e) => (e.fullClassName = `${e.firstName}/${e.secondName}/${e.thirdName}`, e.productQuantity = e.packageQuantity, e.originNumberList = e.numberList ? T(e.numberList) : [], e.numberList = e.numberList ? e.numberList.filter((s) => s.boolPackage).map((s) => s.number) : [], e)), JSON.stringify(m);
  }
  async function Z(r, o) {
    try {
      const i = await M(r) || {};
      K.push({ name: "MesManualPack", params: { id: r, projectId: o, remark: i.remark, data: Y(i) } });
    } catch (i) {
      console.log("去编辑包", i);
    }
  }
  const ee = xe(async function(r) {
    try {
      await F.del(r), se({ title: "删除成功", type: "success", duration: 2500 }), y.toQuery();
    } catch (o) {
      console.log("删除打包清单", o);
    }
  }, 200, false);
  return (r, o) => {
    const i = ce, _ = ue, m = q("common-button"), e = pe, s = q("common-table"), k = oe("permission"), te = me;
    return n(), L("div", Pe, [x("div", Re, [l(t(de), { ref_key: "headerRef", ref: R, onGetDetail: G }, null, 512)]), w((n(), u(s, { ref_key: "tableRef", ref: v, data: t(y).data, "empty-text": t(y).emptyText, "max-height": t(B), style: { width: "100%" }, onSelectionChange: t(y).selectionChangeHandler }, { default: c(() => [l(i, { type: "selection", width: "55", align: "center" }), l(i, { label: "序号", type: "index", align: "center", width: "60" }), !t(y).query.projectId && t(b).visible("project") ? (n(), u(i, { key: "project", prop: "project", "show-overflow-tooltip": true, label: "项目", "min-width": "250" }, { default: c((a) => [x("span", Ve, h(t(ye)(a.row.project)), 1)]), _: 1 })) : p("", true), t(b).visible("serialNumber") ? (n(), u(i, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "包单号", align: "center", "min-width": "130px" }, { default: c((a) => [l(t(he), { show: a.row.printType, offset: 15, name: "已打印", color: "#e64242" }, null, 8, ["show"]), x("span", null, h(a.row.serialNumber), 1)]), _: 1 })) : p("", true), t(b).visible("productType") ? (n(), u(i, { key: "productType", prop: "productType", label: "产品类型", align: "center", "min-width": "140px" }, { default: c((a) => [(n(true), L(U, null, ne(t(W).ENUM, (f) => (n(), L(U, { key: f }, [a.row.productType & f.V ? (n(), u(_, { key: 0, style: { "margin-right": "5px" }, type: f.T, effect: "light" }, { default: c(() => [C(h(f.L), 1)]), _: 2 }, 1032, ["type"])) : p("", true)], 64))), 128))]), _: 1 })) : p("", true), t(b).visible("packerName") ? (n(), u(i, { key: "packerName", prop: "packerName", "show-overflow-tooltip": true, label: "打包办理人", align: "center", "min-width": "120" })) : p("", true), t(b).visible("createTime") ? (n(), u(i, { key: "createTime", prop: "createTime", label: "日期", width: "160px" }, { default: c((a) => [x("span", null, h(t(_e)(a.row.createTime)), 1)]), _: 1 })) : p("", true), t(b).visible("quantity") ? (n(), u(i, { key: "quantity", prop: "quantity", "show-overflow-tooltip": true, label: "数量", align: "center", "min-width": "60" })) : p("", true), t(b).visible("totalGrossWeight") && t(y).query.productType === t(W).STRUCTURE.V ? (n(), u(i, { key: "totalGrossWeight", prop: "totalGrossWeight", "show-overflow-tooltip": true, label: "结构毛重(kg)", align: "right", "min-width": "120" }, { default: c((a) => [C(h(t(we)(a.row.totalGrossWeight, t(ke).COM_WT__KG)), 1)]), _: 1 })) : p("", true), t(b).visible("status") ? (n(), u(i, { key: "status", prop: "status", label: "状态", align: "center", "min-width": "100" }, { default: c((a) => [l(_, { type: t(N)[t(N).VK[a.row.status]].T, effect: "plain" }, { default: c(() => [C(h(t(N).VL[a.row.status]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : p("", true), t(b).visible("remark") ? (n(), u(i, { key: "remark", prop: "remark", "show-overflow-tooltip": true, label: "备注", "min-width": "140" })) : p("", true), t(E)([...t(d).detail]) ? (n(), u(i, { key: 9, label: "包单", width: "70px", align: "center", fixed: "right" }, { default: c((a) => [l(m, { type: "primary", icon: "el-icon-document", size: "default", onClick: le((f) => H(a.row), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })) : p("", true), t(E)([...t(d).print, ...t(d).printRecords]) ? (n(), u(i, { key: 10, label: "标签", width: "170px", align: "center", fixed: "right" }, { default: c((a) => [w(l(m, { icon: "el-icon-printer", type: "success", size: "default", onClick: (f) => A(a.row) }, null, 8, ["onClick"]), [[k, t(d).print]]), w(l(m, { icon: "el-icon-view", type: "primary", size: "default", onClick: (f) => J(a.row) }, null, 8, ["onClick"]), [[k, t(d).print]]), w(l(m, { icon: "el-icon-clock", type: "info", size: "default", onClick: (f) => X(a.row) }, null, 8, ["onClick"]), [[k, t(d).printRecords]])]), _: 1 })) : p("", true), t(E)([...t(d).detail, ...t(d).edit, ...t(d).del]) ? (n(), u(i, { key: 11, label: "操作", "min-width": "120px", align: "center", fixed: "right" }, { default: c((a) => [a.row.status === t(N).UNENTRUCK.V ? (n(), L(U, { key: 0 }, [l(e, { title: "确定要编辑此条打包记录吗？", onConfirm: (f) => Z(a.row.id, a.row.project.id) }, { reference: c(() => [w(l(m, { type: "primary", icon: "el-icon-edit", size: "default" }, null, 512), [[k, t(d).edit]])]), _: 2 }, 1032, ["onConfirm"]), l(e, { title: "确定要删除此条打包记录吗？", onConfirm: (f) => t(ee)(a.row.id) }, { reference: c(() => [w(l(m, { type: "danger", icon: "el-icon-delete", size: "default" }, null, 512), [[k, t(d).del]])]), _: 2 }, 1032, ["onConfirm"])], 64)) : p("", true)]), _: 1 })) : p("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSelectionChange"])), [[te, t(y).loading]]), l(t(Le)), l(t(Ne), { visible: D.value, "onUpdate:visible": o[0] || (o[0] = (a) => D.value = a), "label-data": $.value }, null, 8, ["visible", "label-data"]), l(t(Ce), { visible: Q.value, "onUpdate:visible": o[1] || (o[1] = (a) => Q.value = a), "detail-info": S.value, title: "打包清单", quantityFelid: "packageQuantity", detailFunc: t(M), onGetDetail: G }, { tip: c(() => [l(_, { effect: "plain", style: { "margin-left": "5px" }, size: "large" }, { default: c(() => [C(h(S.value.serialNumber), 1)]), _: 1 })]), _: 1 }, 8, ["visible", "detail-info", "detailFunc"]), l(t(Te), { visible: V.value, "onUpdate:visible": o[2] || (o[2] = (a) => V.value = a), "package-id": z.value }, null, 8, ["visible", "package-id"])]);
  };
} }, Ae = fe(De, [["__scopeId", "data-v-f9278fe9"]]);
export {
  Ae as default
};
