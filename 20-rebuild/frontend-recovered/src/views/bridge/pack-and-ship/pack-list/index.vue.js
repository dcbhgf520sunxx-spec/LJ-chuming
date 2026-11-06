import { useRouter as ee } from "vue-router";
import { reactive as te } from "vue";
import { ref as y } from "vue";
import { provide as ae } from "vue";
import { resolveComponent as L } from "vue";
import { resolveDirective as ie } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as q } from "vue";
import { createElementVNode as k } from "vue";
import { createVNode as n } from "vue";
import { unref as e } from "vue";
import { withDirectives as _ } from "vue";
import { createBlock as c } from "vue";
import { withCtx as s } from "vue";
import { toDisplayString as g } from "vue";
import { createCommentVNode as p } from "vue";
import { createTextVNode as v } from "vue";
import { withModifiers as oe } from "vue";
import { Fragment as re } from "vue";
import { ElNotification as ne } from "element-plus";
import { ElTableColumn as le } from "element-plus";
import { ElTag as se } from "element-plus";
import { ElPopconfirm as ce } from "element-plus";
import { vLoading as pe } from "element-plus";
import { c as z, _ as ue, d as G } from "./module/header.vue.js";
import { _ as de, x as me, o as fe, bw as b, z as ye, br as ge, p as _e, bs as be, D as he, bK as x, G as P, P as we, O as ke, c as U } from "../../../../shared/runtime.js";
import { o as u } from "../../../../modules/bridge-86f96a4f.js";
import ve from "../components/common-detail/index.vue.js";
import xe from "./module/label-dlg.vue.js";
import Te from "./module/printed-record-drawer.vue.js";
import "../../../../modules/print-record-c36add77.js";
import "../../../../modules/index-069ba252.js";
import "../../../../modules/index-90569c81.js";
import "../../../../modules/constant_2-1ad5d80f.js";
import "../../../../modules/label-logo-8a01bd73.js";
import "../../../../modules/index-f09320a8.js";
import "../../../../modules/index-3b2e6e51.js";
import "../../../../modules/use-label-print-47f6f6b0.js";
import "../components/common-detail/module/structure.vue.js";
import "../components/common-detail/module/enclosure.vue.js";
import "../components/common-detail/module/auxiliary-material.vue.js";
const Ce = { class: "app-container" }, Ne = { class: "head-container" }, Ve = { class: "project-name" }, Re = { __name: "index", setup(De) {
  const F = ee(), K = { add: false, edit: false, del: false, download: false }, T = te({}), C = y(), $ = y(), { crud: m, columns: d, CRUD: W } = me({ title: "打包记录", permission: { ...u }, crudApi: { ...z }, optShow: { ...K }, invisibleColumns: [] }, $), { maxHeight: B } = fe({ paginate: true }), N = y(false), V = y(false), R = y(false), Q = y(), S = y({}), D = y({});
  W.HOOK.handleRefresh = (o, r) => {
    r.data.content = r.data.content.map((i) => (i.packerName = i.userName, i.materialTypeNames = b.VL[i.productType], i));
  };
  function I(o) {
    D.value = o, R.value = true;
  }
  function j(o, r) {
    T[o] || (T[o] = r);
  }
  ae("detailStore", T);
  async function M(o) {
    try {
      await C.value.print([o]);
    } catch (r) {
      console.log("打印标签失败", r);
    }
  }
  async function O(o) {
    S.value = await C.value.getLabelInfo(o), V.value = true;
  }
  function H(o) {
    Q.value = o.id, N.value = true;
  }
  function A({ boxList: o, partList: r, auxiliaryMaterialList: i }) {
    const f = {};
    return f.boxList = o && o.map((t) => (t.weight = t.netWeight, t.totalWeight = U(t.weight * t.packageQuantity, "kg", "t"), t.productQuantity = t.packageQuantity, t)), f.partList = r && r.map((t) => (t.processingPrice = t.processingPrice || t.processingPrice === 0 ? t.processingPrice : void 0, t.totalLength = U(t.length * t.packageQuantity, "mm", "m"), t.productQuantity = t.packageQuantity, t)), f.auxiliaryMaterialList = i && i.map((t) => (t.fullClassName = `${t.firstName}/${t.secondName}/${t.thirdName}`, t.productQuantity = t.packageQuantity, t)), JSON.stringify(f);
  }
  async function J(o, r) {
    try {
      const i = await G(o) || {};
      F.push({ name: "BridgeManualPack", params: { id: o, projectId: r, remark: i.remark, data: A(i) } });
    } catch (i) {
      console.log("去编辑包", i);
    }
  }
  const X = ke(async function(o) {
    try {
      await z.del(o), ne({ title: "删除成功", type: "success", duration: 2500 }), m.toQuery();
    } catch (r) {
      console.log("删除打包清单", r);
    }
  }, 200, false);
  return (o, r) => {
    const i = le, f = se, t = L("common-button"), E = ce, Y = L("common-table"), h = ie("permission"), Z = pe;
    return l(), q("div", Ce, [k("div", Ne, [n(e(ue), { ref_key: "headerRef", ref: C, onGetDetail: j }, null, 512)]), _((l(), c(Y, { ref_key: "tableRef", ref: $, data: e(m).data, "empty-text": e(m).emptyText, "max-height": e(B), style: { width: "100%" }, onSelectionChange: e(m).selectionChangeHandler }, { default: s(() => [n(i, { type: "selection", width: "55", align: "center" }), n(i, { label: "序号", type: "index", align: "center", width: "60" }), !e(m).query.projectId && e(d).visible("project") ? (l(), c(i, { key: "project", prop: "project", "show-overflow-tooltip": true, label: "项目", "min-width": "250" }, { default: s((a) => [k("span", Ve, g(e(ye)(a.row.project)), 1)]), _: 1 })) : p("", true), e(d).visible("serialNumber") ? (l(), c(i, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "包单号", align: "center", "min-width": "130px" }, { default: s((a) => [n(e(ge), { show: a.row.printType, offset: 15, name: "已打印", color: "#e64242" }, null, 8, ["show"]), k("span", null, g(a.row.serialNumber), 1)]), _: 1 })) : p("", true), e(d).visible("productType") ? (l(), c(i, { key: "productType", prop: "productType", label: "产品类型", align: "center", width: "100px" }, { default: s((a) => [a.row.productType ? (l(), c(f, { key: 0, style: { "margin-right": "5px" }, type: e(b)[e(b).VK[a.row.productType]].T, effect: "light" }, { default: s(() => [v(g(e(b).VL[a.row.productType]), 1)]), _: 2 }, 1032, ["type"])) : p("", true)]), _: 1 })) : p("", true), e(d).visible("packerName") ? (l(), c(i, { key: "packerName", prop: "packerName", "show-overflow-tooltip": true, label: "打包办理人", align: "center", "min-width": "120" })) : p("", true), e(d).visible("createTime") ? (l(), c(i, { key: "createTime", prop: "createTime", label: "日期", width: "160px" }, { default: s((a) => [k("span", null, g(e(_e)(a.row.createTime)), 1)]), _: 1 })) : p("", true), e(d).visible("quantity") ? (l(), c(i, { key: "quantity", prop: "quantity", "show-overflow-tooltip": true, label: "数量", align: "center", "min-width": "60" })) : p("", true), e(d).visible("totalGrossWeight") && (e(m).query.productType === e(b).BOX.V || e(m).query.productType === e(b).MACHINE_PART.V) ? (l(), c(i, { key: "totalGrossWeight", prop: "totalGrossWeight", "show-overflow-tooltip": true, label: "毛重(kg)", align: "right", "min-width": "120" }, { default: s((a) => [v(g(e(be)(a.row.totalGrossWeight, e(he).COM_WT__KG)), 1)]), _: 1 })) : p("", true), e(d).visible("status") ? (l(), c(i, { key: "status", prop: "status", label: "状态", align: "center", "min-width": "100" }, { default: s((a) => [n(f, { type: e(x)[e(x).VK[a.row.status]].T, effect: "plain" }, { default: s(() => [v(g(e(x).VL[a.row.status]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : p("", true), e(d).visible("remark") ? (l(), c(i, { key: "remark", prop: "remark", "show-overflow-tooltip": true, label: "备注", "min-width": "140" })) : p("", true), e(P)([...e(u).detail]) ? (l(), c(i, { key: 9, label: "包单", width: "70px", align: "center", fixed: "right" }, { default: s((a) => [n(t, { type: "primary", icon: "el-icon-document", size: "default", onClick: oe((w) => I(a.row), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })) : p("", true), e(P)([...e(u).print, ...e(u).printRecords]) ? (l(), c(i, { key: 10, label: "标签", width: "170px", align: "center", fixed: "right" }, { default: s((a) => [_(n(t, { icon: "el-icon-printer", type: "success", size: "default", onClick: (w) => M(a.row) }, null, 8, ["onClick"]), [[h, e(u).print]]), _(n(t, { icon: "el-icon-view", type: "primary", size: "default", onClick: (w) => O(a.row) }, null, 8, ["onClick"]), [[h, e(u).print]]), _(n(t, { icon: "el-icon-clock", type: "info", size: "default", onClick: (w) => H(a.row) }, null, 8, ["onClick"]), [[h, e(u).printRecords]])]), _: 1 })) : p("", true), e(P)([...e(u).detail, ...e(u).edit, ...e(u).del]) ? (l(), c(i, { key: 11, label: "操作", "min-width": "120px", align: "center", fixed: "right" }, { default: s((a) => [a.row.status === e(x).UNENTRUCK.V ? (l(), q(re, { key: 0 }, [n(E, { title: "确定要编辑此条打包记录吗？", onConfirm: (w) => J(a.row.id, a.row.project.id) }, { reference: s(() => [_(n(t, { type: "primary", icon: "el-icon-edit", size: "default" }, null, 512), [[h, e(u).edit]])]), _: 2 }, 1032, ["onConfirm"]), n(E, { title: "确定要删除此条打包记录吗？", onConfirm: (w) => e(X)(a.row.id) }, { reference: s(() => [_(n(t, { type: "danger", icon: "el-icon-delete", size: "default" }, null, 512), [[h, e(u).del]])]), _: 2 }, 1032, ["onConfirm"])], 64)) : p("", true)]), _: 1 })) : p("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSelectionChange"])), [[Z, e(m).loading]]), n(e(we)), n(e(xe), { visible: V.value, "onUpdate:visible": r[0] || (r[0] = (a) => V.value = a), "label-data": S.value }, null, 8, ["visible", "label-data"]), n(e(ve), { visible: R.value, "onUpdate:visible": r[1] || (r[1] = (a) => R.value = a), "detail-info": D.value, title: "打包清单", quantityFelid: "packageQuantity", detailFunc: e(G), onGetDetail: j }, { tip: s(() => [n(f, { effect: "plain", style: { "margin-left": "5px" }, size: "large" }, { default: s(() => [v(g(D.value.serialNumber), 1)]), _: 1 })]), _: 1 }, 8, ["visible", "detail-info", "detailFunc"]), n(e(Te), { visible: N.value, "onUpdate:visible": r[2] || (r[2] = (a) => N.value = a), "package-id": Q.value }, null, 8, ["visible", "package-id"])]);
  };
} }, He = de(Re, [["__scopeId", "data-v-8525672c"]]);
export {
  He as default
};
