import { _ as x, G as p, j0 as l } from "../../../../../../shared/runtime.js";
import { ref as g } from "vue";
import { inject as T } from "vue";
import { computed as I } from "vue";
import { watchEffect as C } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as w } from "vue";
import { createElementVNode as j } from "vue";
import { createVNode as m } from "vue";
import { withCtx as o } from "vue";
import { normalizeClass as i } from "vue";
import { createTextVNode as r } from "vue";
import { unref as s } from "vue";
import { createBlock as _ } from "vue";
import { createCommentVNode as u } from "vue";
import { withDirectives as L } from "vue";
import { vShow as O } from "vue";
import { resolveDynamicComponent as R } from "vue";
import { defineAsyncComponent as c } from "vue";
import { ElButton as $ } from "element-plus";
import { ElButtonGroup as N } from "element-plus";
import { W as v } from "../../../../../../modules/contract-9b18cc88.js";
const z = { key: 0, class: "drawer-container" }, G = { class: "btn-container" }, S = { __name: "index", setup(q, { expose: y }) {
  const t = g("income"), E = T("parent_data"), { isPutAway: f, projectInfo: P, _commonAttribute: k } = E, b = g(false), A = { income: c(() => l(() => import("./income-info/index.vue.js"), ["static/js/index-d0cba42a.js", "static/js/index-50216080.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/css/index-685b5588.css", "static/js/ProjectInfo-0ace3d5b.js", "static/js/contract-9b18cc88.js", "static/css/ProjectInfo-3fca1930.css", "static/js/detailed-b2f5c54f.js", "static/js/useTableTotal-3d22365a.js", "static/css/detailed-91cda846.css", "static/css/index-91a52adc.css", "static/css/el-radio-group-3b9ac3ad.css"])), fee: c(() => l(() => import("./management-fee-deposit/index.vue.js"), ["static/js/index-9938eac8.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/dialog-c94594ec.js", "static/js/data-039b7fd9.js", "static/css/dialog-48bbf918.css", "static/css/el-radio-group-3b9ac3ad.css", "static/js/contract-9b18cc88.js", "static/css/index-c41f36b8.css"])), interest: c(() => l(() => import("./interest-on-funds/index.vue.js"), ["static/js/index-df8a6580.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/interest-on-funds-096f2ac3.js", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/useTableTotal-3d22365a.js", "static/js/detail-c0b7c620.js"])), report: c(() => l(() => import("./cost-report/index.vue.js"), ["static/js/index-e08e4400.js", "static/js/index-50216080.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/css/index-685b5588.css", "static/js/vue3-count-to.esm-8987f38d.js", "static/js/cost-report-60aee68e.js", "static/js/upload-file-download-812f558c.js", "static/css/index-b6fe3513.css"])), register: c(() => l(() => import("./register/index.vue.js"), ["static/js/index-ac1a1bdb.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/info-8bf1f821.js", "static/js/capital-de0d42db.js", "static/js/UseDetailTable-86117178.js", "static/js/useTableTotal-3d22365a.js", "static/css/UseDetailTable-d5a29c6e.css", "static/js/ClassifyTable-7da77693.js", "static/js/contract-9b18cc88.js", "static/js/capital-143d3c79.js", "static/js/data-039b7fd9.js", "static/css/capital-cba19842.css", "static/css/info-99ed33d0.css", "static/css/el-radio-group-3b9ac3ad.css", "static/css/index-e470c70e.css"])) }, B = I(() => A[t.value]);
  C(() => {
    k.value.btnType = t;
  }), C(() => {
    k.value.btnType = t;
  });
  const D = () => {
    f.value = true;
  };
  return y({ drawerVisible: b }), (F, e) => {
    const n = $, V = N;
    return b.value ? (a(), w("div", z, [j("div", G, [m(V, { class: "btn-group" }, { default: o(() => [m(n, { class: i({ btnBgcClass: t.value === "income" }), onClick: e[0] || (e[0] = (d) => t.value = "income") }, { default: o(() => e[5] || (e[5] = [r("收支信息")])), _: 1, __: [5] }, 8, ["class"]), s(p)(s(v).innerPackAge.register.look) ? (a(), _(n, { key: 0, class: i({ btnBgcClass: t.value === "register" }), onClick: e[1] || (e[1] = (d) => t.value = "register") }, { default: o(() => e[6] || (e[6] = [r("注册资金 ")])), _: 1, __: [6] }, 8, ["class"])) : u("", true), s(p)(s(v).innerPackAge.manageFree.look) ? (a(), _(n, { key: 1, class: i({ btnBgcClass: t.value === "fee" }), disabled: s(P).projectAttribute === 1, onClick: e[2] || (e[2] = (d) => t.value = "fee") }, { default: o(() => e[7] || (e[7] = [r(" 管理费&保证金 ")])), _: 1, __: [7] }, 8, ["class", "disabled"])) : u("", true), s(p)(s(v).innerPackAge.interest.look) ? (a(), _(n, { key: 2, class: i({ btnBgcClass: t.value === "interest" }), onClick: e[3] || (e[3] = (d) => t.value = "interest") }, { default: o(() => e[8] || (e[8] = [r("资金利息 ")])), _: 1, __: [8] }, 8, ["class"])) : u("", true), s(p)(s(v).innerPackAge.statement.look) ? (a(), _(n, { key: 3, class: i({ btnBgcClass: t.value === "report" }), onClick: e[4] || (e[4] = (d) => t.value = "report") }, { default: o(() => e[9] || (e[9] = [r("成本报表 ")])), _: 1, __: [9] }, 8, ["class"])) : u("", true)]), _: 1 }), L(m(n, { class: "close-btn", size: "default", type: "danger", onClick: D }, { default: o(() => e[10] || (e[10] = [r(" 关闭 ")])), _: 1, __: [10] }, 512), [[O, !s(f)]])]), (a(), _(R(B.value), { "btn-type": t.value }, null, 8, ["btn-type"]))])) : u("", true);
  };
} }, K = x(S, [["__scopeId", "data-v-0be242cf"]]);
export {
  K as default
};
