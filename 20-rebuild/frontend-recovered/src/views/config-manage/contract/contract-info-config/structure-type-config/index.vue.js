import { ref as x } from "vue";
import { inject as I } from "vue";
import { resolveComponent as T } from "vue";
import { resolveDirective as H } from "vue";
import { openBlock as l } from "vue";
import { createBlock as c } from "vue";
import { withCtx as s } from "vue";
import { createElementVNode as p } from "vue";
import { withDirectives as _ } from "vue";
import { unref as e } from "vue";
import { createTextVNode as g } from "vue";
import { createVNode as r } from "vue";
import { toDisplayString as k } from "vue";
import { createCommentVNode as f } from "vue";
import { createElementBlock as S } from "vue";
import { withModifiers as M } from "vue";
import { ElMessageBox as V } from "element-plus";
import { ElNotification as O } from "element-plus";
import { ElTableColumn as Q } from "element-plus";
import { ElSwitch as q } from "element-plus";
import { ElPopconfirm as G } from "element-plus";
import { ElCard as K } from "element-plus";
import { vLoading as Y } from "element-plus";
import { c as h, b as J, g as W } from "../../../../../modules/structure-type-config-b977de76.js";
import { _ as X, x as Z, dk as m, K as ee, aS as y, G as w, P as te } from "../../../../../shared/runtime.js";
import oe from "./module/form.vue.js";
import ne from "./module/batchForm.vue.js";
import "../../../../../modules/use-table-operate-4f84437f.js";
const ae = { class: "header" }, ie = { key: 0 }, le = { key: 1 }, se = { __name: "index", setup(ce) {
  const B = { add: false, edit: false, del: false, download: false }, E = x(), v = x(false), { crud: o, CRUD: D, columns: C } = Z({ title: "项目结构类型", sort: [], permission: { ...m }, optShow: { ...B }, crudApi: { ...h } }, E), j = I("maxHeight");
  async function L(a) {
    try {
      await h.del(a.id), o.notify("删除成功", "success"), o.toQuery();
    } catch (t) {
      console.log(t);
    }
  }
  async function N() {
    var a;
    try {
      v.value = true, await V.confirm("是否确认批量删除选中数据？", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning", draggable: true });
      const t = (a = o.selections) == null ? void 0 : a.map((i) => i.id);
      await J(t), o.toQuery(), O({ title: "批量删除成功", type: "success", duration: 2500 });
    } catch (t) {
      console.log(t);
    } finally {
      v.value = false;
    }
  }
  async function P(a, t) {
    try {
      await V.confirm('此操作将 "' + y.VL[t] + '" ' + a.name + ", 是否继续？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" });
      const i = { id: a.id, boolEnableEnum: a.boolEnableEnum, name: a.name };
      await h.edit(i), o.refresh(), o.notify(y.VL[t] + "成功", D.NOTIFICATION_TYPE.SUCCESS);
    } catch (i) {
      console.log("变更状态", i), a.boolEnableEnum = !t;
    }
  }
  async function R() {
    try {
      await W();
    } catch (a) {
      console.log(a);
    }
  }
  return R(), (a, t) => {
    const i = T("common-button"), u = Q, A = q, U = G, z = T("common-table"), F = K, b = H("permission"), $ = Y;
    return l(), c(F, { class: "line-box box-card" }, { header: s(() => {
      var n;
      return [p("div", ae, [t[3] || (t[3] = p("span", { class: "title" }, "项目结构类型设置", -1)), p("div", null, [_((l(), c(i, { icon: "el-icon-delete", size: "default", type: "danger", disabled: !((n = e(o).selections) != null && n.length), onClick: N }, { default: s(() => t[0] || (t[0] = [g(" 批量删除 ")])), _: 1, __: [0] }, 8, ["disabled"])), [[b, e(m).del]]), _((l(), c(i, { icon: "el-icon-plus", size: "default", type: "primary", onClick: e(o).toAdd }, { default: s(() => t[1] || (t[1] = [g(" 新增 ")])), _: 1, __: [1] }, 8, ["onClick"])), [[b, e(m).add]]), _((l(), c(i, { icon: "el-icon-plus", size: "default", type: "primary", onClick: e(o).toBatchAdd }, { default: s(() => t[2] || (t[2] = [g(" 批量新增 ")])), _: 1, __: [2] }, 8, ["onClick"])), [[b, e(m).add]])])])];
    }), default: s(() => [_((l(), c(z, { ref_key: "tableRef", ref: E, data: e(o).data, "empty-text": e(o).emptyText, "max-height": e(j), style: { width: "100%" }, onSelectionChange: e(o).selectionChangeHandler }, { default: s(() => [r(u, { type: "selection", align: "center", width: "55" }), r(u, { align: "center", label: "序号", type: "index", width: "55" }), e(C).visible("name") ? (l(), c(u, { key: "name", "show-overflow-tooltip": true, label: "	类型名称", "min-width": "140px", prop: "name", align: "center" }, { default: s((n) => [p("span", null, k(n.row.name || "-"), 1)]), _: 1 })) : f("", true), e(C).visible("projectType") ? (l(), c(u, { key: "projectType", "show-overflow-tooltip": true, label: "	项目类型", prop: "projectType", align: "center" }, { default: s((n) => {
      var d;
      return [n.row.projectType ? (l(), S("span", ie, k(((d = e(ee).V[n.row.projectType]) == null ? void 0 : d.SL) || "-"), 1)) : (l(), S("span", le, "-"))];
    }), _: 1 })) : f("", true), r(u, { key: "boolEnableEnum", prop: "boolEnableEnum", label: "状态", align: "center" }, { default: s((n) => [r(A, { modelValue: n.row.boolEnableEnum, "onUpdate:modelValue": (d) => n.row.boolEnableEnum = d, "active-color": "#409EFF", "inactive-color": "#F56C6C", "active-value": e(y).TRUE.V, "inactive-value": e(y).FALSE.V, disabled: !e(w)(e(m).edit), onChange: (d) => P(n.row, n.row.boolEnableEnum) }, null, 8, ["modelValue", "onUpdate:modelValue", "active-value", "inactive-value", "disabled", "onChange"])]), _: 1 }), r(u, { align: "center", fixed: "right", label: "操作", width: "130px" }, { default: s((n) => [e(w)(e(o).permission.edit) ? (l(), c(i, { key: 0, icon: "el-icon-edit", size: "default", type: "primary", onClick: M((d) => e(o).toEdit(n.row), ["stop"]) }, null, 8, ["onClick"])) : f("", true), e(w)(e(o).permission.del) ? (l(), c(U, { key: 1, title: "是否确认删除？", onConfirm: (d) => L(n.row) }, { reference: s(() => [r(i, { icon: "el-icon-delete", size: "default", type: "danger" })]), _: 2 }, 1032, ["onConfirm"])) : f("", true)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSelectionChange"])), [[$, e(o).loading]]), r(e(te)), r(e(oe)), r(e(ne))]), _: 1 });
  };
} }, fe = X(se, [["__scopeId", "data-v-1f436dac"]]);
export {
  fe as default
};
