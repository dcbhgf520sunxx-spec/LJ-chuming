import { useStore as z } from "vuex";
import { ref as c } from "vue";
import { watch as G } from "vue";
import { computed as L } from "vue";
import { resolveComponent as O } from "vue";
import { resolveDirective as T } from "vue";
import { unref as r } from "vue";
import { openBlock as s } from "vue";
import { createBlock as p } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as g } from "vue";
import { createElementBlock as j } from "vue";
import { createTextVNode as m } from "vue";
import { createCommentVNode as f } from "vue";
import { withDirectives as k } from "vue";
import { createVNode as _ } from "vue";
import { ElRadioGroup as q } from "element-plus";
import { ElMessage as Y } from "element-plus";
import { ElRadio as A } from "element-plus";
import { ElFormItem as H } from "element-plus";
import { ElForm as J } from "element-plus";
import { ElCard as K } from "element-plus";
import { vLoading as Q } from "element-plus";
import { a as W } from "../../../../../modules/install-config-0f2e817e.js";
import { _ as X, mx as Z, i as $, G as v, tY as ee } from "../../../../../shared/runtime.js";
const te = { key: 0, style: { float: "right" } }, oe = { key: 1 }, ae = { __name: "project", props: { globalProject: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, setup(l) {
  const { projects: P } = Z(), w = { reportMethod: void 0 }, d = l, y = z(), x = c(), E = c(false), i = c(false), h = c(), o = c({ ...w });
  G(() => d.globalProject, async (t) => {
    var e, n;
    $(t) && (await y.dispatch("project/fetchUserProjects"), o.value.reportMethod = (n = (e = P.value) == null ? void 0 : e.find((u) => u.id === (t == null ? void 0 : t.id))) == null ? void 0 : n.installReportMethod, h.value = o.value.reportMethod);
  }, { immediate: true, deep: true });
  const C = L(() => o.value.reportMethod !== h.value);
  async function R() {
    var t;
    i.value = true;
    try {
      await W({ projectId: (t = d.globalProject) == null ? void 0 : t.id, reportMethod: o.value.reportMethod }), Y.success("修改成功"), V();
    } catch (e) {
      console.log("设置填报方式", e);
    } finally {
      i.value = false;
    }
  }
  async function V() {
    try {
      await y.dispatch("project/fetchUserProjects"), await y.dispatch("project/setProjectId", d.globalProject.id);
    } catch (t) {
      console.log(t);
    }
  }
  function B() {
    var t;
    o.value.reportMethod = (t = d.globalProject) == null ? void 0 : t.installReportMethod;
  }
  return (t, e) => {
    const n = O("common-button"), u = A, F = H, I = J, N = K, D = T("empty-text"), S = Q;
    return r(v)(l.permission.get) ? (s(), p(N, { key: 0, class: "box-card", shadow: "" }, { header: a(() => [e[3] || (e[3] = g("span", { class: "title" }, "上报模式", -1)), C.value ? (s(), j("div", te, [r(v)(l.permission.cancelEdit) ? (s(), p(n, { key: 0, size: "default", type: "warning", onClick: B }, { default: a(() => e[1] || (e[1] = [m("取消修改")])), _: 1, __: [1] })) : f("", true), r(v)(l.permission.save) ? (s(), p(n, { key: 1, loading: i.value, size: "default", type: "success", onClick: R }, { default: a(() => e[2] || (e[2] = [m("保存")])), _: 1, __: [2] }, 8, ["loading"])) : f("", true)])) : f("", true)]), default: a(() => [k((s(), j("div", null, [_(I, { ref_key: "projectFormRef", ref: x, model: o.value }, { default: a(() => [_(F, { label: "选项", prop: "reportMethod" }, { default: a(() => {
      var M, b;
      return [r(v)(l.permission.edit) ? (s(), p(r(q), { key: 0, modelValue: o.value.reportMethod, "onUpdate:modelValue": e[0] || (e[0] = (U) => o.value.reportMethod = U) }, { default: a(() => [_(u, { value: 0 }, { default: a(() => e[4] || (e[4] = [m(" 项目部自报模式 "), g("span", { style: { color: "red" } }, "（选择此模式，安装填报由项目部管理人员通过PC端对安装数据进行填报） ", -1)])), _: 1, __: [4] }), _(u, { value: 1 }, { default: a(() => e[5] || (e[5] = [m(" 劳务单位填报模式 "), g("span", { style: { color: "red" } }, "（选择此模式，安装填报由劳务班组通过小程序进行安装数据的填报，且需要项目部审核方为有效安装）", -1)])), _: 1, __: [5] })]), _: 1 }, 8, ["modelValue"])) : k((s(), j("span", oe, null, 512)), [[D, (b = (M = r(ee)) == null ? void 0 : M[o.value.reportMethod]) == null ? void 0 : b.V]])];
    }), _: 1 })]), _: 1 }, 8, ["model"])])), [[S, E.value || i.value]])]), _: 1 })) : f("", true);
  };
} }, ne = X(ae, [["__scopeId", "data-v-080113a7"]]);
export {
  ne as default
};
