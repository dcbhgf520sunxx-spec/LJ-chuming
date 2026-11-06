import { inject as n } from "vue";
import { computed as F } from "vue";
import { watch as c } from "vue";
import { nextTick as l } from "vue";
import { ref as R } from "vue";
import { resolveComponent as _ } from "vue";
import { resolveDirective as J } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as g } from "vue";
import { withDirectives as q } from "vue";
import { vShow as W } from "vue";
import { unref as t } from "vue";
import { createElementVNode as Z } from "vue";
import { createVNode as s } from "vue";
import { createSlots as ee } from "vue";
import { withCtx as m } from "vue";
import { createTextVNode as I } from "vue";
import { createBlock as S } from "vue";
import { createCommentVNode as x } from "vue";
import { mergeProps as te } from "vue";
import { ElBadge as re } from "element-plus";
import { kz as M, kC as k, B as ae, ky as oe, C as ie, G as j, kB as ne, E as se } from "../../../../../../shared/runtime.js";
import { _ as le } from "../../preview.vue.js";
import "../../../../../../modules/common-913d415d.js";
import "../../../../../../modules/index-61ce89a1.js";
const ue = { class: "head-container" }, de = { key: 0, style: { "margin-right": "6px" } }, ce = { key: 0 }, Pe = { __name: "header", props: { showAble: { type: Boolean, default: false }, submitList: { type: Array, default: () => [] }, rowIds: { type: Array, default: () => [] } }, emits: ["checkSubmit", "showVisible"], setup(b, { expose: v, emit: B }) {
  const Q = n("projectId"), E = n("saveCount"), z = n("priceEditMode"), y = n("relationType"), T = B, V = n("monomerId"), h = n("areaId"), w = n("enclosurePlanId"), C = n("category"), A = b, L = F(() => {
    switch (y) {
      case k.STRUCTURE.V:
        return { monomerId: i.monomerId, areaId: i.areaId, relationType: i.relationType, projectId: i.projectId, type: M.AUXILIARY_MATERIAL.V };
      default:
        return { category: i.category, enclosurePlanId: i.enclosurePlanId, relationType: i.relationType, projectId: i.projectId, type: M.AUXILIARY_MATERIAL.V };
    }
  });
  c(Q, (o) => {
    l(() => {
      e.query.projectId = o, e.toQuery();
    });
  }, { immediate: true }), c(y, (o) => {
    l(() => {
      e.query.relationType = o, y === k.STRUCTURE.V ? (e.query.monomerId = V, e.query.areaId = h) : (e.query.category = C, e.query.enclosurePlanId = w), e.toQuery();
    });
  }, { immediate: true }), c(w, (o) => {
    l(() => {
      e.query.enclosurePlanId = o, e.toQuery();
    });
  }, { immediate: true }), c(V, (o) => {
    l(() => {
      e.query.monomerId = o, e.toQuery();
    });
  }, { immediate: true }), c(h, (o) => {
    l(() => {
      e.query.areaId = o, e.toQuery();
    });
  }, { immediate: true }), c(C, (o) => {
    l(() => {
      e.query.category = o, e.toQuery();
    });
  }, { immediate: true });
  const f = R(false), P = R(false), N = { name: void 0, specification: void 0, serialNumber: void 0 }, { crud: e, query: i, CRUD: $ } = ae(N);
  $.HOOK.handleRefresh = (o, { data: r }) => {
    r.content.forEach((a, u) => {
      a.unitPrice = a.unitPrice || "同上", a.originUnitPrice = a.unitPrice, a.totalPrice = a.mete * (a.unitPrice && typeof a.unitPrice == "number" ? a.unitPrice : 0), a.orderIndex = u + 1;
    });
  };
  function D() {
    T("checkSubmit"), l(() => {
      P.value = A.showAble;
    });
  }
  function U(o, r = false) {
    r && e.data.forEach((a) => {
      a.unitPrice = a.originUnitPrice, a.totalPrice = a.mete * (a.unitPrice && typeof a.unitPrice == "number" ? a.unitPrice : 0);
    }), f.value = o;
  }
  function O() {
    f.value = false, e.toQuery();
  }
  function H() {
    T("showVisible");
  }
  return v({ modifying: f }), (o, r) => {
    const a = _("common-select"), u = _("common-button"), X = _("print-table"), Y = re, G = J("permission");
    return p(), g("div", ue, [q(Z("div", null, [s(a, { modelValue: t(i).useProperty, "onUpdate:modelValue": r[0] || (r[0] = (d) => t(i).useProperty = d), options: t(oe).ENUM, type: "enum", size: "default", class: "filter-item", clearable: "", placeholder: "使用范围" }, null, 8, ["modelValue", "options"]), s(t(ie))], 512), [[W, t(e).searchToggle]]), s(t(se), null, ee({ _: 2 }, [t(i).projectId ? { name: "optRight", fn: m(() => {
      var d;
      return [t(j)(t(e).permission.save) ? (p(), g("span", de, [f.value ? (p(), g("span", ce, [s(u, { type: "warning", size: "default", onClick: r[1] || (r[1] = (K) => U(false, true)) }, { default: m(() => r[4] || (r[4] = [I("取消录入")])), _: 1, __: [4] }), s(u, { type: "success", size: "default", onClick: D }, { default: m(() => r[5] || (r[5] = [I("预览并保存")])), _: 1, __: [5] })])) : (p(), S(u, { key: 1, type: "primary", size: "default", disabled: ((d = t(e).selections) == null ? void 0 : d.length) === 0, onClick: r[2] || (r[2] = (K) => U(true)) }, { default: m(() => r[6] || (r[6] = [I("录入价格")])), _: 1, __: [6] }, 8, ["disabled"]))])) : x("", true), q(s(X, { "api-key": t(y) === t(k).STRUCTURE.V ? "contractAuxiliaryMaterialPrice" : "contractAuxiliaryMaterialPriceEnclosure", params: { ...t(i), ids: A.rowIds }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["api-key", "params"]), [[G, t(e).permission.print]]), t(j)(t(e).permission.log) && t(z) === t(ne).SAVE.V ? (p(), S(Y, { key: 1, value: t(E), hidden: t(E) <= 0 }, { default: m(() => [s(u, { type: "success", size: "default", onClick: H }, { default: m(() => r[7] || (r[7] = [I("保存记录")])), _: 1, __: [7] })]), _: 1 }, 8, ["value", "hidden"])) : x("", true)];
    }), key: "0" } : void 0]), 1024), s(t(le), te({ modelValue: P.value, "onUpdate:modelValue": r[3] || (r[3] = (d) => P.value = d), "modified-data": b.submitList }, o.$attrs, { params: L.value, onSuccess: O }), null, 16, ["modelValue", "modified-data", "params"])]);
  };
} };
export {
  Pe as default
};
