import { ref as h } from "vue";
import { provide as x } from "vue";
import { resolveComponent as b } from "vue";
import { resolveDirective as X } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as f } from "vue";
import { unref as o } from "vue";
import { Fragment as k } from "vue";
import { createElementVNode as M } from "vue";
import { createVNode as d } from "vue";
import { withDirectives as q } from "vue";
import { createBlock as r } from "vue";
import { withCtx as c } from "vue";
import { createCommentVNode as s } from "vue";
import { toDisplayString as v } from "vue";
import { createTextVNode as I } from "vue";
import { ElMessage as Z } from "element-plus";
import { ElTableColumn as ee } from "element-plus";
import { ElTooltip as te } from "element-plus";
import { ElPopconfirm as oe } from "element-plus";
import { vLoading as ie } from "element-plus";
import { c as C } from "../../../../modules/standard-part-8c26f414.js";
import { _ as ne, m as ae, x as re, o as le, ky as E, G as O, P as se, fK as T, c9 as ce } from "../../../../shared/runtime.js";
import ue from "./module/header.vue.js";
import de from "./module/form.vue.js";
import "./module/auxiliary-material-form.vue.js";
import "./module/material/common-wrapper.vue.js";
import "../../../wms/material-inbound/raw-material/application/components/common-footer.vue.js";
import "./module/material/confirm-dialog.vue.js";
import "./module/material/aux-mat-table.vue.js";
const pe = { class: "app-container" }, me = { class: "head-container" }, fe = { key: 1 }, ye = { key: 1 }, _e = { key: 1 }, ge = { __name: "index", setup(he) {
  const { globalProject: _, globalProjectId: R } = ae(["globalProject", "globalProjectId"]), y = { get: ["get"], add: ["add"], edit: ["edit"], del: ["del"] }, A = { add: true, edit: false, del: false, download: false }, N = h(), P = h({}), S = h({}), U = h({}), { crud: p, columns: m, CRUD: w } = re({ title: "配套件清单", sort: ["id.desc"], permission: { ...y }, optShow: { ...A }, requiredQuery: ["projectId"], crudApi: { ...C }, hasPagination: true }, N), { maxHeight: z } = le({ wrapperBox: ".plan-auxiliary-material", paginate: true, extraHeight: 40 });
  function F(e) {
    S.value = e;
  }
  function D(e) {
    U.value = e;
  }
  x("currentMonomer", S), x("globalProject", _), x("currentArea", U);
  const V = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], quantity: [{ validator: (e, n) => n.measureUnit ? !!e : true, message: "请填写数量", trigger: "blur" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }, { pattern: ce, message: "核算量必须大于0", trigger: "blur" }], useProperty: [{ required: true, message: "请选择使用范围", trigger: "change" }] };
  function B({ row: e, column: n }) {
    if (!e) return;
    const a = V;
    let l = true;
    return e.verify && Object.keys(e.verify) && Object.keys(e.verify).length > 0 && (e.verify[n.property] === false && (l = T(n.property, a[n.property], e)), l && (e.verify[n.property] = true)), l ? "" : "mask-td";
  }
  function $(e) {
    P.value = JSON.parse(JSON.stringify(e)), e.isModify = true;
  }
  async function J(e) {
    try {
      await C.del(p.query.projectId, [e.id]), p.notify("删除成功", w.NOTIFICATION_TYPE.SUCCESS), p.toQuery();
    } catch (n) {
      console.log("删除", n);
    }
  }
  function L(e) {
    e = Object.assign(e, JSON.parse(JSON.stringify(P.value))), e.isModify = false;
  }
  async function Q(e) {
    const n = V;
    let a = true;
    e.verify = {};
    for (const l in n) e.verify[l] = T(l, n[l], e), e.verify[l] || (a = false);
    if (!a) {
      Z.error("请填写表格中标红数据");
      return;
    }
    try {
      await C.edit(e), p.notify("修改成功", w.NOTIFICATION_TYPE.SUCCESS), e.isModify = false;
    } catch (l) {
      console.log("修改", l);
    }
  }
  return (e, n) => {
    const a = ee, l = te, j = b("common-input-number"), H = b("common-select"), g = b("common-button"), G = oe, Y = b("common-table"), K = X("permission"), W = ie;
    return i(), f("div", pe, [o(_) && o(_).projectContentList && o(_).projectContentList.length > 0 ? (i(), f(k, { key: 0 }, [M("div", me, [d(o(ue), { "project-id": o(R), onCurrentChange: F, onCurrentAreaChange: D }, null, 8, ["project-id"])]), q((i(), r(Y, { ref_key: "tableRef", ref: N, data: o(p).data, "empty-text": o(p).emptyText, "max-height": o(z), "return-source-data": "", style: { width: "100%" }, onSortChange: o(p).handleSortChange, class: "enclosure-table", "cell-class-name": B }, { default: c(() => [d(a, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), o(m).visible("serialNumber") ? (i(), r(a, { key: 0, prop: "serialNumber", label: "编号", align: "center", width: "110px", fixed: "left", "show-overflow-tooltip": true })) : s("", true), o(m).visible("classifyName") ? (i(), r(a, { key: 1, prop: "classifyName", label: "名称", align: "center", fixed: "left", "min-width": "150", "show-overflow-tooltip": true }, { default: c(({ row: t }) => [d(l, { content: t.classifyFullName, disabled: !t.classifyFullName, "show-after": 200, placement: "top" }, { default: c(() => [M("span", null, v(t.classifyName), 1)]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 })) : s("", true), o(m).visible("specification") ? (i(), r(a, { key: 2, "show-overflow-tooltip": true, prop: "specification", label: "规格", align: "center", "min-width": "200px", fixed: "left" })) : s("", true), o(m).visible("measureUnit") ? (i(), r(a, { key: 3, "show-overflow-tooltip": true, prop: "measureUnit", label: "计量单位", align: "center", "min-width": "70px" })) : s("", true), o(m).visible("quantity") ? (i(), r(a, { key: 4, "show-overflow-tooltip": true, prop: "quantity", label: "数量", align: "center", "min-width": "120px" }, { default: c(({ row: t }) => [t.measureUnit && t.isModify ? (i(), r(j, { key: 0, modelValue: t.quantity, "onUpdate:modelValue": (u) => t.quantity = u, min: 0, max: 999999999, controls: false, step: 1, precision: t.measurePrecision, size: "default", placeholder: "数量" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (i(), f("span", fe, v(t.quantity), 1))]), _: 1 })) : s("", true), o(m).visible("accountingUnit") ? (i(), r(a, { key: 5, "show-overflow-tooltip": true, prop: "accountingUnit", label: "核算单位", align: "center", "min-width": "70px" })) : s("", true), o(m).visible("mete") ? (i(), r(a, { key: 6, "show-overflow-tooltip": true, prop: "mete", label: "核算量", align: "center", "min-width": "120px" }, { default: c(({ row: t }) => [t.isModify ? (i(), r(j, { key: 0, modelValue: t.mete, "onUpdate:modelValue": (u) => t.mete = u, min: 1e-6, max: 999999999, controls: false, step: 1, precision: t.accountingPrecision, size: "default", placeholder: "核算量" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (i(), f("span", ye, v(t.mete), 1))]), _: 1 })) : s("", true), o(m).visible("useProperty") ? (i(), r(a, { key: 7, prop: "useProperty", label: "使用范围", align: "center", "min-width": "120px" }, { default: c(({ row: t }) => [t.isModify ? (i(), r(H, { key: 0, modelValue: t.useProperty, "onUpdate:modelValue": (u) => t.useProperty = u, options: o(E).ENUM, type: "enum", size: "default", clearable: "", placeholder: "使用范围" }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])) : (i(), f("span", _e, v(o(E).VL[t.useProperty]), 1))]), _: 1 })) : s("", true), o(O)([...y.edit, ...y.del]) ? (i(), r(a, { key: 8, label: "操作", width: "180px", align: "center", fixed: "right" }, { default: c((t) => [t.row.isModify ? (i(), f(k, { key: 0 }, [d(g, { type: "info", size: "default", onClick: (u) => L(t.row) }, { default: c(() => n[0] || (n[0] = [I("取消")])), _: 2, __: [0] }, 1032, ["onClick"]), d(g, { type: "primary", size: "default", onClick: (u) => Q(t.row) }, { default: c(() => n[1] || (n[1] = [I("保存")])), _: 2, __: [1] }, 1032, ["onClick"])], 64)) : (i(), f(k, { key: 1 }, [q(d(g, { size: "default", icon: "el-icon-edit", type: "primary", onClick: (u) => $(t.row) }, null, 8, ["onClick"]), [[K, y.edit]]), o(O)(y.del) ? (i(), r(G, { key: 0, "confirm-button-text": "确定", "cancel-button-text": "取消", "icon-color": "red", title: "确定删除吗?", onConfirm: (u) => J(t.row) }, { reference: c(() => [d(g, { size: "default", icon: "el-icon-delete", type: "danger" })]), _: 2 }, 1032, ["onConfirm"])) : s("", true)], 64))]), _: 1 })) : s("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSortChange"])), [[W, o(p).loading]]), d(o(se)), d(o(de))], 64)) : s("", true)]);
  };
} }, je = ne(ge, [["__scopeId", "data-v-312cbe36"]]);
export {
  je as default
};
