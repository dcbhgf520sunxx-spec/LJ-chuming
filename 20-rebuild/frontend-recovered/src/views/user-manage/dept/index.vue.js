import { ref as B } from "vue";
import { resolveComponent as D } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as H } from "vue";
import { createElementVNode as N } from "vue";
import { createVNode as r } from "vue";
import { unref as e } from "vue";
import { withDirectives as U } from "vue";
import { createBlock as s } from "vue";
import { withCtx as u } from "vue";
import { createCommentVNode as l } from "vue";
import { createTextVNode as g } from "vue";
import { toDisplayString as b } from "vue";
import { ElMessageBox as I } from "element-plus";
import { ElTableColumn as L } from "element-plus";
import { ElSwitch as R } from "element-plus";
import { vLoading as A } from "element-plus";
import { c as F, a as O } from "../../../modules/dept-398bb184.js";
import { d } from "../../../modules/user-2de6904c.js";
import { x as M, o as P, x9 as y, G as x, cB as p, an as $ } from "../../../shared/runtime.js";
import j from "./module/header.vue.js";
import q from "./module/form.vue.js";
import "../../../modules/tree-select-86c0f12c.js";
const G = { class: "app-container" }, Y = { class: "head-container" }, ae = { __name: "index", setup(z) {
  const _ = B(), v = { add: true, del: false }, { crud: i, columns: c, CRUD: C } = M({ title: "部门", sort: [], optShow: { ...v }, permission: { ...d }, crudApi: { ...F } }, _), { maxHeight: w } = P();
  function h(a) {
    return a.deptType === y.OUTSIDE_THE_ESTABLISHMENT.V;
  }
  function T(a, m) {
    return a.id !== 1;
  }
  async function E(a) {
    try {
      await I.confirm('此操作将 "' + p.VL[a.status] + '" ' + a.name + ", 是否继续？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" });
      const m = { id: a.id, enabled: a.status };
      await O(m), i.refresh(), i.notify(p.VL[a.status] + "成功", C.NOTIFICATION_TYPE.SUCCESS);
    } catch (m) {
      i.refresh(), console.log(m, "状态修改失败：changeStatus");
    }
  }
  return (a, m) => {
    const o = L, S = R, V = D("common-table"), k = A;
    return n(), H("div", G, [N("div", Y, [r(e(j), { ref: "header", permission: e(d) }, null, 8, ["permission"])]), U((n(), s(V, { ref_key: "tableRef", ref: _, data: e(i).data, "empty-text": e(i).emptyText, "max-height": e(w), style: { width: "100%" }, "row-key": "id", onSelectionChange: e(i).selectionChangeHandler }, { default: u(() => [r(o, { selectable: T, type: "selection", width: "55", align: "center" }), r(o, { label: "序号", type: "index", align: "center", width: "60" }), e(c).visible("name") ? (n(), s(o, { key: "name", prop: "name", label: "名称" })) : l("", true), e(c).visible("orgCode") ? (n(), s(o, { key: "orgCode", prop: "orgCode", label: "SHR部门编号", align: "center" })) : l("", true), e(c).visible("deptType") ? (n(), s(o, { key: "deptType", prop: "deptType", label: "部门类型", align: "center" }, { default: u(({ row: t }) => [g(b(e(y).VL[t.deptType]), 1)]), _: 1 })) : l("", true), e(c).visible("status") ? (n(), s(o, { key: "status", prop: "status", label: "状态", align: "center" }, { default: u((t) => [r(S, { modelValue: t.row.status, "onUpdate:modelValue": (f) => t.row.status = f, "active-color": "#409EFF", "inactive-color": "#F56C6C", disabled: !e(x)(e(d).edit) || t.$index == 0 || !h(t.row), "active-value": e(p).TRUE.V, "inactive-value": e(p).FALSE.V, onChange: (f) => E(t.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "active-value", "inactive-value", "onChange"])]), _: 1 })) : l("", true), e(c).visible("sort") ? (n(), s(o, { key: "sort", prop: "sort", label: "排序", align: "center", width: "100" }, { default: u((t) => [g(b(t.row.sort), 1)]), _: 1 })) : l("", true), e(x)([...e(d).edit, ...e(d).del]) ? (n(), s(o, { key: 5, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: u((t) => [r(e($), { data: t.row, permission: e(d), "del-prompt": "确定删除吗,如果存在下级节点则一并删除，此操作不能撤销！", "disabled-del": t.row.id === 1 || !h(t.row), "disabled-edit": !h(t.row) }, null, 8, ["data", "permission", "disabled-del", "disabled-edit"])]), _: 1 })) : l("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSelectionChange"])), [[k, e(i).loading]]), r(e(q))]);
  };
} };
export {
  ae as default
};
