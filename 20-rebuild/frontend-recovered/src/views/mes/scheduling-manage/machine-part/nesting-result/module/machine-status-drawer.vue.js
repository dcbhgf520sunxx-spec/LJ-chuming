import { ref as h } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as b } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as c } from "vue";
import { createVNode as s } from "vue";
import { unref as p } from "vue";
import { createTextVNode as H } from "vue";
import { withDirectives as M } from "vue";
import { isRef as S } from "vue";
import { ElButton as L } from "element-plus";
import { ElTableColumn as N } from "element-plus";
import { vLoading as R } from "element-plus";
import { u as q, o as A, ba as I } from "../../../../../../shared/runtime.js";
const U = { __name: "machine-status-drawer", props: { visible: { type: Boolean, default: false } }, emits: ["update:visible", "close", "success"], setup(k, { emit: j }) {
  const m = j, z = k, { visible: i, handleClose: f } = q({ emit: m, props: z, field: "visible", showHook: w, closeHook: () => {
    m("close");
  } }), { maxHeight: v } = A({ extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, minHeight: 300, navbar: false }, i), y = h(false), u = [{ ks: "中医科", doctor: "中医科医生1", ghl: 6, jzl: 5, jz: 2 }, { ks: "中医科", doctor: "中医科医生2", ghl: 9, jzl: 4, jz: 3 }, { ks: "外科", doctor: "外科医生2", ghl: 7, jzl: 3, jz: 4 }, { ks: "外科", doctor: "内科医生3", ghl: 2, jzl: 1, jz: 6 }, { ks: "内科", doctor: "内科医生1", ghl: 2, jzl: 12, jz: 7 }], n = h([]);
  V(u), C();
  async function w() {
    console.log("props.eliminateList:");
  }
  const x = (l) => I(l, { props: ["quantity"] });
  function V(l) {
    const o = {};
    for (let e = 0; e < l.length; e++) {
      const a = l[e].ks;
      o[a] !== void 0 ? o[a].push(e) : o[a] = [e];
    }
    const t = [];
    for (const e in o) t.unshift(e);
    t.forEach((e, a) => {
      const r = o[e][o[e].length - 1], d = D(l, e);
      l.splice(r + 1, 0, d);
    });
  }
  function B({ row: l, column: o, rowIndex: t, columnIndex: e }) {
    if (e === 0) {
      const a = n.value[t], r = a > 0 ? 1 : 0;
      return { rowspan: a, colspan: r };
    }
  }
  function C() {
    let l = 0;
    n.value = [], u.forEach((o, t) => {
      o.index = t, t === 0 ? n.value.push(1) : o.ks === u[t - 1].ks ? (n.value[l] += 1, n.value.push(0)) : (l = t, n.value.push(1));
    });
  }
  function D(l, o) {
    const t = { ks: o, doctor: "小计", jz: 0 };
    return l.forEach((e) => {
      e.ks === o && (t.jz += e.jz ? parseFloat(e.jz) : 0);
    }), t;
  }
  return (l, o) => {
    const t = L, e = N, a = g("common-table"), r = g("common-drawer"), d = R;
    return b(), _(r, { title: "机床状态", modelValue: p(i), "onUpdate:modelValue": o[0] || (o[0] = (E) => S(i) ? i.value = E : null), "show-close": false, "before-close": p(f), size: "50%" }, { titleRight: c(() => [s(t, { size: "default", type: "info", onClick: p(f) }, { default: c(() => o[1] || (o[1] = [H("关闭")])), _: 1, __: [1] }, 8, ["onClick"])]), content: c(() => [M((b(), _(a, { "return-source-data": "", data: u, "show-summary": "", "summary-method": x, "max-height": p(v), style: { width: "100%" }, "span-method": B }, { default: c(() => [s(e, { key: "ks", prop: "ks", "show-overflow-tooltip": true, label: "车间", "min-width": "120", align: "center" }), s(e, { key: "material", prop: "material", label: "当前在手任务", align: "center" }, { default: c(() => [s(e, { key: "doctor", prop: "doctor", label: "厚度", align: "center" }), s(e, { key: "ghl", prop: "ghl", label: "宽度", align: "center" }), s(e, { key: "jzl", prop: "jzl", label: "长度", align: "center" }), s(e, { key: "jz", prop: "jz", label: "数量", align: "center" }), s(e, { key: "jz", prop: "jz", label: "预计时长", align: "center" })]), _: 1 })]), _: 1 }, 8, ["max-height"])), [[d, y.value]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  U as default
};
