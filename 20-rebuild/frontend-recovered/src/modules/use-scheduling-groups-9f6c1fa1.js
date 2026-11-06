import { F as w } from "../shared/runtime.js";
import { b as T } from "./box-3fab54f9.js";
import { ref as v } from "vue";
import { watch as j } from "vue";
import { watchEffect as O } from "vue";
const C = ({ queryParams: u, factoryIds: i, disabledIds: h }) => {
  const a = v(false), r = v([]), s = v([]), m = v({});
  j(() => u.value, () => {
    a.value = false, c();
  }, { immediate: true }), j(() => i, () => {
    n(s.value);
  }, { deep: true });
  async function c() {
    var o, t;
    if (!((o = u.value) != null && o.productType) || !((t = u.value) != null && t.boxClassId)) return;
    const e = await T(u.value);
    s.value = e, a.value = true, n(s.value);
  }
  function n(e) {
    if (r.value = [], m.value = {}, a.value) {
      const { list: o, obj: t } = L(e, i.value);
      r.value = o, m.value = t;
    }
  }
  O(() => {
    f(r.value, h == null ? void 0 : h.value);
  });
  function f(e, o = []) {
    var t, l;
    for (let g = 0; g < e.length; g++) e[g].disabled = o && (o == null ? void 0 : o.includes(e[g].id)) || false, (l = (t = e[g]) == null ? void 0 : t.children) != null && l.length && f(e[g].children, o);
  }
  function p(e) {
    return e ? r.value.filter((o) => o.id === e) : r.value;
  }
  return { getCurGroupsTree: p, groupsTree: r, groupsObj: m };
};
async function E({ productType: u, boxClassId: i, _factoryIds: h, disabledIds: a = [] }) {
  if (!u || !i && u !== w.MACHINE_PART.V) return { list: [], obj: {} };
  const r = await T({ productType: u, boxClassId: i }), s = u === w.MACHINE_PART.V;
  return L(r, h, a, s);
}
function L(u, i, h = [], a = false) {
  if (i != null && i.length || a) {
    let r = [];
    const s = {};
    for (let n = 0; n < u.length; n++) ((i == null ? void 0 : i.indexOf(u[n].id)) !== -1 || a) && (r = r.concat(u[n].workshopList));
    const m = [], c = r;
    for (let n = 0; n < c.length; n++) {
      const f = [], p = c[n].productionLineList;
      for (let e = 0; e < p.length; e++) {
        const o = [], t = p[e].groupsList;
        for (let l = 0; l < t.length; l++) o.push({ id: t[l].id, name: t[l].name, disabled: h.includes(t[l].id) }), s[t[l].id] = { productionLine: { id: p[e].id, name: p[e].name }, workshop: { id: c[n].id, name: c[n].name }, groupsName: t[l].name };
        f.push({ id: p[e].id, name: p[e].name, children: o });
      }
      m.push({ id: c[n].id, name: c[n].name, children: f });
    }
    return { list: m, obj: s };
  } else return { list: [], obj: {} };
}
export {
  E as m,
  C as u
};
