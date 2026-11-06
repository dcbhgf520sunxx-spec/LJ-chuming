import { watch as x } from "vue";
import { ref as i } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as m } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as c } from "vue";
import { createElementVNode as d } from "vue";
import { toDisplayString as R } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as B } from "vue";
import { unref as u } from "vue";
import { isRef as L } from "vue";
import { ElTableColumn as N } from "element-plus";
import { ElTag as T } from "element-plus";
import { e as q } from "../../../../../../modules/area-ca564e60.js";
import { _ as z, u as E } from "../../../../../../shared/runtime.js";
import O from "./plan-form/index.vue.js";
import "../../../../../../modules/enclosure-365a2177.js";
import "./plan-form/form.vue.js";
const S = { class: "wrap" }, A = { class: "wrap-left" }, D = { class: "wrap-right" }, F = { __name: "list", props: { modelValue: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["update:modelValue", "success"], setup(p, { emit: h }) {
  const v = h, n = p, { visible: l, handleClose: y } = E({ emit: v, props: n });
  x(l, (o) => {
    o && (s.value = {}, V());
  });
  const w = i([]), I = i(), g = i(false), s = i({});
  function C(o) {
    s.value = o;
  }
  async function V() {
    var e;
    let o = [];
    if ((e = n.detailInfo) != null && e.projectId) {
      g.value = true;
      try {
        const t = await q(n.detailInfo.projectId);
        t.map((f) => {
          f.projectId = n.detailInfo.projectId;
        }), o = t;
      } catch (t) {
        console.log("获取项目内容及合同量失败", t);
      } finally {
        w.value = o, g.value = false;
      }
    }
  }
  return (o, e) => {
    const t = N, f = b("common-table"), j = T, k = b("common-drawer");
    return m(), _(k, { ref_key: "dialogRef", ref: I, title: "计划", "close-on-click-modal": false, modelValue: u(l), "onUpdate:modelValue": e[1] || (e[1] = (r) => L(l) ? l.value = r : null), direction: "rtl", "before-close": u(y), "custom-class": "invoice-record", size: "80%" }, { titleAfter: c(() => [d("span", null, "项目:" + R(p.detailInfo.project), 1)]), content: c(() => {
      var r;
      return [d("div", S, [d("div", A, [a(f, { data: w.value, "highlight-current-row": "", onCurrentChange: C }, { default: c(() => [a(t, { label: "序号", type: "index", align: "center", width: "60" }), a(t, { prop: "projectContent", label: "围护种类", align: "center", width: "100", "show-overflow-tooltip": "" }), a(t, { prop: "unit", label: "结算单位", align: "center", "min-width": "120", "show-overflow-tooltip": "" }), a(t, { prop: "quantityWork", label: "合同量", align: "center", width: "110", "show-overflow-tooltip": "" })]), _: 1 }, 8, ["data"])]), d("div", D, [(r = s.value) != null && r.id ? (m(), _(u(O), { key: 1, visibleValue: u(l), currentRow: s.value, detailInfo: p.detailInfo, onSuccess: e[0] || (e[0] = (P) => v("success")) }, null, 8, ["visibleValue", "currentRow", "detailInfo"])) : (m(), _(j, { key: 0, type: "info", size: "large" }, { default: c(() => e[2] || (e[2] = [B(" * 请点击左侧项目列表查看详情 ")])), _: 1, __: [2] }))])])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, K = z(F, [["__scopeId", "data-v-cce2e4a4"]]);
export {
  K as default
};
