import { ref as u } from "vue";
import { watch as P } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as g } from "vue";
import { createBlock as E } from "vue";
import { withCtx as i } from "vue";
import { unref as s } from "vue";
import { createElementBlock as D } from "vue";
import { Fragment as T } from "vue";
import { createVNode as n } from "vue";
import { createTextVNode as I } from "vue";
import { createCommentVNode as F } from "vue";
import { withDirectives as H } from "vue";
import { createElementVNode as h } from "vue";
import { toDisplayString as d } from "vue";
import { isRef as z } from "vue";
import { ElNotification as M } from "element-plus";
import { ElTableColumn as Q } from "element-plus";
import { vLoading as W } from "element-plus";
import { b as $, d as j } from "../../../../../modules/index-31ff7034.js";
import { u as A, o as q, rX as O, kD as c } from "../../../../../shared/runtime.js";
import { _ as X } from "../../../../../modules/index-3b2628f3.js";
const Z = { __name: "audit-detail-drawer", props: { visible: { type: Boolean, default: false }, itemInfo: { type: Object } }, emits: ["update:visible", "success"], setup(L, { emit: C }) {
  const y = u(), V = C, r = L, { visible: p, handleClose: k } = A({ emit: V, props: r, field: "visible" }), { maxHeight: N } = q({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, y), m = u(false), f = u(), w = u(), v = u(false), x = u([]);
  P(() => r.visible, (a) => {
    var e;
    a ? (w.value = (e = r.itemInfo) == null ? void 0 : e.auditStatus, R()) : f.value = void 0;
  }, { immediate: true });
  async function R() {
    var a, e;
    if ((a = r.itemInfo) != null && a.id) try {
      v.value = true;
      const { content: l } = await $((e = r.itemInfo) == null ? void 0 : e.id);
      x.value = l.map((o, _) => (o.rowId = _ + "" + Math.random(), o.showUnit = O({ wageQuotaType: o.wageQuotaType }).unit, o));
    } catch (l) {
      console.log("获取工价调整审核详情失败", l);
    } finally {
      v.value = false;
    }
  }
  async function S(a) {
    var e;
    try {
      m.value = true, f.value = a, await j({ id: (e = r.itemInfo) == null ? void 0 : e.id, status: a }), w.value = a, M({ title: "审核成功", type: "success" }), V("success"), k();
    } catch (l) {
      console.log("工价调整审核失败", l);
    } finally {
      m.value = false;
    }
  }
  return (a, e) => {
    const l = b("common-button"), o = Q, _ = b("common-table"), U = b("common-drawer"), B = W;
    return g(), E(U, { ref_key: "drawerRef", ref: y, title: "班组工价审核详情", modelValue: s(p), "onUpdate:modelValue": e[2] || (e[2] = (t) => z(p) ? p.value = t : null), direction: "rtl", "before-close": s(k), size: "60%" }, { titleRight: i(() => [w.value & s(c).UNREVIEWED.V ? (g(), D(T, { key: 0 }, [n(l, { size: "default", type: "success", auditLoading: m.value && f.value & s(c).PASS.V, onClick: e[0] || (e[0] = (t) => S(s(c).PASS.V)) }, { default: i(() => e[3] || (e[3] = [I(" 通过 ")])), _: 1, __: [3] }, 8, ["auditLoading"]), n(l, { size: "default", type: "danger", auditLoading: m.value && f.value & s(c).REFUSE.V, onClick: e[1] || (e[1] = (t) => S(s(c).REFUSE.V)) }, { default: i(() => e[4] || (e[4] = [I(" 拒绝 ")])), _: 1, __: [4] }, 8, ["auditLoading"])], 64)) : F("", true)]), content: i(() => [H((g(), E(_, { "row-key": "rowId", data: x.value, "max-height": s(N), style: { width: "100%" } }, { default: i(() => [n(o, { label: "序号", type: "index", align: "center", width: "60" }), n(s(X), { showFactory: "", showWorkshop: "", showProductionLine: "", showTeam: "" }), n(o, { prop: "processName", "show-overflow-tooltip": "", label: "涉及工序" }, { default: i(({ row: t }) => [h("span", null, d(t.processName), 1)]), _: 1 }), n(o, { prop: "oldPrice", "show-overflow-tooltip": "", label: "内部定额" }, { default: i(({ row: t }) => [h("span", null, d(t.oldPrice) + d(t.showUnit), 1)]), _: 1 }), n(o, { prop: "newPrice", "show-overflow-tooltip": "", label: "变更后" }, { default: i(({ row: t }) => [h("span", null, d(t.newPrice) + d(t.showUnit), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[B, v.value]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  Z as default
};
