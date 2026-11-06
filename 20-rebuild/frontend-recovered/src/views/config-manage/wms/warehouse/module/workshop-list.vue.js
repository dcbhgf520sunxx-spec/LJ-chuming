import { ref as c } from "vue";
import { watch as W } from "vue";
import { useStore as z } from "vuex";
import { resolveComponent as m } from "vue";
import { openBlock as f } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as t } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as I } from "vue";
import { withDirectives as S } from "vue";
import { unref as l } from "vue";
import { createElementVNode as $ } from "vue";
import { toDisplayString as q } from "vue";
import { isRef as D } from "vue";
import { ElNotification as E } from "element-plus";
import { ElTableColumn as L } from "element-plus";
import { vLoading as M } from "element-plus";
import { u as T, hW as U, o as j, hX as X } from "../../../../../shared/runtime.js";
import A from "./workshop-form.vue.js";
const O = { __name: "workshop-list", props: { modelValue: { type: Boolean, require: true } }, emits: ["update:modelValue", "success"], setup(b, { emit: h }) {
  const g = h, v = b, { visible: n, handleClose: w } = T({ emit: g, props: v }), i = c(false), r = c(false);
  W(n, (d) => {
  });
  const { loaded: y, workshopName: x } = U(), k = z(), u = c(), { maxHeight: V } = j({ mainBox: ".delivery-detail", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, u);
  function C() {
    k.dispatch("config/fetchWorkshopName");
  }
  async function B(d) {
    r.value = true;
    try {
      await X(d.id), E({ title: "删除成功", type: "success" }), C();
    } catch (e) {
      console.log("审核", e);
    } finally {
      r.value = false;
    }
  }
  return (d, e) => {
    const p = m("common-button"), s = L, N = m("common-table"), H = m("common-drawer"), R = M;
    return f(), _(H, { ref_key: "drawerRef", ref: u, title: "仓库名称", "close-on-click-modal": false, modelValue: l(n), "onUpdate:modelValue": e[2] || (e[2] = (o) => D(n) ? n.value = o : null), direction: "rtl", "before-close": l(w), "custom-class": "delivery-detail", size: "900px" }, { titleRight: t(() => [a(p, { size: "default", type: "primary", onClick: e[0] || (e[0] = (o) => i.value = true) }, { default: t(() => e[3] || (e[3] = [I("新增")])), _: 1, __: [3] })]), content: t(() => [S((f(), _(N, { data: l(x), "max-height": l(V) }, { default: t(() => [a(s, { label: "序号", type: "index", align: "center", width: "60" }), a(s, { key: "type", prop: "type", label: "类型", align: "center" }, { default: t((o) => [$("span", null, q(o.row.workshopId ? "车间" : "普通"), 1)]), _: 1 }), a(s, { key: "name", prop: "name", label: "名称", align: "center" }), a(s, { label: "操作", width: "130px", align: "center", fixed: "right" }, { default: t(({ row: o }) => [a(p, { icon: "el-icon-delete", type: "danger", size: "default", onClick: (F) => B(o), disabled: r.value }, null, 8, ["onClick", "disabled"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[R, !l(y)]]), a(l(A), { modelValue: i.value, "onUpdate:modelValue": e[1] || (e[1] = (o) => i.value = o) }, null, 8, ["modelValue"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  O as default
};
