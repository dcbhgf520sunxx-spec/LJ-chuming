import { ref as c } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as S } from "vue";
import { createElementVNode as s } from "vue";
import { createVNode as d } from "vue";
import { unref as t } from "vue";
import { withDirectives as F } from "vue";
import { createBlock as i } from "vue";
import { withCtx as r } from "vue";
import { createCommentVNode as u } from "vue";
import { toDisplayString as x } from "vue";
import { createTextVNode as I } from "vue";
import { Fragment as Z } from "vue";
import { renderList as ee } from "vue";
import { ElMessageBox as te } from "element-plus";
import { nextTick as le } from "vue";
import { ElMessage as ae } from "element-plus";
import { ElTableColumn as oe } from "element-plus";
import { ElSwitch as ne } from "element-plus";
import { ElTree as se } from "element-plus";
import { ElCol as ie } from "element-plus";
import { ElRow as re } from "element-plus";
import { vLoading as de } from "element-plus";
import { c as ce, e as ue, s as pe, g as me } from "../../../modules/job-fc547e81.js";
import { x as be, o as fe, x9 as H, cB as h, G as j, an as he, P as _e, xa as ye } from "../../../shared/runtime.js";
import { j as _ } from "../../../modules/user-2de6904c.js";
import ve from "./module/header.vue.js";
import ge from "./module/form.vue.js";
import "../../../modules/dept-398bb184.js";
import "../../../modules/tree-select-86c0f12c.js";
const xe = { class: "app-container" }, ke = { class: "head-container" }, we = { class: "user-tree tree-container" }, Ce = { style: { display: "flex" } }, Ve = { class: "el-form-item__content", style: { "line-height": "36px" } }, Ee = { style: { display: "flex" } }, Te = { class: "el-form-item__content", style: { "line-height": "36px" } }, Ne = { style: { display: "flex" } }, Se = { key: 1, class: "el-form-item__content", style: { "line-height": "36px" } }, Pe = { __name: "index", setup(Ie) {
  const U = c(), k = c(false), V = c([]), y = c([]), w = c(), E = c(false), L = c({}), p = c({}), C = c(false), A = { children: "children", label: "userName" }, P = { add: true, del: false }, { crud: v, columns: m, CRUD: M } = be({ title: "岗位", sort: [], optShow: { ...P }, permission: { ..._ }, crudApi: { ...ce }, hasPagination: true }, U), { maxHeight: O } = fe({ paginate: true });
  function T(o) {
    return o.jobType === H.OUTSIDE_THE_ESTABLISHMENT.V;
  }
  async function z(o, l) {
    try {
      await te.confirm('此操作将 "' + h.VL[l] + '" ' + o.name + ", 是否继续？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" });
      const e = { id: o.id, enabled: o.enabled };
      await ue(e), v.refresh(), v.notify(h.VL[l] + "成功", M.NOTIFICATION_TYPE.SUCCESS);
    } catch (e) {
      console.log("变更岗位状态", e, l), o.enabled = o.enabled === h.TRUE.V ? h.FALSE.V : h.TRUE.V;
    }
  }
  async function J(o) {
    var l;
    L.value = o, V.value = [];
    try {
      const e = await ye({ deptId: o.deptId, jobId: o.id }), b = {};
      b.userName = "<部门>" + (e == null ? void 0 : e.deptName), b.userId = "01_" + (e == null ? void 0 : e.id), b.children = [], b.children.push({ userName: "<岗位>" + (e == null ? void 0 : e.jobName), userId: "02_" + (e == null ? void 0 : e.jobId), children: e.userList }), V.value.push(b), ((l = e.userList) == null ? void 0 : l.length) > 0 && e.userList.map((g) => {
        g.jobId === e.jobId && y.value.push(g.userId);
      }), k.value = true, le(() => {
        w.value.setCheckedKeys(y.value);
      });
    } catch (e) {
      console.log("用户部门信息", e);
    }
  }
  function K() {
    y.value = [], w.value.setCheckedKeys(y.value), k.value = false;
  }
  function $() {
    C.value = false;
  }
  async function q() {
    try {
      E.value = true;
      let o = w.value.getCheckedKeys(true);
      o = o.filter((l) => l > 0), await pe({ jobId: L.value.id, userIds: o }), y.value = o, ae({ message: "人员配置成功", type: "success" }), k.value = false;
    } catch (o) {
      console.log("人员配置", o);
    } finally {
      E.value = false;
    }
  }
  async function G(o) {
    p.value = {};
    try {
      const l = await me({ jobId: o.id }) || {};
      p.value = l, p.value.deptName = l.deptName || o.deptName, p.value.jobName = l.jobName || o.name, C.value = true;
    } catch (l) {
      console.log("岗位人员设置", l);
    }
  }
  return (o, l) => {
    const e = oe, b = ne, g = N("common-button"), Y = N("common-table"), Q = se, B = N("common-dialog"), W = ie, X = re, R = de;
    return n(), S("div", xe, [s("div", ke, [d(t(ve), { ref: "header", permission: t(_) }, null, 8, ["permission"])]), F((n(), i(Y, { ref_key: "tableRef", ref: U, data: t(v).data, "empty-text": t(v).emptyText, "max-height": t(O), style: { width: "100%" }, "row-key": "id", onSelectionChange: t(v).selectionChangeHandler }, { default: r(() => [d(e, { type: "selection", width: "55", align: "center" }), d(e, { label: "序号", type: "index", align: "center", width: "60" }), t(m).visible("name") ? (n(), i(e, { key: "name", prop: "name", label: "名称" })) : u("", true), t(m).visible("positionCode") ? (n(), i(e, { key: "positionCode", prop: "positionCode", label: "SHR岗位编号", align: "center" })) : u("", true), t(m).visible("dept") ? (n(), i(e, { key: "dept", prop: "dept", label: "所属部门" }, { default: r((a) => [s("div", null, x(a.row.deptName), 1)]), _: 1 })) : u("", true), t(m).visible("orgCode") ? (n(), i(e, { key: "orgCode", prop: "orgCode", label: "SHR部门编号", align: "center" })) : u("", true), t(m).visible("jobType") ? (n(), i(e, { key: "jobType", prop: "jobType", label: "岗位类型", align: "center" }, { default: r(({ row: a }) => [I(x(t(H).VL[a.jobType]), 1)]), _: 1 })) : u("", true), t(m).visible("sort") ? (n(), i(e, { key: "sort", prop: "sort", label: "排序", align: "center" }, { default: r((a) => [I(x(a.row.sort), 1)]), _: 1 })) : u("", true), t(m).visible("enabled") ? (n(), i(e, { key: "enabled", prop: "enabled", label: "状态", align: "center" }, { default: r((a) => [d(b, { modelValue: a.row.enabled, "onUpdate:modelValue": (f) => a.row.enabled = f, "active-color": "#409EFF", "inactive-color": "#F56C6C", "active-value": t(h).TRUE.V, "inactive-value": t(h).FALSE.V, disabled: !t(j)(t(_).edit) || !T(a.row), onChange: (f) => z(a.row, a.row.enabled) }, null, 8, ["modelValue", "onUpdate:modelValue", "active-value", "inactive-value", "disabled", "onChange"])]), _: 1 })) : u("", true), d(e, { label: "人员设置", align: "center" }, { default: r((a) => [t(j)(t(_).edit) ? (n(), i(g, { key: 0, size: "default", icon: "el-icon-edit", type: "primary", onClick: (f) => J(a.row) }, null, 8, ["onClick"])) : u("", true), d(g, { size: "default", icon: "el-icon-view", type: "primary", onClick: (f) => G(a.row) }, null, 8, ["onClick"])]), _: 1 }), t(j)([...t(_).edit, ...t(_).del]) ? (n(), i(e, { key: 7, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: r((a) => [d(t(he), { "disabled-del": !T(a.row), "disabled-edit": !T(a.row), data: a.row, permission: t(_) }, null, 8, ["disabled-del", "disabled-edit", "data", "permission"])]), _: 1 })) : u("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSelectionChange"])), [[R, t(v).loading]]), d(B, { "append-to-body": "", modelValue: k.value, "onUpdate:modelValue": l[0] || (l[0] = (a) => k.value = a), top: "10vh", width: "480px", title: "人员配置", center: false, "before-close": K, "close-on-click-modal": false }, { titleRight: r(() => [F((n(), i(g, { type: "primary", size: "default", onClick: q }, { default: r(() => l[2] || (l[2] = [I("提交")])), _: 1, __: [2] })), [[R, E.value]])]), default: r(() => [s("div", null, [s("div", we, [d(Q, { ref_key: "tree", ref: w, class: "filter-tree", data: V.value, "empty-text": "没有用户", props: A, "default-expand-all": "", "show-checkbox": "", "node-key": "userId", "default-checked-keys": y.value }, null, 8, ["data", "default-checked-keys"])])])]), _: 1 }, 8, ["modelValue"]), d(B, { "append-to-body": "", modelValue: C.value, "onUpdate:modelValue": l[1] || (l[1] = (a) => C.value = a), top: "10vh", width: "480px", title: "已配置人员", center: false, "before-close": $, "close-on-click-modal": false }, { default: r(() => {
      var a, f;
      return [s("div", null, [s("div", Ce, [l[3] || (l[3] = s("span", { class: "el-form-item__label", style: { "text-align": "right", width: "90px", "line-height": "36px" } }, "部门:", -1)), s("span", Ve, x(p.value.deptName), 1)]), s("div", Ee, [l[4] || (l[4] = s("span", { class: "el-form-item__label", style: { "text-align": "right", width: "90px", "line-height": "36px" } }, "岗位:", -1)), s("span", Te, x(p.value.jobName), 1)]), s("div", Ne, [l[5] || (l[5] = s("span", { class: "el-form-item__label", style: { "text-align": "right", width: "90px", "line-height": "36px" } }, "人员:", -1)), ((f = (a = p.value) == null ? void 0 : a.userList) == null ? void 0 : f.length) > 0 ? (n(), i(X, { key: 0, class: "el-form-item__content", style: { "line-height": "36px" } }, { default: r(() => [(n(true), S(Z, null, ee(p.value.userList, (D) => (n(), i(W, { span: 5, key: D.userId }, { default: r(() => [s("span", null, x(D.userName), 1)]), _: 2 }, 1024))), 128))]), _: 1 })) : (n(), S("span", Se, "-"))])])];
    }), _: 1 }, 8, ["modelValue"]), d(t(_e)), d(t(ge))]);
  };
} };
export {
  Pe as default
};
