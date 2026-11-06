import { ref as i } from "vue";
import { resolveComponent as B } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as H } from "vue";
import { createElementVNode as m } from "vue";
import { unref as s } from "vue";
import { createBlock as g } from "vue";
import { withCtx as n } from "vue";
import { createTextVNode as h } from "vue";
import { withModifiers as k } from "vue";
import { createCommentVNode as x } from "vue";
import { withDirectives as j } from "vue";
import { createVNode as r } from "vue";
import { toDisplayString as P } from "vue";
import { ElTableColumn as q } from "element-plus";
import { ElPopover as G } from "element-plus";
import { vLoading as I } from "element-plus";
import { g as J, d as S, u as F } from "../../../../modules/user-template-config-16e71de8.js";
import { G as p, dI as f, o as K, dJ as O } from "../../../../shared/runtime.js";
import Q from "./module/form.vue.js";
import "../../../../modules/index-9d220fe1.js";
import "../../../../modules/use-users-4d979987.js";
const W = { class: "app-container" }, X = { class: "head-container" }, Y = { style: { "text-align": "right", margin: "0" } }, ie = { __name: "index", setup(Z) {
  const D = i(), V = i(false), v = i(false), b = i(false), y = i(false), _ = i([]), E = i({}), T = i([]);
  C();
  async function C() {
    var t, e, l;
    if (p(f.get)) try {
      const o = await J();
      _.value = o || [], (t = _.value) == null || t.forEach((d) => {
        d.deleteBtn = false;
      }), T.value = (l = (e = _.value) == null ? void 0 : e.filter((d) => d.personCount)) == null ? void 0 : l.map((d) => d.crmPersonTemplateEnum);
    } catch (o) {
      console.log(o, "获取人员模版配置列表失败");
    }
  }
  async function U(t) {
    if (!(!t.personCount || !p(f.edit))) try {
      const e = await F({ crmPersonTemplateEnum: t.crmPersonTemplateEnum });
      E.value = e || {}, v.value = true;
    } catch (e) {
      console.log(e, "获取编辑详情失败");
    }
  }
  const { maxHeight: w } = K({ extraBox: ["head-container"], paginate: false });
  function z() {
    b.value = false, v.value = true;
  }
  async function L(t) {
    b.value = true, await U(t);
  }
  function $(t) {
    t.deleteBtn = true;
  }
  function N(t) {
    t.deleteBtn = false;
  }
  async function A(t) {
    try {
      y.value = true, await S({ crmPersonTemplateEnum: t.crmPersonTemplateEnum }), C();
    } catch (e) {
      console.log(e, "删除人员模板配置列表失败");
    } finally {
      y.value = false, t.deleteBtn = false;
    }
  }
  return (t, e) => {
    const l = B("common-button"), o = q, d = G, M = B("common-table"), R = I;
    return u(), H("div", W, [m("div", X, [s(p)(s(f).add) ? (u(), g(l, { key: 0, class: "filter-item", size: "default", type: "primary", icon: "el-icon-plus", onClick: k(z, ["stop"]) }, { default: n(() => e[1] || (e[1] = [h(" 新增模板 ")])), _: 1, __: [1] })) : x("", true)]), j((u(), g(M, { ref_key: "tableRef", ref: D, data: _.value, "empty-text": "暂无数据", "max-height": s(w), "row-key": "id", style: { width: "100%" } }, { default: n(() => [r(o, { prop: "index", type: "index", label: "序号", align: "center", width: "80" }), r(o, { prop: "crmPersonTemplateEnum", label: "名称类型", align: "center" }, { default: n(({ row: a }) => [m("span", null, P(s(O).VL[a.crmPersonTemplateEnum] || "-"), 1)]), _: 1 }), r(o, { align: "center", key: "personCount", prop: "personCount", "show-overflow-tooltip": true, label: "人员数量" }, { default: n(({ row: a }) => [m("span", null, P(a.personCount || 0), 1)]), _: 1 }), r(o, { label: "操作", width: "130px", align: "center", fixed: "right" }, { default: n(({ row: a }) => [s(p)(s(f).edit) ? (u(), g(l, { key: 0, disabled: !a.personCount, class: "filter-item", size: "default", type: "primary", icon: "el-icon-edit", onClick: k((c) => L(a), ["stop"]) }, null, 8, ["disabled", "onClick"])) : x("", true), r(d, { visible: a.deleteBtn, "onUpdate:visible": (c) => a.deleteBtn = c, placement: "top", width: "180", trigger: "manual" }, { reference: n(() => [s(p)(s(f).del) ? (u(), g(l, { key: 0, disabled: !a.personCount, loading: y.value, type: "danger", icon: "el-icon-delete", size: "default", onClick: k((c) => $(a), ["stop"]) }, null, 8, ["disabled", "loading", "onClick"])) : x("", true)]), default: n(() => [e[4] || (e[4] = m("p", null, "确认删除本条数据吗？", -1)), m("div", Y, [r(l, { size: "default", link: "", type: "primary", onClick: (c) => N(a) }, { default: n(() => e[2] || (e[2] = [h("取消")])), _: 2, __: [2] }, 1032, ["onClick"]), r(l, { type: "primary", size: "default", onClick: (c) => A(a) }, { default: n(() => e[3] || (e[3] = [h("确定")])), _: 2, __: [3] }, 1032, ["onClick"])])]), _: 2, __: [4] }, 1032, ["visible", "onUpdate:visible"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[R, V.value]]), r(Q, { visible: v.value, "onUpdate:visible": e[0] || (e[0] = (a) => v.value = a), isEdit: b.value, "detail-data": E.value, disabledArr: T.value, onRefresh: C }, null, 8, ["visible", "isEdit", "detail-data", "disabledArr"])]);
  };
} };
export {
  ie as default
};
