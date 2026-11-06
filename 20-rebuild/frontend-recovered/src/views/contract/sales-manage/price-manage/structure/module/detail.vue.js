import { ref as u } from "vue";
import { resolveComponent as f } from "vue";
import { openBlock as d } from "vue";
import { createBlock as c } from "vue";
import { withCtx as n } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as h } from "vue";
import { createElementVNode as E } from "vue";
import { toDisplayString as H } from "vue";
import { unref as a } from "vue";
import { createCommentVNode as w } from "vue";
import { withDirectives as L } from "vue";
import { withModifiers as P } from "vue";
import { ElTag as U } from "element-plus";
import { ElTableColumn as z } from "element-plus";
import { vLoading as M } from "element-plus";
import { s as $ } from "../../../../../../modules/structure-70e27af9.js";
import { o as q, gt as A, G as x, L as S } from "../../../../../../shared/runtime.js";
import F from "./adjust.vue.js";
const Q = { __name: "detail", props: { detailInfo: { type: Object, default: () => {
} } }, emits: ["refresh"], setup(v, { emit: y }) {
  const I = y, o = v, { maxHeight: D } = q({ extraBox: ".el-drawer__header", wrapperBox: "", extraHeight: 4 }), r = u([]), g = u({}), m = u(false), { crud: l, detail: k, CRUD: _ } = A();
  _.HOOK.beforeDetailLoaded = async (s) => {
    r.value = [];
    try {
      r.value = (k.content || []).map((e) => (e.rowId = Math.random(), e));
    } catch {
      s.notify("获取构件详情", _.NOTIFICATION_TYPE.ERROR);
    }
  };
  function C(s) {
    g.value = s, m.value = true;
  }
  function V() {
    l.toDetail(o.detailInfo), I("refresh");
  }
  function N() {
    l.cancelDetail();
  }
  return (s, e) => {
    var b;
    const O = U, i = z, T = f("common-button"), B = f("common-table"), R = f("common-drawer"), j = M;
    return d(), c(R, { "append-to-body": "", "close-on-click-modal": false, "before-close": N, visible: a(l).detailVisible, title: `${(b = o.detailInfo) == null ? void 0 : b.name}详情`, "show-close": true, size: "70%" }, { titleAfter: n(() => [t(O, { type: "warning", size: "large", effect: "plain" }, { default: n(() => [e[1] || (e[1] = h("综合单价：")), E("span", null, H(o.detailInfo.originUnitPrice === "同上" ? "-" : o.detailInfo.originUnitPrice), 1)]), _: 1, __: [1] })]), titleRight: n(() => [a(x)(a(l).permission.print) ? (d(), c(S, { key: 0, fn: a($), params: { businessId: o.detailInfo.id }, disabled: r.value.length === 0 }, { default: n(() => e[2] || (e[2] = [h(" 下载 ")])), _: 1, __: [2] }, 8, ["fn", "params", "disabled"])) : w("", true)]), content: n(() => [L((d(), c(B, { data: r.value, "row-key": "rowId", "max-height": a(D) }, { default: n(() => [t(i, { label: "序号", type: "index", align: "center", width: "60" }), t(i, { prop: "name", label: "名称", "min-width": "100px", align: "center" }), t(i, { prop: "serialNumber", label: "编号", "min-width": "100px", align: "center" }), t(i, { prop: "specification", label: "规格", "min-width": "100px", align: "center" }), t(i, { prop: "material", label: "材质", "min-width": "100px", align: "center" }), t(i, { prop: "quantity", label: "数量", "min-width": "80px", align: "center" }), t(i, { prop: "netWeight", label: "单净重(kg)", "min-width": "100px", align: "center" }), a(x)(a(l).permission.edit) && r.value.length > 1 ? (d(), c(i, { key: 0, label: "操作", width: "70", align: "center", fixed: "right" }, { default: n(({ row: p }) => [t(T, { type: "primary", size: "default", icon: "el-icon-edit", onClick: P((G) => C(p), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })) : w("", true)]), _: 1 }, 8, ["data", "max-height"])), [[j, a(l).detailLoading]]), t(a(F), { detail: g.value, "structure-id": o.detailInfo.id, modelValue: m.value, "onUpdate:modelValue": e[0] || (e[0] = (p) => m.value = p), onSuccess: V }, null, 8, ["detail", "structure-id", "modelValue"])]), _: 1 }, 8, ["visible", "title"]);
  };
} };
export {
  Q as default
};
