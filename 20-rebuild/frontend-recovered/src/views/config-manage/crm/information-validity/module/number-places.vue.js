import { ref as i } from "vue";
import { computed as L } from "vue";
import { onMounted as U } from "vue";
import { resolveComponent as P } from "vue";
import { openBlock as j } from "vue";
import { createBlock as x } from "vue";
import { withCtx as s } from "vue";
import { createElementVNode as a } from "vue";
import { toDisplayString as w } from "vue";
import { unref as C } from "vue";
import { createTextVNode as m } from "vue";
import { createCommentVNode as F } from "vue";
import { createVNode as n } from "vue";
import { withModifiers as O } from "vue";
import { EditPen as T } from "@element-plus/icons-vue";
import { ElMessage as z } from "element-plus";
import { ElFormItem as A } from "element-plus";
import { ElIcon as J } from "element-plus";
import { ElForm as q } from "element-plus";
import { ElCard as G } from "element-plus";
import { G as c, dy as y, V as $ } from "../../../../../shared/runtime.js";
import { g as H, b as K, a as W } from "../../../../../modules/information-validity-6783e35a.js";
import X from "../component/custom-user-dialog.vue.js";
import "../../../../../modules/use-table-operate-4f84437f.js";
import "../../../../../modules/index-9d220fe1.js";
import "../../../../../modules/use-users-4d979987.js";
const Y = { class: "clearfix" }, Z = { class: "card-title" }, ee = { style: { display: "flex" } }, te = { style: { "margin-left": "60px" } }, oe = { style: { color: "#409eff" } }, me = { __name: "number-places", props: { permission: { type: Object, default: () => {
} } }, setup(b) {
  const f = b, E = i(0), d = i(false), u = i([]), N = i(), r = i({}), V = i({}), R = L(() => {
    let t = false;
    return r.value.projectQuota !== V.value.projectQuota ? t = false : t = true, t;
  }), p = i(false);
  U(() => {
    _(), h();
  });
  const k = { projectQuota: [{ required: true, message: "项目人员名额上限", trigger: "change" }] };
  async function _() {
    if (c(f.permission.getProjectNumberConfig)) try {
      const t = await H({ crmInformationValidityPeriodConfigEnum: y.PROJECT_NUMBER_PLACES.V });
      console.log(t), r.value = t[0], V.value = $(t[0]);
    } catch (t) {
      console.log(t);
    }
  }
  async function h() {
    var t;
    if (c(f.permission.getProjectNumberConfig)) try {
      const e = await K();
      u.value = e || [], u.value.forEach((l) => {
        var o;
        l.userNum = (o = l.userIds) == null ? void 0 : o.length;
      }), E.value = (t = u.value) == null ? void 0 : t.reduce((l, o) => o != null && o.userNum ? l + (o == null ? void 0 : o.userNum) : l, 0);
    } catch (e) {
      console.log(e, "获取自定义人员列表失败");
    }
  }
  async function B() {
    if (await N.value.validate()) try {
      p.value = true;
      const e = [];
      e.push(r.value), await W({ crmInformationValidityPeriodConfigEnum: y.PROJECT_NUMBER_PLACES.V }, e), z.success("配置成功"), _();
    } catch (e) {
      console.log(e, "提交保存");
    } finally {
      p.value = false;
    }
  }
  function Q() {
    _(), h();
  }
  function S() {
    c(f.permission.editProjectNumberConfig) && (d.value = true);
  }
  return (t, e) => {
    const l = P("common-button"), o = P("common-input-number"), g = A, D = J, I = q, M = G;
    return j(), x(M, null, { header: s(() => [a("div", Y, [a("span", Z, w(C(y).PROJECT_NUMBER_PLACES.L), 1), C(c)(b.permission.editProjectNumberConfig) ? (j(), x(l, { key: 0, disabled: R.value, style: { float: "right", "margin-left": "8px" }, type: "success", size: "default", loading: p.value, onClick: B }, { default: s(() => e[2] || (e[2] = [m("保存")])), _: 1, __: [2] }, 8, ["disabled", "loading"])) : F("", true)])]), default: s(() => [n(I, { ref_key: "formRef", ref: N, model: r.value, rules: k, "label-width": "140px" }, { default: s(() => [n(g, { prop: "projectQuota", label: "项目人员名额上限" }, { default: s(() => [n(o, { "controls-position": "right", style: { width: "200px" }, min: 1, max: 999, modelValue: r.value.projectQuota, "onUpdate:modelValue": e[0] || (e[0] = (v) => r.value.projectQuota = v) }, null, 8, ["modelValue"])]), _: 1 }), n(g, { "label-width": "18px" }, { default: s(() => [a("div", ee, [a("div", { style: { color: "#409eff", cursor: "pointer" }, onClick: O(S, ["stop"]) }, [e[3] || (e[3] = m(" 自定义人员")), n(D, { style: { "vertical-align": "middle" }, size: 14 }, { default: s(() => [n(C(T))]), _: 1 })]), a("div", te, [e[4] || (e[4] = m(" 已定义 ")), a("span", oe, w(E.value || 0), 1), e[5] || (e[5] = m(" 人 "))])])]), _: 1 }), n(g, { "label-width": "0" }, { default: s(() => e[6] || (e[6] = [a("span", { class: "form-item-tip" }, " 配置说明： ", -1), a("span", { class: "form-item-tip" }, " 项目备案进行中名额分配：每人最多设置名额 （项目驳回、失效、进入投标流程回流增加），超过无法再分配。 ", -1)])), _: 1, __: [6] })]), _: 1 }, 8, ["model"]), n(X, { visible: d.value, "onUpdate:visible": e[1] || (e[1] = (v) => d.value = v), "custom-list": u.value, onSuccess: Q }, null, 8, ["visible", "custom-list"])]), _: 1 });
  };
} };
export {
  me as default
};
