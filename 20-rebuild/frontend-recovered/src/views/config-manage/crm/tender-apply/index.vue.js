import { openBlock as m } from "vue";
import { createElementBlock as r } from "vue";
import { createVNode as t } from "vue";
import { withCtx as o } from "vue";
import { unref as n } from "vue";
import { ElCol as a } from "element-plus";
import { ElRow as p } from "element-plus";
import { dG as e } from "../../../../shared/runtime.js";
import l from "./module/bidding-method.vue.js";
import _ from "./module/evaluation-method.vue.js";
import c from "./module/tender-submit.vue.js";
import f from "./module/settlement-method.vue.js";
import u from "./module/work-content-type.vue.js";
import "../components/table-config-card.vue.js";
import "../../../../modules/project-config-3fa4f850.js";
import "../../../../modules/tender-apply-c04ffc5b.js";
const d = { class: "app-container" }, G = { __name: "index", setup(b) {
  return (x, g) => {
    const s = a, i = p;
    return m(), r("div", d, [t(i, { gutter: 20 }, { default: o(() => [t(s, { span: 8 }, { default: o(() => [t(l, { style: { "margin-bottom": "20px" }, permission: n(e).bid }, null, 8, ["permission"])]), _: 1 }), t(s, { span: 8 }, { default: o(() => [t(_, { style: { "margin-bottom": "20px" }, permission: n(e).evaluation }, null, 8, ["permission"])]), _: 1 }), t(s, { span: 8 }, { default: o(() => [t(c, { style: { "margin-bottom": "20px" }, permission: n(e).submit }, null, 8, ["permission"])]), _: 1 })]), _: 1 }), t(i, { gutter: 20 }, { default: o(() => [t(s, { span: 8 }, { default: o(() => [t(f, { style: { "margin-bottom": "20px" }, permission: n(e).settlement }, null, 8, ["permission"])]), _: 1 }), t(s, { span: 12 }, { default: o(() => [t(u, { style: { "margin-bottom": "20px" }, permission: n(e).content }, null, 8, ["permission"])]), _: 1 })]), _: 1 })]);
  };
} };
export {
  G as default
};
