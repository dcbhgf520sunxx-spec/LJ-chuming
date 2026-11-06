import { mF as N } from "../shared/runtime.js";
import { ref as v } from "vue";
import { watch as j } from "vue";
import { watchEffect as O } from "vue";
const G = ({ queryParams: u, factoryIds: s = [], disabledIds: m }) => {
  const f = v(false), a = v([]), p = v([]), t = v({});
  j(() => u.value, () => {
    f.value = false, h();
  }, { immediate: true }), j(() => s, () => {
    c(p.value);
  }, { deep: true });
  async function h() {
    var e;
    if (!((e = u.value) != null && e.type)) return;
    const n = await N(u.value);
    p.value = n, f.value = true, c(p.value);
  }
  function c(n) {
    if (a.value = [], t.value = {}, f.value) {
      const { list: e, obj: l } = T(n, s.value, [], true);
      a.value = e, t.value = l;
    }
  }
  O(() => {
    r(a.value, m == null ? void 0 : m.value);
  });
  function r(n, e = []) {
    var l, i;
    for (let o = 0; o < n.length; o++) (i = (l = n[o]) == null ? void 0 : l.children) != null && i.length ? r(n[o].children, e) : n[o].disabled = e && (e == null ? void 0 : e.includes(n[o].id)) || false;
  }
  function g(n) {
    return n ? a.value.filter((e) => e.id === n) : a.value;
  }
  return { getCurGroupsTree: g, groupsTree: a, groupsObj: t };
};
function T(u, s, m = [], f = false) {
  if (s != null && s.length || f) {
    const a = {}, p = [];
    for (let t = 0; t < u.length; t++) {
      const h = [], c = u[t].workshopList;
      for (let r = 0; r < c.length; r++) {
        const g = [], n = c[r].productionLineList;
        for (let e = 0; e < n.length; e++) {
          const l = [], i = n[e].teamList;
          for (let o = 0; o < i.length; o++) {
            let L = "";
            i[o].userLinkList.forEach((w) => {
              w.boolLeaderEnum && (L = w.userName);
            }), l.push({ id: i[o].id, name: L + " - " + i[o].processName, disabled: m.includes(i[o].id) }), a[i[o].id] = { productionLine: { id: n[e].id, name: n[e].name }, factory: { id: u[t].id, name: u[t].name }, workshop: { id: c[r].id, name: c[r].name }, groupsName: L + " - " + i[o].processName };
          }
          g.push({ id: n[e].id, name: n[e].name, children: l });
        }
        h.push({ id: c[r].id, name: c[r].name, children: g });
      }
      p.push({ id: u[t].id, name: u[t].name, children: h });
    }
    return { list: p, obj: a };
  } else return { list: [], obj: {} };
}
export {
  G as u
};
