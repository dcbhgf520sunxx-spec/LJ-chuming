import { useStore as z } from "vuex";
import { ref as c } from "vue";
import { watch as A } from "vue";
import { computed as G } from "vue";
import { resolveComponent as L } from "vue";
import { resolveDirective as T } from "vue";
import { unref as s } from "vue";
import { openBlock as n } from "vue";
import { createBlock as y } from "vue";
import { withCtx as o } from "vue";
import { createElementVNode as u } from "vue";
import { createElementBlock as _ } from "vue";
import { createVNode as r } from "vue";
import { createTextVNode as i } from "vue";
import { createCommentVNode as P } from "vue";
import { withDirectives as b } from "vue";
import { ElRadioGroup as U } from "element-plus";
import { ElMessage as q } from "element-plus";
import { ElRadio as O } from "element-plus";
import { ElFormItem as Y } from "element-plus";
import { ElForm as H } from "element-plus";
import { ElCard as J } from "element-plus";
import { vLoading as K } from "element-plus";
import { a as Q } from "../../../../modules/install-config-0f2e817e.js";
import { _ as W, i as X, G as m, tY as Z } from "../../../../shared/runtime.js";
import { j as $ } from "../../../../modules/project-19a12d6b.js";
const ee = { key: 0, style: { float: "right" } }, te = { key: 1 }, oe = { __name: "project", props: { globalProject: { type: Object, default: () => {
} } }, setup(M) {
  const p = $.reportMethod, k = { reportMethod: void 0 }, l = M, f = z(), C = c(), w = c(false), d = c(false), a = c({ ...k });
  A(() => l.globalProject.installReportMethod, (t) => {
    var e;
    X(t) && (a.value.reportMethod = (e = l.globalProject) == null ? void 0 : e.installReportMethod);
  }, { immediate: true, deep: true });
  const x = G(() => {
    var t;
    return a.value.reportMethod !== ((t = l.globalProject) == null ? void 0 : t.installReportMethod);
  });
  async function R() {
    var t;
    d.value = true;
    try {
      await Q({ projectId: (t = l.globalProject) == null ? void 0 : t.id, reportMethod: a.value.reportMethod }), q.success("修改成功"), E();
    } catch (e) {
      console.log("设置填报方式", e);
    } finally {
      d.value = false;
    }
  }
  async function E() {
    try {
      await f.dispatch("project/fetchUserProjects"), await f.dispatch("project/setProjectId", l.globalProject.id);
    } catch (t) {
      console.log(t);
    }
  }
  function V() {
    var t;
    a.value.reportMethod = (t = l.globalProject) == null ? void 0 : t.installReportMethod;
  }
  return (t, e) => {
    const v = L("common-button"), g = O, B = Y, F = H, I = J, N = T("empty-text"), D = K;
    return s(m)(s(p).get) ? (n(), y(I, { key: 0, class: "box-card", shadow: "" }, { header: o(() => [e[3] || (e[3] = u("span", { class: "title" }, "填报方式", -1)), s(m)(s(p).edit) && x.value ? (n(), _("div", ee, [r(v, { size: "default", type: "warning", onClick: V }, { default: o(() => e[1] || (e[1] = [i("取消修改")])), _: 1, __: [1] }), r(v, { loading: d.value, size: "default", type: "success", onClick: R }, { default: o(() => e[2] || (e[2] = [i("保存")])), _: 1, __: [2] }, 8, ["loading"])])) : P("", true)]), default: o(() => [b((n(), _("div", null, [r(F, { ref_key: "projectFormRef", ref: C, model: a.value }, { default: o(() => [r(B, { label: "填报方式", prop: "reportMethod" }, { default: o(() => {
      var h, j;
      return [s(m)(s(p).edit) ? (n(), y(s(U), { key: 0, modelValue: a.value.reportMethod, "onUpdate:modelValue": e[0] || (e[0] = (S) => a.value.reportMethod = S) }, { default: o(() => [r(g, { value: 1 }, { default: o(() => e[4] || (e[4] = [i("APP填报 "), u("span", { style: { color: "red" } }, "（选择APP填报，PC端：安装管理>安装填报将无法使用）", -1)])), _: 1, __: [4] }), r(g, { value: 0 }, { default: o(() => e[5] || (e[5] = [i("PC端填报 "), u("span", { style: { color: "red" } }, "（选择PC填报，APP端：劳务分包单位将无法填报）", -1)])), _: 1, __: [5] })]), _: 1 }, 8, ["modelValue"])) : b((n(), _("span", te, null, 512)), [[N, (j = (h = s(Z)) == null ? void 0 : h[a.value.reportMethod]) == null ? void 0 : j.V]])];
    }), _: 1 })]), _: 1 }, 8, ["model"])])), [[D, w.value || d.value]])]), _: 1 })) : P("", true);
  };
} }, ne = W(oe, [["__scopeId", "data-v-b3e2fafa"]]);
export {
  ne as default
};
