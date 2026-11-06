import { useStore as le } from "vuex";
import { ref as r } from "vue";
import { resolveComponent as f } from "vue";
import { openBlock as p } from "vue";
import { createBlock as V } from "vue";
import { withCtx as d } from "vue";
import { createVNode as a } from "vue";
import { unref as l } from "vue";
import { createTextVNode as k } from "vue";
import { ElRadioGroup as oe } from "element-plus";
import { createElementBlock as I } from "vue";
import { Fragment as v } from "vue";
import { renderList as w } from "vue";
import { toDisplayString as te } from "vue";
import { createCommentVNode as ae } from "vue";
import { ElInput as de } from "element-plus";
import { ElFormItem as ne } from "element-plus";
import { ElInputNumber as ue } from "element-plus";
import { ElPopover as se } from "element-plus";
import { ElRadio as re } from "element-plus";
import { ElOption as ie } from "element-plus";
import { ElSelect as me } from "element-plus";
import { ElForm as pe } from "element-plus";
import { r as fe } from "../../../../modules/role-8519830b.js";
import { j as be } from "../../../../modules/job-fc547e81.js";
import { _ as ce, m as _e, u7 as N, aS as j, ao as ge, i as Ve, G as Ie, xf as h, v as ve } from "../../../../shared/runtime.js";
import { m as ye } from "../../../../modules/tree-select-86c0f12c.js";
const Ue = { __name: "form", props: { deptTree: { type: Array, default: () => [] } }, setup(R) {
  const { user: A } = _e(["user"]), y = le(), C = r({ key: "id", value: "id", label: "name" }), U = r(), M = r(), O = r(), b = r(false), c = r([]), x = r([]), T = r(false), F = r(false), P = r({}), S = R, B = { id: void 0, username: void 0, name: void 0, sex: N.MALE.V, email: void 0, roles: [], roleIds: [], jobId: void 0, deptId: void 0, deptName: void 0, phone: void 0, sort: 1, enabled: j.TRUE.V, oaSubDeptId: void 0, oaSubDeptName: void 0, oaDeptId: void 0, oaUserId: void 0 }, { CRUD: E, crud: i, form: t } = ge(B, U), L = { username: [{ required: true, message: "请填写员工编号", trigger: "blur" }, { pattern: h.pattern, message: h.message, trigger: "blur" }], name: [{ required: true, message: "请填写用户姓名", trigger: "blur" }, { min: 2, max: 20, message: "长度在 2 到 20 个字符", trigger: "blur" }], email: [{ type: "email", message: "请填写正确的邮箱地址", trigger: "blur" }], phone: [{ required: true, message: "请填写手机号", trigger: "blur" }, { pattern: ve, message: "请填写正确的手机号", trigger: "blur" }], sort: [{ required: true, message: "请填写序号", trigger: "blur", type: "number" }] };
  function q(n) {
    P.value = n, t.deptId = n.id, t.deptName = n.name, _(n.id), b.value = false;
  }
  z();
  async function z() {
    try {
      const { content: n } = await fe();
      x.value = n;
    } catch (n) {
      console.log("获取角色", n);
    }
  }
  _();
  async function _(n) {
    c.value = [];
    try {
      const e = { deptId: n }, { content: m } = await be(e);
      m.findIndex((u) => u.id === t.jobId) === -1 && (t.jobId = void 0), c.value = m;
    } catch (e) {
      console.log("获取角色", e);
    }
  }
  let g = [];
  function D(n) {
    n.forEach((e) => {
      g.push(e), e.children && e.children.length > 0 && D(e.children);
    });
  }
  E.HOOK.afterToEdit = (n, e) => {
    if (e.roleIds = e.roles.map((m) => m.id), e.jobId = e.job && e.job.id, e.deptId = e.dept && e.dept.id, Ve(e.deptId)) {
      _(e.deptId), g = [], D(S.deptTree);
      const m = g.find((s) => s.id === e.deptId);
      e.deptName = m.name;
    }
  };
  async function G() {
    try {
      await y.dispatch("config/fetchUsers"), await y.dispatch("config/fetchUserDeptTree");
    } catch (n) {
      console.log(n);
    }
  }
  return E.HOOK.afterSubmit = () => {
    G();
  }, (n, e) => {
    const m = f("common-button"), s = de, u = ne, H = ue, K = se, J = f("common-select-v2"), Q = f("common-radio"), $ = re, W = ie, X = me, Y = pe, Z = f("common-dialog");
    return p(), V(Z, { "before-close": l(i).cancelCU, "close-on-click-modal": false, title: l(i).status.title, visible: l(i).status.cu > 0, "append-to-body": "", width: "800px" }, { titleRight: d(() => [a(m, { loading: l(i).status.cu === 2, size: "default", type: "primary", onClick: l(i).submitCU }, { default: d(() => e[15] || (e[15] = [k("确认 ")])), _: 1, __: [15] }, 8, ["loading", "onClick"])]), default: d(() => [a(Y, { ref_key: "formRef", ref: U, inline: true, model: l(t), rules: L, "label-width": "120px", size: "default" }, { default: d(() => [a(u, { label: "员工编号", prop: "username" }, { default: d(() => [a(s, { modelValue: l(t).username, "onUpdate:modelValue": e[0] || (e[0] = (o) => l(t).username = o) }, null, 8, ["modelValue"])]), _: 1 }), a(u, { label: "电话", prop: "phone" }, { default: d(() => [a(s, { modelValue: l(t).phone, "onUpdate:modelValue": e[1] || (e[1] = (o) => l(t).phone = o), modelModifiers: { number: true } }, null, 8, ["modelValue"])]), _: 1 }), a(u, { label: "姓名", prop: "name" }, { default: d(() => [a(s, { modelValue: l(t).name, "onUpdate:modelValue": e[2] || (e[2] = (o) => l(t).name = o) }, null, 8, ["modelValue"])]), _: 1 }), a(u, { label: "邮箱", prop: "email" }, { default: d(() => [a(s, { modelValue: l(t).email, "onUpdate:modelValue": e[3] || (e[3] = (o) => l(t).email = o) }, null, 8, ["modelValue"])]), _: 1 }), a(u, { label: "排序", prop: "sort" }, { default: d(() => [a(H, { modelValue: l(t).sort, "onUpdate:modelValue": e[4] || (e[4] = (o) => l(t).sort = o), modelModifiers: { number: true }, max: 999999999, min: 0, "controls-position": "right", style: { width: "460px" } }, null, 8, ["modelValue"])]), _: 1 }), a(u, { label: "部门", prop: "deptId" }, { default: d(() => [a(K, { ref_key: "menuPopover", ref: M, visible: b.value, "onUpdate:visible": e[6] || (e[6] = (o) => b.value = o), placement: "bottom-start", trigger: "click", width: "460" }, { reference: d(() => [a(s, { modelValue: l(t).deptName, "onUpdate:modelValue": e[5] || (e[5] = (o) => l(t).deptName = o), placeholder: "点击选择所属部门", readonly: "", style: { width: "460px" } }, null, 8, ["modelValue"])]), default: d(() => [a(ye, { ref_key: "menuSelectRef", ref: O, defaultProps: { children: "children", label: "name" }, pid: l(t).deptId, treeMenu: S.deptTree, style: { width: "400px" }, onSelected: q }, null, 8, ["pid", "treeMenu"])]), _: 1 }, 8, ["visible"])]), _: 1 }), a(u, { label: "岗位", prop: "jobId" }, { default: d(() => [a(J, { modelValue: l(t).jobId, "onUpdate:modelValue": e[7] || (e[7] = (o) => l(t).jobId = o), "data-structure": C.value, loading: F.value, options: c.value, clearable: "", placeholder: "请先选择岗位", style: { width: "185px" }, type: "other" }, null, 8, ["modelValue", "data-structure", "loading", "options"])]), _: 1 }), a(u, { label: "性别" }, { default: d(() => [a(Q, { modelValue: l(t).sex, "onUpdate:modelValue": e[8] || (e[8] = (o) => l(t).sex = o), options: l(N).ENUM, type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), a(u, { label: "状态" }, { default: d(() => [a(l(oe), { modelValue: l(t).enabled, "onUpdate:modelValue": e[9] || (e[9] = (o) => l(t).enabled = o), disabled: !l(Ie)(l(i).permission.edit) || l(t).id === l(A).id || l(i).form.userType === 1, style: { width: "178px" } }, { default: d(() => [(p(true), I(v, null, w(l(j).ENUM, (o) => (p(), V($, { key: o.V, value: o.V }, { default: d(() => [k(te(o.L), 1)]), _: 2 }, 1032, ["value"]))), 128))]), _: 1 }, 8, ["modelValue", "disabled"])]), _: 1 }), a(u, { label: "角色", prop: "roles" }, { default: d(() => [a(X, { modelValue: l(t).roleIds, "onUpdate:modelValue": e[10] || (e[10] = (o) => l(t).roleIds = o), loading: T.value.value, multiple: "", placeholder: "请选择", filterable: "", style: { width: "460px" } }, { default: d(() => [(p(true), I(v, null, w(x.value, (o, ee) => (p(), V(W, { key: `${ee}`, disabled: o.id === 1, label: o.name, value: o.id }, null, 8, ["disabled", "label", "value"]))), 128))]), _: 1 }, 8, ["modelValue", "loading"])]), _: 1 }), l(i).status.edit > 0 ? (p(), I(v, { key: 0 }, [a(u, { label: "OA分部门id", prop: "oaSubDeptId" }, { default: d(() => [a(s, { modelValue: l(t).oaSubDeptId, "onUpdate:modelValue": e[11] || (e[11] = (o) => l(t).oaSubDeptId = o) }, null, 8, ["modelValue"])]), _: 1 }), a(u, { label: "OA分部门名称", prop: "oaSubDeptName" }, { default: d(() => [a(s, { modelValue: l(t).oaSubDeptName, "onUpdate:modelValue": e[12] || (e[12] = (o) => l(t).oaSubDeptName = o), style: { width: "320px" } }, null, 8, ["modelValue"])]), _: 1 }), a(u, { label: "OA部门id", prop: "oaDeptId" }, { default: d(() => [a(s, { modelValue: l(t).oaDeptId, "onUpdate:modelValue": e[13] || (e[13] = (o) => l(t).oaDeptId = o) }, null, 8, ["modelValue"])]), _: 1 }), a(u, { label: "OA人员id", prop: "oaUserId" }, { default: d(() => [a(s, { modelValue: l(t).oaUserId, "onUpdate:modelValue": e[14] || (e[14] = (o) => l(t).oaUserId = o), style: { width: "320px" } }, null, 8, ["modelValue"])]), _: 1 })], 64)) : ae("", true)]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "title", "visible"]);
  };
} }, Ne = ce(Ue, [["__scopeId", "data-v-76f58a5e"]]);
export {
  Ne as default
};
