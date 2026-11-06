import { ref as _ } from "vue";
import { reactive as W } from "vue";
import { provide as X } from "vue";
import { watch as Z } from "vue";
import { resolveComponent as B } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as g } from "vue";
import { createElementVNode as f } from "vue";
import { createVNode as c } from "vue";
import { normalizeStyle as ee } from "vue";
import { unref as e } from "vue";
import { withDirectives as I } from "vue";
import { createBlock as i } from "vue";
import { withCtx as m } from "vue";
import { toDisplayString as T } from "vue";
import { createCommentVNode as d } from "vue";
import { createTextVNode as te } from "vue";
import { Fragment as O } from "vue";
import { renderList as oe } from "vue";
import { ElMessageBox as N } from "element-plus";
import { ElInput as ae } from "element-plus";
import { ElTree as ne } from "element-plus";
import { ElTableColumn as re } from "element-plus";
import { ElOption as le } from "element-plus";
import { ElSelect as ie } from "element-plus";
import { ElSwitch as se } from "element-plus";
import { vLoading as de } from "element-plus";
import { c as ue, e as ce, a as pe, r as me } from "../../../modules/user-322fe2e0.js";
import { u as h } from "../../../modules/user-2de6904c.js";
import { _ as fe, m as he, x as we, o as _e, i as ye, u7 as be, G as x, aS as y, xe as w, an as ge, P as Te } from "../../../shared/runtime.js";
import xe from "./module/header.vue.js";
import ve from "./module/form.vue.js";
import { d as Ce } from "../../../modules/dept-398bb184.js";
import Ve from "./module/record/index.vue.js";
import "../../../modules/ExcelUploadBtn-acccae97.js";
import "./module/password-strategy.vue.js";
import "../../../modules/password-validation-8d186430.js";
import "../../../modules/role-8519830b.js";
import "../../../modules/job-fc547e81.js";
import "../../../modules/tree-select-86c0f12c.js";
import "./module/record/header.vue.js";
const ke = { class: "app-container wrap" }, Se = { class: "wrap-left" }, Ee = { class: "head-container" }, Ne = { style: { padding: "3px 5px", "border-radius": "3px", width: "100%" } }, Ue = { style: { "font-weight": "bold" } }, Re = { class: "wrap-right" }, Pe = { key: 1 }, Be = { __name: "index", setup(Ie) {
  const A = { add: true, edit: false, del: true, download: false }, { user: D } = he(["user"]), U = _(), { crud: s, columns: p, CRUD: b } = we({ title: "用户", optShow: { ...A }, permission: { ...h }, crudApi: { ...ue }, hasPagination: true, props: { recordVisible: false } }, U), { maxHeight: R } = _e({ wrapperBox: ".user", paginate: true, extraHeight: 90 }), v = _(), C = _(), V = _([]), k = _({}), L = { children: "children", label: "name" }, S = W({ data: false }), $ = (o, n) => o.userType !== 1;
  X("currentNode", k), Z(C, (o) => {
    v.value.filter(o);
  }), F();
  async function F() {
    try {
      S.data = true, V.value = await Ce({ hasRoot: true });
    } catch (o) {
      console.log("部门tree", o);
    } finally {
      S.data = false;
    }
  }
  function M(o, n) {
    return o ? n.name.includes(o) : true;
  }
  function H(o) {
    k.value = o, v.value.setCurrentKey(k.value.id, true), s.query.deptId = o.id, s.toQuery();
  }
  async function j(o, n) {
    try {
      await N.confirm('此操作将 "' + y.VL[n] + '" ' + o.name + ", 是否继续？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" });
      const r = { id: o.id, enabled: o.enabled };
      await ce(r), s.refresh(), s.notify(y.VL[n] + "成功", b.NOTIFICATION_TYPE.SUCCESS);
    } catch (r) {
      console.log("变更用户状态", r), o.enabled = !n;
    }
  }
  async function z(o, n) {
    try {
      await N.confirm(`此操作将把 “${o.name}” 人员类型更改为 “${w.VL[n]}”, 是否继续？`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await pe({ userId: o.id }), s.notify(`“${o.name}” 人员类型变更为 “${w.VL[n]}” 成功`, b.NOTIFICATION_TYPE.SUCCESS), s.refresh();
    } catch (r) {
      console.log(r), o.userType = o.originUserType;
    }
  }
  async function J(o) {
    await N.confirm(`此操作将【${o.name}】重置密码为默认密码, 是否继续？`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await me(o.id), s.notify("重置密码成功", b.NOTIFICATION_TYPE.SUCCESS);
  }
  return b.HOOK.handleRefresh = (o, n) => {
    n.data.content = n.data.content.map((r) => {
      const E = r.dept ? r.dept.name : "", l = r.job ? r.job.name : "";
      return r.deptAndJob = `${E} / ${l}`, r.originUserType = r.userType, r;
    });
  }, (o, n) => {
    const r = ae, E = ne, l = re, Y = le, G = ie, q = se, K = B("common-button"), Q = B("common-table"), P = de;
    return a(), g("div", ke, [f("div", Se, [f("div", Ee, [c(r, { modelValue: C.value, "onUpdate:modelValue": n[0] || (n[0] = (t) => C.value = t), modelModifiers: { trim: true }, size: "default", clearable: "", placeholder: "输入部门名称搜索" }, null, 8, ["modelValue"])]), f("div", { style: ee(`max-height: ${e(R) + 50}px; overflow: auto;`) }, [I((a(), i(E, { ref_key: "treeMenuRef", ref: v, data: V.value, props: L, "filter-node-method": M, "highlight-current": "", "expand-on-click-node": false, "default-expand-all": true, "node-key": "id", onNodeClick: H }, { default: m(({ node: t }) => [f("div", Ne, [f("span", Ue, T(t.label), 1)])]), _: 1 }, 8, ["data"])), [[P, S.data]])], 4)]), f("div", Re, [c(e(xe), { id: "header", ref: "header" }, null, 512), I((a(), i(Q, { ref_key: "tableRef", ref: U, data: e(s).data, "empty-text": e(s).emptyText, "max-height": e(R), style: { width: "100%", "margin-left": "20px" }, onSelectionChange: e(s).selectionChangeHandler }, { default: m(() => [c(l, { type: "selection", width: "55", align: "center", selectable: $ }), c(l, { label: "序号", type: "index", align: "center", width: "60" }), e(p).visible("username") ? (a(), i(l, { key: "username", prop: "username", "show-overflow-tooltip": true, width: "140", label: "员工编号" })) : d("", true), e(p).visible("userCode") ? (a(), i(l, { key: "userCode", prop: "userCode", "show-overflow-tooltip": true, width: "140", label: "SHR员工编号" })) : d("", true), e(p).visible("name") ? (a(), i(l, { key: "name", prop: "name", "show-overflow-tooltip": true, width: "100", label: "姓名" })) : d("", true), e(p).visible("sort") ? (a(), i(l, { key: "sort", prop: "sort", label: "排序", align: "center", width: "100" }, { default: m((t) => [te(T(t.row.sort), 1)]), _: 1 })) : d("", true), e(p).visible("sex") ? (a(), i(l, { key: "sex", prop: "sex", label: "性别", width: "100", align: "center" }, { default: m((t) => [f("span", null, T(e(ye)(t.row.sex) ? e(be).VL[t.row.sex] : ""), 1)]), _: 1 })) : d("", true), e(p).visible("phone") ? (a(), i(l, { key: "phone", prop: "phone", "show-overflow-tooltip": true, width: "140", label: "电话" })) : d("", true), e(p).visible("email") ? (a(), i(l, { key: "email", prop: "email", "show-overflow-tooltip": true, "min-width": "170", label: "邮箱" })) : d("", true), e(p).visible("deptAndJob") ? (a(), i(l, { key: "deptAndJob", prop: "deptAndJob", "show-overflow-tooltip": true, "min-width": "140", label: "部门 / 岗位" })) : d("", true), e(p).visible("userType") ? (a(), i(l, { key: "userType", prop: "userType", label: "人员类型", align: "center", "min-width": "110" }, { default: m((t) => [e(x)(e(h).edit) && t.row.enabled === e(y).FALSE.V && t.row.userType === e(w).ORDINARY_PERSONNEL.V ? (a(), i(G, { key: 0, modelValue: t.row.userType, "onUpdate:modelValue": (u) => t.row.userType = u, size: "default", onChange: (u) => z(t.row, t.row.userType) }, { default: m(() => [(a(true), g(O, null, oe(e(w).ENUM, (u) => (a(), g(O, { key: u.V }, [u.V !== e(w).SUBCONTRACTING_PERSONNEL.V ? (a(), i(Y, { key: 0, label: u.L, value: u.V }, null, 8, ["label", "value"])) : d("", true)], 64))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "onChange"])) : (a(), g("span", Pe, T(e(w).VL[t.row.userType]), 1))]), _: 1 })) : d("", true), c(l, { key: "enabled", prop: "enabled", label: "状态", align: "center" }, { default: m((t) => [c(q, { modelValue: t.row.enabled, "onUpdate:modelValue": (u) => t.row.enabled = u, "active-color": "#409EFF", "inactive-color": "#F56C6C", "active-value": e(y).TRUE.V, "inactive-value": e(y).FALSE.V, disabled: !e(x)(e(h).edit) || t.row.id === e(D).id || t.row.userType === 1, onChange: (u) => j(t.row, t.row.enabled) }, null, 8, ["modelValue", "onUpdate:modelValue", "active-value", "inactive-value", "disabled", "onChange"])]), _: 1 }), e(x)(e(h).resetToDefaultPwd) ? (a(), i(l, { key: "resetToDefaultPwd", prop: "resetToDefaultPwd", label: "重置密码", align: "center", width: "80" }, { default: m((t) => [c(K, { type: "warning", size: "default", icon: "el-icon-refresh", onClick: (u) => J(t.row) }, null, 8, ["onClick"])]), _: 1 })) : d("", true), e(x)([...e(h).edit, ...e(h).del]) ? (a(), i(l, { key: 10, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: m((t) => [c(ge, { data: t.row, permission: e(h), "show-del": t.row.userType !== 1 }, null, 8, ["data", "permission", "show-del"])]), _: 1 })) : d("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSelectionChange"])), [[P, e(s).loading]]), c(e(Te), { style: { "margin-left": "20px" } })]), c(e(ve), { "dept-tree": V.value }, null, 8, ["dept-tree"]), c(Ve, { modelValue: e(s).props.recordVisible, "onUpdate:modelValue": n[1] || (n[1] = (t) => e(s).props.recordVisible = t) }, null, 8, ["modelValue"])]);
  };
} }, Xe = fe(Be, [["__scopeId", "data-v-8dc446ac"]]);
export {
  Xe as default
};
