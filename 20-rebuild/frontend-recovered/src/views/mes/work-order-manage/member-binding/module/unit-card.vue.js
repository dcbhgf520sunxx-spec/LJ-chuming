import { watch as g } from "vue";
import { ref as _ } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as x } from "vue";
import { createElementBlock as w } from "vue";
import { createVNode as r } from "vue";
import { withCtx as i } from "vue";
import { normalizeStyle as N } from "vue";
import { ElTableColumn as v } from "element-plus";
import { ElCard as E } from "element-plus";
import { b as y } from "../../../../../modules/member-binding-2f5cdd6e.js";
import "../../../../../shared/runtime.js";
const S = { __name: "unit-card", props: { rowData: { type: Array, default: () => [] }, maxHeight: { type: Number, default: 500 } }, setup(u) {
  const s = u;
  g(() => s.rowData, (t) => {
    n.value = [], h(t);
  });
  const n = _([]), h = async (t) => {
    console.log(s.rowData);
    try {
      if (t.length > 0) {
        const e = await y(t);
        console.log(e), n.value = e;
      } else n.value = [];
      d(n.value);
    } catch (e) {
      console.log(e, "获取部件列表失败");
    }
  }, m = ["artNumber"], o = {}, d = (t) => {
    m.forEach((e, a) => {
      let l = 0;
      o[e] = [], t.forEach((c, p) => {
        p === 0 ? o[e].push(1) : c[e] === t[p - 1][e] && c[e] !== void 0 ? (o[e][l] += 1, o[e].push(0)) : (l = p, o[e].push(1));
      });
    });
  }, f = ({ row: t, column: e, rowIndex: a, colunmIndex: l }) => {
    if (m.indexOf(e.property) !== -1) return o[e.property][a] ? [o[e.property][a], 1] : [0, 0];
  };
  return (t, e) => {
    const a = v, l = b("common-table"), c = E;
    return x(), w("div", null, [r(c, { style: N({ width: "500px", height: s.maxHeight + "px" }) }, { default: i(() => [r(l, { data: n.value, "span-method": f, "max-height": s.maxHeight - 40 }, { default: i(() => [r(a, { label: "构件码号", align: "center", prop: "artNumber" }), r(a, { label: "部件编号", align: "center", prop: "assSerialNumber" }), r(a, { label: "部件码号", align: "center", prop: "assNumber" }), r(a, { label: "名称", align: "center", prop: "processName" })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["style"])]);
  };
} };
export {
  S as default
};
