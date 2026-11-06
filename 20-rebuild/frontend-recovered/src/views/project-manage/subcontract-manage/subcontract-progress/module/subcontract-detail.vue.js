import { computed as C } from "vue";
import { watch as N } from "vue";
import { ref as s } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as m } from "vue";
import { createBlock as u } from "vue";
import { withCtx as c } from "vue";
import { createTextVNode as D } from "vue";
import { toDisplayString as E } from "vue";
import { createCommentVNode as M } from "vue";
import { withDirectives as R } from "vue";
import { unref as d } from "vue";
import { createVNode as t } from "vue";
import { isRef as U } from "vue";
import { ElTag as q } from "element-plus";
import { ElTableColumn as L } from "element-plus";
import { vLoading as O } from "element-plus";
import { l as P, u as S, o as z, K as H, kM as A, ba as F } from "../../../../../shared/runtime.js";
function G(r) {
  return P({ module: "project", url: "install-plan/list-supplier-install-product-sum", method: "get", params: r });
}
const J = { __name: "subcontract-detail", props: { modelValue: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} }, globalProject: { type: Object, default: () => {
} } }, emits: ["update:modelValue"], setup(r, { emit: h }) {
  const y = h, a = r, { visible: n, handleClose: _ } = S({ emit: y, props: a }), f = C(() => ({ projectId: a.detailInfo.projectId, supplierId: a.detailInfo.supplierId, monomerId: a.detailInfo.monomerId, areaId: a.detailInfo.areaId, monomerDetailType: a.detailInfo.type }));
  N(n, (l) => {
    l && j();
  });
  const w = s([]), b = s(), p = s(false), v = s([["actualMete", ["to-fixed", 2]]]), { maxHeight: I } = z({ extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", paginate: false }, b);
  function x(l) {
    return F(l, { props: ["actualMete"] });
  }
  async function j() {
    let l = [];
    if (f.value.supplierId) {
      p.value = true;
      try {
        const { content: o = [] } = await G({ ...f.value });
        o.map((i) => {
          i.accountUnit = a.globalProject.projectType === H.BRIDGE.V ? "t" : A.V[i.productType].accountUnit;
        }), l = o;
      } catch (o) {
        console.log("获取分包商任务", o);
      } finally {
        w.value = l, p.value = false;
      }
    }
  }
  return (l, o) => {
    const i = q, e = L, V = g("common-table"), T = g("common-drawer"), k = O;
    return m(), u(T, { ref_key: "drawerRef", ref: b, title: "详情", "close-on-click-modal": false, modelValue: d(n), "onUpdate:modelValue": o[0] || (o[0] = (B) => U(n) ? n.value = B : null), direction: "rtl", "before-close": d(_), size: "80%" }, { titleAfter: c(() => [r.detailInfo.supplierName ? (m(), u(i, { key: 0, effect: "plain", size: "large" }, { default: c(() => [D("分包单位：" + E(r.detailInfo.supplierName), 1)]), _: 1 })) : M("", true)]), content: c(() => [R((m(), u(V, { data: w.value, "show-summary": "", "summary-method": x, "data-format": v.value, "max-height": d(I) }, { default: c(() => [t(e, { label: "序号", type: "index", align: "center", width: "60" }), t(e, { prop: "monomer.name", label: "单体", align: "center", "show-overflow-tooltip": "" }), t(e, { prop: "area.name", label: "区域", align: "center", "show-overflow-tooltip": "" }), t(e, { prop: "name", label: "名称", align: "center", "show-overflow-tooltip": "" }), t(e, { prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": "" }), t(e, { prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": "" }), t(e, { prop: "quantity", label: "任务数", align: "center", "show-overflow-tooltip": "" }), t(e, { prop: "actualQuantity", label: "完成数", align: "center", "show-overflow-tooltip": "" }), t(e, { prop: "actualMete", label: "完成量", align: "center", "show-overflow-tooltip": "" }), t(e, { prop: "accountUnit", label: "单位", align: "center", width: "70", "show-overflow-tooltip": "" })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[k, p.value]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  J as default
};
