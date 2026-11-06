import { ref as b } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as N } from "vue";
import { withDirectives as S } from "vue";
import { vShow as B } from "vue";
import { unref as e } from "vue";
import { createElementVNode as O } from "vue";
import { createVNode as s } from "vue";
import { withKeys as P } from "vue";
import { createBlock as u } from "vue";
import { withCtx as l } from "vue";
import { createTextVNode as i } from "vue";
import { createCommentVNode as d } from "vue";
import { ElMessage as T } from "element-plus";
import { ElInput as L } from "element-plus";
import { ElButton as Q } from "element-plus";
import { b as R, u as U, d as I, f as h } from "../../../../modules/user-322fe2e0.js";
import { _ as A, B as D, aS as K, xe as V, C as $, G as m, L as v, E as q } from "../../../../shared/runtime.js";
import { _ as F } from "../../../../modules/ExcelUploadBtn-acccae97.js";
import H from "./password-strategy.vue.js";
import "../../../../modules/password-validation-8d186430.js";
import "../../../../modules/user-2de6904c.js";
const M = { class: "head-container", style: { height: "auto", minHeight: "82px" } }, j = { __name: "header", setup(G) {
  const w = { blurry: void 0, deptId: void 0, enabled: void 0 }, { crud: t, query: a } = D(w), p = b(false);
  async function C() {
    try {
      p.value = true, await h(), T({ message: "人员同步成功", type: "success" }), t.toQuery();
    } catch (c) {
      console.log("人员同步失败", c);
    } finally {
      p.value = false;
    }
  }
  function E() {
    t.props.recordVisible = true;
  }
  const f = b(false);
  function k() {
    f.value = true;
  }
  return (c, o) => {
    const x = L, y = g("common-radio-button"), z = Q, _ = g("common-button");
    return r(), N("div", M, [S(O("div", null, [s(x, { modelValue: e(a).blurry, "onUpdate:modelValue": o[0] || (o[0] = (n) => e(a).blurry = n), class: "filter-item", clearable: "", placeholder: "输入名称、手机号或者邮箱搜索", size: "default", style: { width: "260px" }, onKeyup: P(e(t).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(y, { modelValue: e(a).enabled, "onUpdate:modelValue": o[1] || (o[1] = (n) => e(a).enabled = n), options: e(K).ENUM, class: "filter-item", showOptionAll: "", size: "default", type: "enum", onChange: e(t).toQuery }, null, 8, ["modelValue", "options", "onChange"]), s(y, { modelValue: e(a).userType, "onUpdate:modelValue": o[2] || (o[2] = (n) => e(a).userType = n), options: [e(V).ORDINARY_PERSONNEL, e(V).LABOR_PERSONNEL], class: "filter-item", showOptionAll: "", size: "default", type: "enum", onChange: e(t).toQuery }, null, 8, ["modelValue", "options", "onChange"]), s(e($)), e(m)(e(t).permission.async) ? (r(), u(z, { key: 0, loading: p.value, class: "filter-item", size: "default", style: { "margin-left": "0" }, type: "primary", onClick: C }, { default: l(() => o[4] || (o[4] = [i(" 人员同步 ")])), _: 1, __: [4] }, 8, ["loading"])) : d("", true), e(m)(e(t).permission.record) ? (r(), u(_, { key: 1, class: "filter-item", type: "primary", size: "default", onClick: E }, { default: l(() => o[5] || (o[5] = [i(" 变更记录 ")])), _: 1, __: [5] })) : d("", true)], 512), [[B, e(t).searchToggle]]), s(e(q), null, { viewLeft: l(() => [e(m)(e(t).permission.export) ? (r(), u(v, { key: 0, fn: e(R), icon: "el-icon-download", class: "filter-item", size: "default" }, { default: l(() => o[6] || (o[6] = [i(" 人员在线时长导出 ")])), _: 1, __: [6] }, 8, ["fn"])) : d("", true), e(m)(e(t).permission.editPasswordPolicy) ? (r(), u(_, { key: 1, class: "filter-item", type: "primary", size: "default", onClick: k }, { default: l(() => o[7] || (o[7] = [i("密码策略")])), _: 1, __: [7] })) : d("", true), s(e(F), { "upload-fun": e(U), "success-msg": "导入成功", "btn-name": "人员批量导入", "btn-type": "success", "btn-size": "default", onSuccess: e(t).toQuery, class: "filter-item" }, null, 8, ["upload-fun", "onSuccess"]), s(v, { fn: e(I), type: "info", size: "default", class: "filter-item" }, { default: l(() => o[8] || (o[8] = [i(" 人员导入模板下载 ")])), _: 1, __: [8] }, 8, ["fn"])]), _: 1 }), s(H, { modelValue: f.value, "onUpdate:modelValue": o[3] || (o[3] = (n) => f.value = n) }, null, 8, ["modelValue"])]);
  };
} }, se = A(j, [["__scopeId", "data-v-290a21e8"]]);
export {
  se as default
};
