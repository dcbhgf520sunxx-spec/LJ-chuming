import { ref as j } from "vue";
import { watch as W } from "vue";
import { resolveComponent as M } from "vue";
import { resolveDirective as Q } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as i } from "vue";
import { unref as t } from "vue";
import { Fragment as p } from "vue";
import { createElementVNode as h } from "vue";
import { createVNode as c } from "vue";
import { withDirectives as N } from "vue";
import { createBlock as u } from "vue";
import { withCtx as y } from "vue";
import { toDisplayString as w } from "vue";
import { createCommentVNode as D } from "vue";
import { renderList as L } from "vue";
import { normalizeClass as k } from "vue";
import { createTextVNode as I } from "vue";
import { ElMessage as J } from "element-plus";
import { ElTableColumn as Y } from "element-plus";
import { ElInputNumber as X } from "element-plus";
import { ElDatePicker as Z } from "element-plus";
import { vLoading as ee } from "element-plus";
import { _ as te, m as ae, T, x as oe, sW as R, o as ie, G as le, an as ne, D as O, p as K, c7 as re, P as se } from "../../../../shared/runtime.js";
import { c as S } from "../../../../modules/plan-d12d7ccf.js";
import me from "./module/header.vue.js";
import de from "./module/form.vue.js";
const ce = { class: "app-container" }, ue = { class: "head-container" }, ye = { key: 0 }, _e = { key: 1, class: "sandwich-cell-bottom" }, pe = { key: 1, class: "sandwich-cell-bottom" }, he = { key: 1 }, De = { key: 1, class: "sandwich-cell-bottom" }, fe = { key: 1, class: "sandwich-cell-bottom" }, ge = { key: 1, class: "sandwich-cell-bottom" }, be = { key: 1, class: "sandwich-cell-bottom" }, we = { key: 1, class: "sandwich-cell-bottom" }, Le = { key: 1, style: { color: "red", "font-size": "14px" } }, ke = { __name: "index", setup(ve) {
  const { globalProject: g, globalProjectId: E } = ae(["globalProject", "globalProjectId"]), F = { add: true, edit: false, del: true, download: false }, P = j(), U = j({}), x = [{ label: "构件", key: "mainStructure", dateKey: "mainStructureDate", no: T.STRUCTURE.V, alias: "STRUCTURE", unit: "t" }, { label: "箱体", key: "bridgeStructure", dateKey: "bridgeStructureDate", no: T.BRIDGE.V, alias: "STRUCTURE", unit: "t" }], { crud: _, columns: b, CRUD: C } = oe({ title: "单体", sort: ["sort.asc", "id.desc"], permission: { ...S.value }, optShow: { ...F }, crudApi: { ...R }, hasPagination: true }, P), { maxHeight: z } = ie({ wrapperBox: ".monomer", paginate: true, extraHeight: 40 });
  W(() => E.value, (o) => {
    o && _.toQuery();
  }, { immediate: true, deep: true }), C.HOOK.beforeRefresh = () => (_.query.projectId = E.value, _.query.projectId), C.HOOK.handleRefresh = (o, r) => {
    r.data.content.forEach((l) => (l.startDate = l.startDate || g.value.startDate, l.monomerDetailList.length > 0 && x.forEach((m) => {
      const f = l.monomerDetailList.find((v) => v.type === m.no);
      f ? (f.label = m.label, f.unit = m.unit, f.key = m.key, f.dateKey = m.key + "Date", l[m.key] = f.mete, l[m.key + "Date"] = f.date) : (l[m.key] = void 0, l[m.key + "Date"] = void 0);
    }), l));
  };
  function B(o, r) {
    o.monomerDetailList[r] = Object.assign(o.monomerDetailList[r], JSON.parse(JSON.stringify(U.value))), o.monomerDetailList[r].isModify = false;
  }
  async function H(o, r) {
    if (!o.monomerDetailList[r].mete) {
      J.error("工程量必填");
      return;
    }
    if (!o.monomerDetailList[r].date) {
      J.error("计划完成时间必填");
      return;
    }
    try {
      o.detailSaveDTOParamList = [], o.detailSaveDTOParamList = JSON.parse(JSON.stringify(o.monomerDetailList)), await R.edit(o), _.notify("修改成功", C.NOTIFICATION_TYPE.SUCCESS), o[o.monomerDetailList[r].key] = o.monomerDetailList[r].mete, o[o.monomerDetailList[r].dateKey] = o.monomerDetailList[r].date, o.monomerDetailList[r].isModify = false;
    } catch (l) {
      console.log("修改", l);
    }
  }
  function A(o, r) {
    U.value = JSON.parse(JSON.stringify(o.monomerDetailList[r])), o.monomerDetailList[r].isModify = true;
  }
  async function G(o, r) {
    try {
      o.detailSaveDTOParamList = [], o.detailSaveDTOParamList = JSON.parse(JSON.stringify(o.monomerDetailList)), o.detailSaveDTOParamList.splice(r, 1), await R.edit(o), _.notify("删除成功", C.NOTIFICATION_TYPE.SUCCESS), _.toQuery();
    } catch (l) {
      console.log("修改", l);
    }
  }
  return (o, r) => {
    const l = Y, m = X, f = Z, v = M("common-button"), $ = M("common-table"), V = Q("permission"), q = ee;
    return a(), i("div", ce, [t(g) && t(g).projectContentList && t(g).projectContentList.length > 0 ? (a(), i(p, { key: 0 }, [h("div", ue, [c(t(me), { globalProject: t(g) }, null, 8, ["globalProject"])]), N((a(), u($, { ref_key: "tableRef", ref: P, data: t(_).data, "empty-text": t(_).emptyText, "max-height": t(z), style: { width: "100%" }, "row-key": "id", onSelectionChange: t(_).selectionChangeHandler, class: "upload-table", "return-source-data": "", showEmptySymbol: false }, { default: y(() => [c(l, { type: "selection", width: "55", align: "center" }), c(l, { label: "序号", type: "index", align: "center", width: "60" }), t(b).visible("name") ? (a(), u(l, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "单体名称", align: "center" }, { default: y((e) => [h("span", null, w(e.row.name ? e.row.name : "-"), 1), t(le)([...t(S).edit, ...t(S).del]) ? (a(), i("div", ye, [c(t(ne), { data: e.row, permission: t(S) }, null, 8, ["data", "permission"])])) : D("", true)]), _: 1 })) : D("", true), t(b).visible("sort") ? (a(), u(l, { key: "sort", prop: "sort", label: "排序", align: "center" })) : D("", true), t(b).visible("content") ? (a(), u(l, { key: "content", prop: "content", label: "项目内容", align: "center" }, { default: y((e) => [e.row.monomerDetailList.length > 0 ? (a(true), i(p, { key: 0 }, L(e.row.monomerDetailList, (n, s) => (a(), i("div", { key: n.type }, [h("div", { class: k(s === e.row.monomerDetailList.length - 1 ? "sandwich-cell-bottom" : "sandwich-cell-top") }, w(n.label), 3)]))), 128)) : (a(), i("div", _e))]), _: 1 })) : D("", true), t(b).visible("unit") ? (a(), u(l, { key: "unit", prop: "unit", label: "单位", align: "center" }, { default: y((e) => [e.row.monomerDetailList.length > 0 ? (a(true), i(p, { key: 0 }, L(e.row.monomerDetailList, (n, s) => (a(), i("div", { key: n.type }, [h("div", { class: k(s === e.row.monomerDetailList.length - 1 ? "sandwich-cell-bottom" : "sandwich-cell-top") }, w(n.unit), 3)]))), 128)) : (a(), i("div", pe))]), _: 1 })) : D("", true), t(b).visible("mete") ? (a(), u(l, { key: "mete", prop: "mete", label: "工程量", align: "center" }, { default: y((e) => [e.row.monomerDetailList.length > 0 ? (a(true), i(p, { key: 0 }, L(e.row.monomerDetailList, (n, s) => (a(), i("div", { key: n.type }, [h("div", { class: k(s === e.row.monomerDetailList.length - 1 ? "sandwich-cell-bottom" : "sandwich-cell-top") }, [e.row.monomerDetailList[s].isModify ? (a(), u(m, { key: 0, modelValue: e.row.monomerDetailList[s].mete, "onUpdate:modelValue": (d) => e.row.monomerDetailList[s].mete = d, step: 10, min: 0, max: 999999999999, precision: e.row.monomerDetailList[s].type === t(T).STRUCTURE.V ? t(O).COM_WT__KG : t(O).MES_ENCLOSURE_L__M, "controls-position": "right" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (a(), i("span", he, w(n.type === t(T).STRUCTURE.V ? n.mete.toFixed(t(O).COM_WT__KG) : n.mete.toFixed(t(O).MES_ENCLOSURE_L__M)), 1))], 2)]))), 128)) : (a(), i("div", De))]), _: 1 })) : D("", true), t(b).visible("startDate") ? (a(), u(l, { key: "startDate", prop: "startDate", label: "开始时间", align: "center" }, { default: y((e) => [e.row.monomerDetailList.length > 0 ? (a(true), i(p, { key: 0 }, L(e.row.monomerDetailList, (n, s) => (a(), i("div", { key: n.type }, [h("div", { class: k(s === e.row.monomerDetailList.length - 1 ? "sandwich-cell-bottom" : "sandwich-cell-top") }, w(e.row.startDate ? t(K)(e.row.startDate, "{y}-{m}-{d}") : "-"), 3)]))), 128)) : (a(), i("div", fe))]), _: 1 })) : D("", true), t(b).visible("startDate") ? (a(), u(l, { key: "startDate", prop: "startDate", label: "计划完成时间", align: "center" }, { default: y((e) => [e.row.monomerDetailList.length > 0 ? (a(true), i(p, { key: 0 }, L(e.row.monomerDetailList, (n, s) => (a(), i("div", { key: n.type }, [h("div", { class: k(s === e.row.monomerDetailList.length - 1 ? "sandwich-cell-bottom" : "sandwich-cell-top") }, [e.row.monomerDetailList[s].isModify ? (a(), u(f, { key: 0, modelValue: e.row.monomerDetailList[s].date, "onUpdate:modelValue": (d) => e.row.monomerDetailList[s].date = d, type: "date", "value-format": "x", placeholder: "选择完成日期", disabledDate: (d) => e.row.date ? d.getTime() - 1 * 24 * 60 * 60 * 1e3 < t(g).startDate || d.getTime() > e.row.date : d.getTime() - 1 * 24 * 60 * 60 * 1e3 < t(g).startDate }, null, 8, ["modelValue", "onUpdate:modelValue", "disabledDate"])) : D("", true), h("span", null, w(n.date ? t(K)(n.date, "{y}-{m}-{d}") : "-"), 1)], 2)]))), 128)) : (a(), i("div", ge))]), _: 1 })) : D("", true), t(b).visible("dateNum") ? (a(), u(l, { key: "dateNum", prop: "dateNum", label: "工期(天)", align: "center" }, { default: y((e) => [e.row.monomerDetailList.length > 0 ? (a(true), i(p, { key: 0 }, L(e.row.monomerDetailList, (n, s) => (a(), i("div", { key: n.type }, [h("div", { class: k(s === e.row.monomerDetailList.length - 1 ? "sandwich-cell-bottom" : "sandwich-cell-top") }, w(e.row.startDate && n.date ? t(re)(e.row.startDate, n.date) : "-"), 3)]))), 128)) : (a(), i("div", be))]), _: 1 })) : D("", true), c(l, { label: "操作", width: "160px", align: "center", fixed: "right" }, { default: y((e) => [e.row.monomerDetailList.length > 0 ? (a(true), i(p, { key: 0 }, L(e.row.monomerDetailList, (n, s) => (a(), i("div", { key: n.type }, [h("div", { class: k(s === e.row.monomerDetailList.length - 1 ? "sandwich-cell-bottom" : "sandwich-cell-top") }, [n.isModify ? (a(), i(p, { key: 0 }, [c(v, { type: "info", size: "default", onClick: (d) => B(e.row, s) }, { default: y(() => r[0] || (r[0] = [I("取消")])), _: 2, __: [0] }, 1032, ["onClick"]), c(v, { type: "primary", size: "default", onClick: (d) => H(e.row, s) }, { default: y(() => r[1] || (r[1] = [I("保存")])), _: 2, __: [1] }, 1032, ["onClick"])], 64)) : (a(), i(p, { key: 1 }, [N(c(v, { size: "default", onClick: (d) => A(e.row, s), icon: "el-icon-edit", type: "primary" }, null, 8, ["onClick"]), [[V, t(S).productTypeEdit]]), N(c(v, { size: "default", onClick: (d) => G(e.row, n), icon: "el-icon-delete", type: "danger" }, null, 8, ["onClick"]), [[V, t(S).productTypeDel]])], 64))], 2)]))), 128)) : (a(), i("div", we))]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSelectionChange"])), [[q, t(_).loading]]), c(t(se)), c(t(de), { "project-id": t(E), "global-project": t(g), "origin-option": x }, null, 8, ["project-id", "global-project"])], 64)) : (a(), i("div", Le, "*请先前去合同管理模块添加项目内容"))]);
  };
} }, Ne = te(ke, [["__scopeId", "data-v-c03a357a"]]);
export {
  Ne as default
};
